package eu.openminted.registry.skos.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;

@XmlType
@XmlRootElement
public class Vocabulary implements Identifiable {


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

    public Vocabulary() {
    }

    public Vocabulary(String id, String name) {
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

    @XmlElement
    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vocabulary that = (Vocabulary) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(URI, that.URI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, URI);
    }
}
