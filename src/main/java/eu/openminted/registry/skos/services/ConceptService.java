package eu.openminted.registry.skos.services;


import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.skos.domain.Concept;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConceptService extends ResourceManager<Concept> {

    private static final Logger logger = LogManager.getLogger(ConceptService.class);

    public ConceptService() {
        super(Concept.class);
    }

    @Override
    public String getResourceType() {
        return "concept";
    }

    public List<Concept> getAllData(String vocabulary) {
        FacetFilter facetFilter = new FacetFilter();
        facetFilter.setKeyword(vocabulary);
//        facetFilter.addFilter("vocabulary", vocabulary);
        return getAll(facetFilter, SecurityContextHolder.getContext().getAuthentication()).getResults();
    }

}
