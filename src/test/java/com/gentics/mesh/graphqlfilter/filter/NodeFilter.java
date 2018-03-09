package com.gentics.mesh.graphqlfilter.filter;

import com.gentics.mesh.graphqlfilter.model.Node;

import java.util.Arrays;
import java.util.List;

public class NodeFilter extends MainFilter<Node> {

    private static NodeFilter instance;

    public static NodeFilter filter() {
        if (instance == null) {
            instance = new NodeFilter();
        }
        return instance;
    }

    private NodeFilter() {
        super("NodeFilter", "Filters Nodes");
    }

    @Override
    protected List<FilterField<Node, ?>> getFilters() {
        return Arrays.asList(
            new MappedFilter<>("uuid", "Filters by uuid", StringFilter.filter(), Node::getUuid),
            new MappedFilter<>("schema", "Filters by Schema", SchemaFilter.filter(), Node::getSchema),
            new MappedFilter<>("language", "Filters by Language", StringFilter.filter(), Node::getLanguage),
            new MappedFilter<>("name", "Filters by name", StringFilter.filter(), Node::getName),
            new MappedFilter<>("published", "Filters by published state", BooleanFilter.filter(), Node::isPublished)
        );
    }
}
