package eu.openminted.registry.skos.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import java.net.MalformedURLException;
import java.net.URL;

@Configuration
@EnableSwagger2
@PropertySource(value = { "classpath:application.properties", "classpath:registry.properties"} )
public class SwaggerConfig {


    @Value("${openminted.debug:#{false}}")
    public boolean isLocalhost;

    @Value("${registry.host}")
    public String host;

    @Autowired
    ServletContext context;

    private RelativePathProvider pathProvider() {
        if(isLocalhost) {
            return new RelativePathProvider(context);
        } else {
            return new RelativePathProvider(context) {
                @Override
                protected String applicationPath() {
                    return "";
                }
            };
        }
    }

    @Bean
    public Docket api() throws MalformedURLException {
        URL hostURL = new URL(host);
        return new Docket(DocumentationType.SWAGGER_2)
                .pathProvider(pathProvider())
                .host(isLocalhost ? null : hostURL.getHost() + hostURL.getPath())
                .select()
                .apis(isLocalhost ? RequestHandlerSelectors.basePackage("eu.openminted.registry") :
                        RequestHandlerSelectors.basePackage("eu.openminted.registry.skos"))
                .paths(PathSelectors.any())
                .build();
    }
}
