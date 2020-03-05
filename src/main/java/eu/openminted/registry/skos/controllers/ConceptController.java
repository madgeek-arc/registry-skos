package eu.openminted.registry.skos.controllers;

import eu.openminted.registry.skos.domain.Concept;
import eu.openminted.registry.skos.services.ConceptService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("concepts")
public class ConceptController extends ResourceController<Concept, Authentication> {

    private static final Logger logger = LogManager.getLogger(ConceptController.class);
    private final ConceptService conceptService;

    @Autowired
    public ConceptController(ConceptService conceptService) {
        super(conceptService);
        this.conceptService = conceptService;
    }

}
