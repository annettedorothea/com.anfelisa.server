package com.anfelisa;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import com.anfelisa.ace.AceResource;
import com.anfelisa.ace.DatabaseService;
import com.anfelisa.auth.AceAuthenticator;
import com.anfelisa.auth.AceAuthorizer;
import com.anfelisa.auth.AuthUser;
import com.anfelisa.migration.MigrationResource;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfiguration> {

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public String getName() {
		return "lessonToMe";
	}

	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/web-app/", "/"));
	}

	@Override
	public void run(AppConfiguration configuration, Environment environment) throws ClassNotFoundException {
		final DBIFactory factory = new DBIFactory();
		
		DatabaseService.setJdbi(factory.build(environment, configuration.getDataSourceFactory(), "postgresql"));

		DBIExceptionsBundle dbiExceptionsBundle = new DBIExceptionsBundle();
		environment.jersey().register(dbiExceptionsBundle);

		environment.jersey().register(new AuthDynamicFeature(
	            new BasicCredentialAuthFilter.Builder<AuthUser>()
	                .setAuthenticator(new AceAuthenticator())
	                .setAuthorizer(new AceAuthorizer())
	                .buildAuthFilter()));
	    environment.jersey().register(RolesAllowedDynamicFeature.class);
	    environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AuthUser.class));
		
		AceResource aceResource = new AceResource();
		environment.jersey().register(aceResource);
		
		com.anfelisa.setup.AppRegistration.registerResources(environment);
		com.anfelisa.setup.AppRegistration.registerConsumers();
		
		com.anfelisa.user.AppRegistration.registerResources(environment);
		com.anfelisa.user.AppRegistration.registerConsumers();
		
		com.anfelisa.course.AppRegistration.registerResources(environment);
		com.anfelisa.course.AppRegistration.registerConsumers();
		
		com.anfelisa.lesson.AppRegistration.registerResources(environment);
		com.anfelisa.lesson.AppRegistration.registerConsumers();
		
		com.anfelisa.test.AppRegistration.registerResources(environment);
		com.anfelisa.test.AppRegistration.registerConsumers();
		
		com.anfelisa.result.AppRegistration.registerResources(environment);
		com.anfelisa.result.AppRegistration.registerConsumers();
		
		com.anfelisa.box.AppRegistration.registerResources(environment);
		com.anfelisa.box.AppRegistration.registerConsumers();
		
		environment.jersey().register(new MigrationResource());
		
	}
	
}