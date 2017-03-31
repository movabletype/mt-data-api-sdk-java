package org.movabletype.data.api.request;

import java.util.LinkedHashMap;

public class AssetSearchParam {
    int site_id;
    String search;
    String searchFields;
    int limit;
    int offset;
    String _class;
    String sortBy;
    String sortOrder;
    String fields;
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

    public String get_Class() {
        return _class;
    }

    public void set_Class(String _class) {
        this._class = _class;
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
        queryItems.put("class", _class);
        queryItems.put("sortBy", sortBy);
        queryItems.put("sortOrder", sortOrder);
        queryItems.put("fields", fields);
        queryItems.put("dateField", dateField);
        queryItems.put("dateFrom", dateFrom);
        queryItems.put("dateTo", dateTo);
        return UrlQueryString.buildQueryString(queryItems);
    }

}
