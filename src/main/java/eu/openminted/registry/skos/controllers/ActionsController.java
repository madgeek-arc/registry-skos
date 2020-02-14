package eu.openminted.registry.skos.controllers;

import eu.openminted.registry.skos.services.ConceptService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionsController{

    @Autowired
    private ConceptService conceptService;

    private final Logger logger = LogManager.getLogger(ActionsController.class);

    @GetMapping(value = "/data", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllData(
            @RequestParam("uri") String vocabulary
    ){
        return new ResponseEntity(conceptService.getAllData(vocabulary),HttpStatus.OK);
    }

}