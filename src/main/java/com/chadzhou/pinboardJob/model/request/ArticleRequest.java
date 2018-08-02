package com.chadzhou.pinboardJob.model.request;

public class ArticleRequest {


    private Integer id;
    private Integer pinboardId;

    public ArticleRequest(Integer id, Integer pinboardId) {
        this.id = id;
        this.pinboardId = pinboardId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
