package org.movabletype.api.client.request;

import java.util.LinkedHashMap;

public class StatSearchParam {

    int site_id;
    String startDate;
    String endDate;
    int limit;
    int offset;
    String path;
    boolean uniquePath;

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isUniquePath() {
        return uniquePath;
    }

    public void setUniquePath(boolean uniquePath) {
        this.uniquePath = uniquePath;
    }
   

    public String getQueryString() {
        LinkedHashMap<String, Object> queryItems = new LinkedHashMap<String, Object>();
        queryItems.put("startDate", startDate);
        queryItems.put("endDate", endDate);
        queryItems.put("path", path);
        queryItems.put("path", path);
        if (limit != 0)
            queryItems.put("limit", limit);
        if (offset != 0)
            queryItems.put("offset", offset);
        if ( uniquePath == true )
            queryItems.put("uniquePath", uniquePath);
        return UrlQueryString.buildQueryString(queryItems);
    }

}
