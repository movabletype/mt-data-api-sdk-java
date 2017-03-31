package org.movabletype.data.api.request;

import java.util.LinkedHashMap;

public class CategorySearchParam {
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
    String status;
    int maxComments;
    int maxTrackbacks;
    int no_text_filter;
    String dateField;
    String dateFrom;
    String dateTo;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMaxComments() {
        return maxComments;
    }

    public void setMaxComments(int maxComments) {
        this.maxComments = maxComments;
    }

    public int getMaxTrackbacks() {
        return maxTrackbacks;
    }

    public void setMaxTrackbacks(int maxTrackbacks) {
        this.maxTrackbacks = maxTrackbacks;
    }

    public int getNo_text_filter() {
        return no_text_filter;
    }

    public void setNo_text_filter(int no_text_filter) {
        this.no_text_filter = no_text_filter;
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

    public String getQueryString() {
        LinkedHashMap<String, Object> queryItems = new LinkedHashMap<String, Object>();
        queryItems.put("search", search);
        if (site_id != 0)
            queryItems.put("site_id", site_id);
        queryItems.put("search", search);
        queryItems.put("searchFields", searchFields);
        if (offset != 0)
            queryItems.put("offset", limit);
        if (offset != 0)
            queryItems.put("offset", offset);
        queryItems.put("sortBy", sortBy);
        queryItems.put("sortOrder", sortOrder);
        queryItems.put("fields", fields);
        queryItems.put("includeIds", includeIds);
        queryItems.put("excludeIds", excludeIds);
        queryItems.put("status", status);
        if (maxComments != 0)
            queryItems.put("maxComments", maxComments);
        if (maxTrackbacks != 0)
            queryItems.put("maxTrackbacks", maxTrackbacks);
        if (no_text_filter != 0)
            queryItems.put("no_text_filter", no_text_filter);
        queryItems.put("dateField", dateField);
        queryItems.put("dateFrom", dateFrom);
        queryItems.put("dateTo", dateTo);
        return UrlQueryString.buildQueryString(queryItems);
    }

}
