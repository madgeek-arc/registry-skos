package org.madgik.skos.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(name = "https://skos.org")
public class Ontology implements Identifiable {


    // Basic Service Information
    /**
     * Global unique and persistent identifier of the ontology.
     */
    @ApiModelProperty(position = 1)
    private String id;

    /**
     * Brief and descriptive name of ontology.
     */
    @ApiModelProperty(position = 2, example = "String (required)", required = true)
    private String name;

    public Ontology() {
    }

    public Ontology(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
