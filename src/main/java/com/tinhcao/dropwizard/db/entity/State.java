package com.tinhcao.dropwizard.db.entity;

public enum State {
    ARIZONA("Arizona", "AR"),
    COLORADO("Colorado", "CO");

    private String name;
    private String code;

    State(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
