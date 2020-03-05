package eu.openminted.registry.skos.controllers;

import eu.openminted.registry.skos.domain.ConceptScheme;
import eu.openminted.registry.skos.services.ConceptSchemeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("conceptScheme")
public class ConceptSchemeController extends ResourceController<ConceptScheme, Authentication> {

    private static final Logger logger = LogManager.getLogger(ConceptSchemeController.class);
    private final ConceptSchemeService conceptSchemeService;

    @Autowired
    public ConceptSchemeController(ConceptSchemeService conceptSchemeService) {
        super(conceptSchemeService);
        this.conceptSchemeService = conceptSchemeService;
    }

}
