package com.project.asms1.model;

import java.io.Serializable;
import java.util.Date;

public class PostDTO implements Serializable {
    private String id, content, storeID;
    private int status;
    private Date postDate;

    public PostDTO(String id, String content, String storeID, int status, Date postDate) {
        this.id = id;
        this.content = content;
        this.storeID = storeID;
        this.status = status;
        this.postDate = postDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
