package org.madgik.skos.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.madgik.skos.domain.Ontology;
import org.madgik.skos.services.OntologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ontology")
public class OntologyController extends ResourceController<Ontology, Authentication> {

    private OntologyService ontologyService;

    @Autowired
    OntologyController(OntologyService ontologyService) {
        super(ontologyService);
        this.ontologyService = ontologyService;
    }

    private final Logger logger = LogManager.getLogger(OntologyController.class);

}