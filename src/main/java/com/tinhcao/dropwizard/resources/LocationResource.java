package com.tinhcao.dropwizard.resources;

import com.tinhcao.dropwizard.db.entity.Location;
import com.tinhcao.dropwizard.service.LocationService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/locations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LocationResource {
    private LocationService locationService;

    public LocationResource(LocationService locationService) {
        this.locationService = locationService;
    }

    @GET
    public Response getLocation() {
        return Response.ok().entity(locationService.getLocations()).build();
    }

    @GET
    @Path("/{id}")
    public Response getLocationById(@PathParam(value = "id") Long id) {
        return Response.ok().entity(locationService.getLocationById(id)).build();
    }

    @POST
    public Response createLocation(@Valid @NotNull Location location) {
        locationService.createLocation(location);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateLocation(@PathParam(value = "id") Long id, @Valid @NotNull Location location) {
        return Response.ok().entity(locationService.updateLocation(id, location)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteLocation(@PathParam(value = "id") Long id) {
        locationService.deleteLocation(id);
        return Response.ok().build();
    }
}
