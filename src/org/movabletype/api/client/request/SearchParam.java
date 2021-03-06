package org.movabletype.api.client.request;

import java.util.LinkedHashMap;

public class SearchParam {

    String search;
    int blog_id;
    String IncludeBlogs;
    String ExcludeBlogs;
    int limit;
    int offset;
    String SearchSortBy;
    String SearchResultDisplay;
    int SearchMaxResults;
    String searchClass = "";

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(int blog_id) {
        this.blog_id = blog_id;
    }

    public String getIncludeBlogs() {
        return IncludeBlogs;
    }

    public void setIncludeBlogs(String includeBlogs) {
        IncludeBlogs = includeBlogs;
    }

    public String getExcludeBlogs() {
        return ExcludeBlogs;
    }

    public void setExcludeBlogs(String excludeBlogs) {
        ExcludeBlogs = excludeBlogs;
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

    public String getSearchSortBy() {
        return SearchSortBy;
    }

    /**
     * @param searchSortBy  SortBy.TITLE, SortBy.CREATED_ON
     */
    public void setSearchSortBy(String searchSortBy) {
        SearchSortBy = searchSortBy;
    }

    public String getSearchResultDisplay() {
        return SearchResultDisplay;
    }

    /**
     * @param searchResultDisplay  SortOrder.ASCEND, SortOrder.DESCEND
     */
    public void setSearchResultDisplay(String searchResultDisplay) {
        SearchResultDisplay = searchResultDisplay;
        
    }

    public int getSearchMaxResults() {
        return SearchMaxResults;
    }

    public void setSearchMaxResults(int searchMaxResults) {
        SearchMaxResults = searchMaxResults;
    }

    public String getSearchClass() {
        return searchClass;
    }

    public void setSearchClass(String searchClass) {
        this.searchClass = searchClass;
    }

    public String getQueryString() {
        LinkedHashMap<String, Object> queryItems = new LinkedHashMap<String, Object>();
        queryItems.put("search", search);
        if (blog_id != 0)
            queryItems.put("blog_id", blog_id);
        queryItems.put("IncludeBlogs", IncludeBlogs);
        queryItems.put("ExcludeBlogs", ExcludeBlogs);
        if (limit != 0)
            queryItems.put("limit", limit);
        if (offset != 0)
            queryItems.put("offset", offset);
        queryItems.put("SearchSortBy", SearchSortBy);
        queryItems.put("SearchResultDisplay", SearchResultDisplay);
        if (SearchMaxResults != 0)
            queryItems.put("SearchMaxResults", SearchMaxResults);
        if (searchClass.equals("entry") || searchClass.equals("page"))
            queryItems.put("class", searchClass);
        return UrlQueryString.buildQueryString(queryItems);
    }
}
