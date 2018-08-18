package com.tinhcao.dropwizard;

import com.tinhcao.dropwizard.db.dao.LocationDAO;
import com.tinhcao.dropwizard.resources.LocationResource;
import com.tinhcao.dropwizard.service.LocationService;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class LocationServiceApplication extends Application<LocationServiceConfiguration> {

    public static void main(final String[] args) throws Exception {
        new LocationServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "LocationService";
    }

    @Override
    public void initialize(final Bootstrap<LocationServiceConfiguration> bootstrap) {
        // TODO: application initialization
        // migrate bundle
        bootstrap.addBundle(new MigrationsBundle<LocationServiceConfiguration>() {
            @Override
            public PooledDataSourceFactory getDataSourceFactory(LocationServiceConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(final LocationServiceConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application

        // JDBI register
        final DBIFactory dbiFactory = new DBIFactory();
        final DBI dbi = dbiFactory.build(environment, configuration.getDataSourceFactory(), "mysql");
        LocationDAO locationDAO = dbi.onDemand(LocationDAO.class);

        // resource register
        environment.jersey().register(new LocationResource(new LocationService(locationDAO)));
    }

}
