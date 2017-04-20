package org.movabletype.api.client.request;

import java.util.LinkedHashMap;

public class FolderSearchParam {
    int site_id;
    int folder_id;
    int limit;
    int offset;
    String sortBy;
    String sortOrder;
    String fields;
    String searchFields;
    String search;
    String includeIds;
    String excludeIds;
    int top;
    String dateField;
    String dateFrom;
    String dateTo;
    int maxDepth;
    int includeCurrent;
    
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

    public String getDateField() {
        return dateField;
    }

    public void setDateField(String dateField) {
        this.dateField = dateField;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
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

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getFolder_id() {
        return folder_id;
    }

    public void setFolder_id(int folder_id) {
        this.folder_id = folder_id;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public int getIncludeCurrent() {
        return includeCurrent;
    }

    public void setIncludeCurrent(int includeCurrent) {
        this.includeCurrent = includeCurrent;
    }

    public String getQueryString() {
        LinkedHashMap<String, Object> queryItems = new LinkedHashMap<String, Object>();
        queryItems.put("search", search);
        queryItems.put("searchFields", searchFields);
        if (site_id != 0)
            queryItems.put("site_id", site_id);
        if (folder_id != 0)
            queryItems.put("folder_id", folder_id);
        if (limit != 0)
            queryItems.put("limit", limit);
        if (offset != 0)
            queryItems.put("offset", offset);
        queryItems.put("sortBy", sortBy);
        queryItems.put("sortOrder", sortOrder);
        queryItems.put("fields", fields);
        queryItems.put("searchFields", searchFields);
        queryItems.put("includeIds", includeIds);
        queryItems.put("excludeIds", excludeIds);
        if (top != 0)
            queryItems.put("top", top);      
        queryItems.put("dateField", dateField);
        queryItems.put("dateFrom", dateFrom);
        queryItems.put("dateTo", dateTo);
        if (maxDepth != 0)
            queryItems.put("maxDepth", maxDepth);     
        if (includeCurrent != 0)
            queryItems.put("includeCurrent", includeCurrent);     
        return UrlQueryString.buildQueryString(queryItems);
    }
}
