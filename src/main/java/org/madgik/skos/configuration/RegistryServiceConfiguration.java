package org.madgik.skos.configuration;

import org.madgik.skos.domain.Ontology;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

@Configuration
@EnableWebMvc
@ComponentScan(value = {
        "eu.openminted.registry.core",
        "org.madgik.skos.services"
})
@PropertySource(value = { "classpath:application.properties", "classpath:registry.properties"} )
public class RegistryServiceConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Bean
    JAXBContext eicJAXBContext() throws JAXBException {
        return JAXBContext.newInstance(Ontology.class);

    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
