package com.chadzhou.pinboardJob.model.response;

import com.chadzhou.pinboardJob.entity.PinboardEntity;
import com.chadzhou.pinboardJob.model.Links;

import java.util.List;

public class PinboardResponse {
    private Integer id;
    private String pinboardId;

    private Links links;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPinboardId() {
        return pinboardId;
    }

    public void setPinboardId(String pinboardId) {
        this.pinboardId = pinboardId;
    }
}
