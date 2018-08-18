package com.tinhcao.dropwizard.db.entity;

import java.util.Objects;

public class BaseEntity {
    private Long id;
    private String createOn;
    private String modifyOn;

    public BaseEntity() {
    }

    public BaseEntity(Long id, String createOn, String modifyOn) {
        this.id = id;
        this.createOn = createOn;
        this.modifyOn = modifyOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateOn() {
        return createOn;
    }

    public void setCreateOn(String createOn) {
        this.createOn = createOn;
    }

    public String getModifyOn() {
        return modifyOn;
    }

    public void setModifyOn(String modifyOn) {
        this.modifyOn = modifyOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createOn, that.createOn) &&
                Objects.equals(modifyOn, that.modifyOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createOn, modifyOn);
    }
}
