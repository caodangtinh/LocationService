package com.tinhcao.dropwizard.db.dao;

import com.tinhcao.dropwizard.db.entity.Country;
import com.tinhcao.dropwizard.db.entity.Location;
import com.tinhcao.dropwizard.db.entity.State;
import com.tinhcao.dropwizard.db.entity.Type;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationMapper implements ResultSetMapper<Location> {
    @Override
    public Location map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        Location location = new Location();
        location.setId(resultSet.getLong("id"));
        location.setName(resultSet.getString("name"));
        location.setCode(resultSet.getString("code"));
        location.setCountry(Country.valueOf(resultSet.getString("country")));
        location.setState(State.valueOf(resultSet.getString("state")));
        location.setType(Type.valueOf(resultSet.getString("type")));
        location.setCreateOn(resultSet.getString("createOn"));
        location.setModifyOn(resultSet.getString("modifyOn"));
        return location;
    }
}
