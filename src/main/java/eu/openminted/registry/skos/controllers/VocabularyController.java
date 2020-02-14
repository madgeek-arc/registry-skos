package eu.openminted.registry.skos.controllers;

import eu.openminted.registry.skos.domain.Vocabulary;
import eu.openminted.registry.skos.services.VocabularyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vocabularies")
public class VocabularyController extends ResourceController<Vocabulary, Authentication> {

    private VocabularyService vocabularyService;

    @Autowired
    public VocabularyController(VocabularyService vocabularyService) {
        super(vocabularyService);
        this.vocabularyService = vocabularyService;
    }

    private final Logger logger = LogManager.getLogger(VocabularyController.class);

    @GetMapping(value = "", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllVocabularies(){
        return new ResponseEntity(vocabularyService.getAllVocabularies(),HttpStatus.OK);
    }

}