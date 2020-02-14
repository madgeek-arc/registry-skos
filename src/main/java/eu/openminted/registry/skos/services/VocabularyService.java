package eu.openminted.registry.skos.services;


import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.skos.domain.Vocabulary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VocabularyService extends ResourceManager<Vocabulary> {

    public VocabularyService() {
        super(Vocabulary.class);
    }

    @Override
    public String getResourceType() {
        return "vocabulary";
    }

    public List<Vocabulary> getAllVocabularies(){
        return getAll(new FacetFilter(), SecurityContextHolder.getContext().getAuthentication()).getResults();
    }

}
