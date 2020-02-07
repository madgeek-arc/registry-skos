package org.madgik.skos.services;

import org.madgik.skos.domain.Ontology;

public class TermService extends ResourceManager<Ontology> {

    public TermService() {
        super(Ontology.class);
    }

    @Override
    public String getResourceType() {
        return resourceType.getName();
    }

    public void test(){
    }

}
