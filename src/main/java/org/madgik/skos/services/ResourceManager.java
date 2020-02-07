package org.madgik.skos.services;

import eu.openminted.registry.core.domain.Browsing;
import eu.openminted.registry.core.domain.FacetFilter;
import eu.openminted.registry.core.domain.Resource;
import eu.openminted.registry.core.service.AbstractGenericService;
import eu.openminted.registry.core.service.ParserService;
import eu.openminted.registry.core.service.SearchService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.madgik.skos.domain.Identifiable;
import org.madgik.skos.exceptions.ResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class ResourceManager<T extends Identifiable> extends AbstractGenericService<T> implements ResourceService<T, Authentication> {

    private static final Logger logger = LogManager.getLogger(ResourceManager.class);

    public ResourceManager(Class<T> typeParameterClass) {
        super(typeParameterClass);
    }

    @Override
    public T get(String id) {
        return deserialize(whereID(id, true));
    }

    @Override
    public Resource getResource(String id) {
        return whereID(id, true);
    }

    @Override
    public Browsing<T> getAll(FacetFilter ff, Authentication auth) {
        ff.setBrowseBy(getBrowseBy());
        return getResults(ff);
    }

    @Override
    public Browsing<T> getMy(FacetFilter ff, Authentication auth) {
        return null;
    }

    @Override
    public T add(T t, Authentication auth) {
        if (exists(t)) {
            throw new ResourceException(String.format("%s with id = '%s' already exists!", resourceType.getName(), t.getId()), HttpStatus.CONFLICT);
        }
        String serialized = serialize(t);
        Resource created = new Resource();
        created.setPayload(serialized);
        created.setResourceType(resourceType);
        resourceService.addResource(created);
        logger.debug("Adding Resource {}", t);
        return t;
    }

    @Override
    public T update(T t, Authentication auth) {
        Resource existing = whereID(t.getId(), true);
        existing.setPayload(serialize(t));
        existing.setResourceType(resourceType);
        resourceService.updateResource(existing);
        logger.debug("Updating Resource {}", t);
        return t;
    }

    @Override
    public void delete(T t) {
        del(t);
    }

    @Override
    public T del(T t) {
        resourceService.deleteResource(whereID(t.getId(), true).getId());
        logger.debug("Deleting Resource {}", t);
        return t;
    }

    @Override
    public Map<String, List<T>> getBy(String field) {
        return groupBy(field).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
                entry -> entry.getValue()
                        .stream()
                        .map(resource -> deserialize(where("id", resource.getId(), true)))
                        .collect(Collectors.toList())));
    }

    @Override
    public List<T> getSome(String... ids) {
        return whereIDin(ids).stream().filter(Objects::nonNull).map(this::deserialize).collect(Collectors.toList());
    }

    @Override
    public T get(String field, String value) {
        return deserialize(where(field, value, true));
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<T> delAll() {
        FacetFilter facetFilter = new FacetFilter();
        facetFilter.setQuantity(10000);
        logger.info("Deleting all Resources");
        return getAll(facetFilter, null).getResults().stream().map(this::del).collect(Collectors.toList());
    }

    @Override
    public T validate(T t) {
        logger.debug("Validating Resource {}", t);
        return t;
    }

    public ParserService.ParserServiceTypes getCoreFormat() {
        return ParserService.ParserServiceTypes.XML;
    }

    protected boolean exists(T t) {
        return whereID(t.getId(), false) != null;
    }

    protected String serialize(T t) {
        String ret = parserPool.serialize(t, getCoreFormat());
        if (ret.equals("failed")) {
            throw new ResourceException(String.format("Not a valid %s!", resourceType.getName()), HttpStatus.BAD_REQUEST);
        }
        return ret;
    }

    protected T deserialize(Resource resource) {
        return parserPool.deserialize(resource, typeParameterClass);
    }

    protected Map<String, List<Resource>> groupBy(String field) {
        FacetFilter ff = new FacetFilter();
        ff.setResourceType(resourceType.getName());
        ff.setQuantity(1000);
        return searchService.searchByCategory(ff, field);
    }

    protected List<Resource> whereIDin(String... ids) {
        return Stream.of(ids).map((String id) -> whereID(id, false)).collect(Collectors.toList());
    }

    protected Resource whereID(String id, boolean throwOnNull) {
        return where(String.format("%s_id", resourceType.getName()), id, throwOnNull);
    }

    protected Resource where(String field, String value, boolean throwOnNull) {
        Resource ret;
        try {
            ret = searchService.searchId(resourceType.getName(), new SearchService.KeyValue(field, value));
            if (throwOnNull && ret == null) {
                throw new ResourceException(String.format("%s does not exist!", resourceType.getName()), HttpStatus.NOT_FOUND);
            }
        } catch (UnknownHostException e) {
            throw new ResourceException(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ret;
    }

}
