package eu.openminted.registry.skos.domain;

import javax.xml.bind.annotation.XmlType;

@XmlType
public enum LanguagesEnum {
    ENGLISH("en"),
    FRENCH("fr"),
    GERMAN("de"),
    GREEK("gr");


    LanguagesEnum(String en) {

    }
}
