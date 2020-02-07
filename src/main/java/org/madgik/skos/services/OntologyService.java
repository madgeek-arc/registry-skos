package org.madgik.skos.services;

import org.madgik.skos.domain.Ontology;

public class OntologyService extends ResourceManager<Ontology> {

    public OntologyService() {
        super(Ontology.class);
    }

    @Override
    public String getResourceType() {
        return resourceType.getName();
    }

}
