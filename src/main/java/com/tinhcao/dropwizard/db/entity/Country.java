package com.tinhcao.dropwizard.db.entity;

public enum Country {
    US("United State of America", "US"),
    UK("United kingdom", "GB");

    private String name;
    private String code;

    Country(String name, String code) {
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
