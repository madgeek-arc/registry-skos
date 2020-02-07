package org.madgik.skos.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement
public class Term implements Identifiable {


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

    @ApiModelProperty(position = 3)
    private Ontology ontology;

    @ApiModelProperty(position = 3)
    private Term broader;

    @ApiModelProperty(position = 3)
    private Term narrower;

    public Term(String id, String name, Ontology ontology, Term broader, Term narrower) {
        this.id = id;
        this.name = name;
        this.ontology = ontology;
        this.broader = broader;
        this.narrower = narrower;
    }

    public Term() {
    }
    @XmlElement
    public Term getBroader() {
        return broader;
    }

    public void setBroader(Term broader) {
        this.broader = broader;
    }
    @XmlElement
    public Term getNarrower() {
        return narrower;
    }

    public void setNarrower(Term narrower) {
        this.narrower = narrower;
    }
    @XmlElement
    public Ontology getOntology() {
        return ontology;
    }

    public void setOntology(Ontology ontology) {
        this.ontology = ontology;
    }


    @Override
    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(required = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
