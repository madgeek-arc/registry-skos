package eu.openminted.registry.skos.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType
@XmlRootElement
public class ConceptScheme implements Identifiable {

    private String uri;
    private String title;
    private String description;
    private List<String> hasTopConcept;

    @Override
    public String getId() {
        return uri;
    }

    @Override
    public void setId(String s) {
        this.uri = s;
    }

    @XmlElement(required = true)
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @XmlElement(required = true)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement
    public List<String> getHasTopConcept() {
        return hasTopConcept;
    }

    public void setHasTopConcept(List<String> hasTopConcept) {
        this.hasTopConcept = hasTopConcept;
    }
}
