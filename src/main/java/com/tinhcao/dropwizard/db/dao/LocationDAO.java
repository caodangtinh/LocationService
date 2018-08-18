package com.tinhcao.dropwizard.db.dao;

import com.tinhcao.dropwizard.db.entity.Location;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(value = LocationMapper.class)
public interface LocationDAO {

    @SqlQuery(value = "SELECT * FROM location")
    List<Location> getLocations();

    @SqlQuery(value = "SELECT * from location l where l.id =:id")
    Location getLocationById(@Bind(value = "id") Long id);

//    @SqlUpdate(value = "INSERT INTO location(name, code, country, state, type, createOn, modifyOn) values (:name, :code, :country, :state, :type, :createOn, :modifyOn)")
//    void createLocation(
//            @Bind(value = "name") String name,
//            @Bind(value = "code") String code,
//            @Bind(value = "country") String country,
//            @Bind(value = "state") String state,
//            @Bind(value = "type") String type,
//            @Bind(value = "createOn") String createOn,
//            @Bind(value = "modifyOn") String modifyOn
//    );

    @SqlUpdate(value = "INSERT INTO location(name, code, country, state, type, createOn, modifyOn) values (:name, :code, :country, :state, :type, :createOn, :modifyOn)")
    void createLocation(@BindBean Location location);


    @SqlUpdate(value = "UPDATE location set" +
            " name =:name," +
            " code =:code," +
            " country =:country," +
            " state=:state," +
            " type=:type," +
            " createOn=:createOn," +
            " modifyOn=:modifyOn" +
            " WHERE id =:id")
    void updateLocation(@Bind(value = "id") Long id, @BindBean Location location);

    @SqlUpdate(value = "DELETE from location where id =:id")
    void deleteLocation(@Bind(value = "id") Long id);
}
