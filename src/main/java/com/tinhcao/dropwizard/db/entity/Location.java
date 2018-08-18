package com.tinhcao.dropwizard.db.entity;

import java.util.Objects;

public class Location extends BaseEntity {
    private Country country;
    private State state;
    private Type type;
    private String code;
    private String name;

    public Location() {

    }

    public Location(Country country, State state, Type type, String code, String name) {
        this.country = country;
        this.state = state;
        this.type = type;
        this.code = code;
        this.name = name;
    }

    public Location(Long id, String createOn, String modifyOn, Country country, State state, Type type, String code, String name) {
        super(id, createOn, modifyOn);
        this.country = country;
        this.state = state;
        this.type = type;
        this.code = code;
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Location location = (Location) o;
        return Objects.equals(country, location.country) &&
                Objects.equals(state, location.state) &&
                Objects.equals(type, location.type) &&
                Objects.equals(code, location.code) &&
                Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country, state, type, code, name);
    }
}
