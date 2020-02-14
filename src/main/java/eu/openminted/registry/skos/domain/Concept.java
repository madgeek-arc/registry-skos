package eu.openminted.registry.skos.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType
@XmlRootElement
public class Concept implements Identifiable {


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

    @ApiModelProperty(position = 3, example = "String (required)", required = true)
    private String URI;

    @ApiModelProperty(position = 4)
    private String vocabulary;

    @ApiModelProperty(position = 5)
    private String broader;

    @ApiModelProperty(position = 6)
    private String narrower;

    public Concept(String id, String name, String URI, String vocabulary, String broader, String narrower) {
        this.id = id;
        this.name = name;
        this.URI = URI;
        this.vocabulary = vocabulary;
        this.broader = broader;
        this.narrower = narrower;
    }

    public Concept() {
    }

    @XmlElement
    public String getBroader() {
        return broader;
    }

    public void setBroader(String broader) {
        this.broader = broader;
    }

    @XmlElement
    public String getNarrower() {
        return narrower;
    }

    public void setNarrower(String narrower) {
        this.narrower = narrower;
    }

    @XmlElement
    public String getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(String vocabulary) {
        this.vocabulary = vocabulary;
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

    @XmlElement
    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

}
