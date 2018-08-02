package com.chadzhou.pinboardJob.model.request;

public class PinRequest {
    private long id;

    public PinRequest() {
        super();
    }

    public PinRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
