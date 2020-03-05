package eu.openminted.registry.skos.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
import java.util.Map;

@XmlType
@XmlRootElement
public class Concept implements Identifiable {

    private String uri;
    private String name;
    private Map<LanguagesEnum, String> prefLabels;
    private List<String> altLabels;
    private String topConceptOf;
    private List<String> broader;
    private List<String> narrower;

    public Concept() {
    }

    public Concept(String uri, String name, List<String> broader, List<String> narrower) {
        this.uri = uri;
        this.name = name;
        this.broader = broader;
        this.narrower = narrower;
    }

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

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public Map<LanguagesEnum, String> getPrefLabels() {
        return prefLabels;
    }

    public void setPrefLabels(Map<LanguagesEnum, String> prefLabels) {
        this.prefLabels = prefLabels;
    }

    @XmlElement
    public List<String> getAltLabels() {
        return altLabels;
    }

    public void setAltLabels(List<String> altLabels) {
        this.altLabels = altLabels;
    }

    @XmlElement
    public String getTopConceptOf() {
        return topConceptOf;
    }

    public void setTopConceptOf(String topConceptOf) {
        this.topConceptOf = topConceptOf;
    }

    @XmlElement
    public List<String> getBroader() {
        return broader;
    }

    public void setBroader(List<String> broader) {
        this.broader = broader;
    }

    @XmlElement
    public List<String> getNarrower() {
        return narrower;
    }

    public void setNarrower(List<String> narrower) {
        this.narrower = narrower;
    }
}
