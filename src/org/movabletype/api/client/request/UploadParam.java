package org.movabletype.api.client.request;

public class UploadParam {

    int site_id;
    String uploadPath;
    String uploadLocalfile;
    boolean autoRenameIfExists;
    boolean normalizeOrientation;
    boolean overwrite_once;

    public UploadParam(int site_id, String uploadPath, String uploadLocalfile, boolean autoRenameIfExists, boolean normalizeOrientation, boolean overwrite_once) {
        super();
        this.site_id = site_id;
        this.uploadPath = uploadPath;
        this.uploadLocalfile = uploadLocalfile;
        this.autoRenameIfExists = autoRenameIfExists;
        this.normalizeOrientation = normalizeOrientation;
        this.overwrite_once = overwrite_once;
    }

    public UploadParam() {
        autoRenameIfExists = true;
        normalizeOrientation = false;
        overwrite_once = true;
    }

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUploadLocalfile() {
        return uploadLocalfile;
    }

    public void setUploadLocalfile(String uploadLocalfile) {
        this.uploadLocalfile = uploadLocalfile;
    }

    public boolean isAutoRenameIfExists() {
        return autoRenameIfExists;
    }

    public void setAutoRenameIfExists(boolean autoRenameIfExists) {
        this.autoRenameIfExists = autoRenameIfExists;
    }

    public boolean isNormalizeOrientation() {
        return normalizeOrientation;
    }

    public void setNormalizeOrientation(boolean normalizeOrientation) {
        this.normalizeOrientation = normalizeOrientation;
    }

    public boolean isOverwrite_once() {
        return overwrite_once;
    }

    public void setOverwrite_once(boolean overwrite_once) {
        this.overwrite_once = overwrite_once;
    }

}
