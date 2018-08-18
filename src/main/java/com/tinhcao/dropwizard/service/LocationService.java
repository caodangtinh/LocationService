package com.tinhcao.dropwizard.service;

import com.tinhcao.dropwizard.db.dao.LocationDAO;
import com.tinhcao.dropwizard.db.entity.Location;

import java.util.List;

public class LocationService {

    private LocationDAO locationDAO;

    public LocationService(LocationDAO locationDAO) {
        this.locationDAO = locationDAO;
    }

    public List<Location> getLocations() {
        return locationDAO.getLocations();
    }

    public Location getLocationById(Long id) {
        return locationDAO.getLocationById(id);
    }

    public void createLocation(Location location) {
        locationDAO.createLocation(location);
    }

    public Location updateLocation(Long id, Location updateLocation) {
        locationDAO.updateLocation(id, updateLocation);
        return locationDAO.getLocationById(id);
    }

    public void deleteLocation(Long id) {
        locationDAO.deleteLocation(id);
    }

}
