package org.movabletype.api.client.request;

import java.util.LinkedHashMap;

public class TemplateSearchParam {

    int site_id;
    String search;
    String searchFields;
    int limit;
    int offset;
    String sortBy;
    String sortOrder;
    String fields;
    String includeIds;
    String excludeIds;
    String type;

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getSearchFields() {
        return searchFields;
    }

    public void setSearchFields(String searchFields) {
        this.searchFields = searchFields;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * @param sortOrder SortOrder.ASCEND, SortOrder.DESCEND ...
     */
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getIncludeIds() {
        return includeIds;
    }

    public void setIncludeIds(String includeIds) {
        this.includeIds = includeIds;
    }

    public String getExcludeIds() {
        return excludeIds;
    }

    public void setExcludeIds(String excludeIds) {
        this.excludeIds = excludeIds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQueryString() {
        LinkedHashMap<String, Object> queryItems = new LinkedHashMap<String, Object>();
        if (site_id != 0)
            queryItems.put("site_id", site_id);
        queryItems.put("search", search);
        queryItems.put("search", search);
        queryItems.put("searchFields", searchFields);
        if (limit != 0)
            queryItems.put("limit", limit);
        if (offset != 0)
            queryItems.put("offset", offset);
        queryItems.put("sortBy", sortBy);
        queryItems.put("sortOrder", sortOrder);
        queryItems.put("fields", fields);
        queryItems.put("sortOrder", sortOrder);
        queryItems.put("includeIds", includeIds);
        queryItems.put("excludeIds", excludeIds);
        queryItems.put("type", type);
        return UrlQueryString.buildQueryString(queryItems);
    }

}
