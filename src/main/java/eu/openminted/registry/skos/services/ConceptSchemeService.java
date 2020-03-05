package eu.openminted.registry.skos.services;

import eu.openminted.registry.skos.domain.ConceptScheme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ConceptSchemeService extends ResourceManager<ConceptScheme> {

    private static final Logger logger = LogManager.getLogger(ConceptSchemeService.class);


    public ConceptSchemeService() {
        super(ConceptScheme.class);
    }

    @Override
    public String getResourceType() {
        return "concept_scheme";
    }
}
