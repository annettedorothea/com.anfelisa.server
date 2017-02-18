package com.anfelisa;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AceAuthenticator;
import com.anfelisa.auth.AceAuthorizer;
import com.anfelisa.auth.AuthUser;

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

	static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public String getName() {
		return "anfelisa";
	}
	
	public String getVersion() {
		return "1.0.2";
	}

	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap) {
		bootstrap.addBundle(new AssetsBundle("/web-app/", "/"));
	}

	@Override
	public void run(AppConfiguration configuration, Environment environment) throws ClassNotFoundException {
		LOG.info("running version {}", getVersion());
		
		final DBIFactory factory = new DBIFactory();

		DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");

		DBIExceptionsBundle dbiExceptionsBundle = new DBIExceptionsBundle();
		environment.jersey().register(dbiExceptionsBundle);

		EmailService.setEmailConfiguration(configuration.getEmail());

		environment.jersey().register(new AuthDynamicFeature(new BasicCredentialAuthFilter.Builder<AuthUser>()
				.setAuthenticator(new AceAuthenticator(jdbi)).setAuthorizer(new AceAuthorizer()).buildAuthFilter()));
		environment.jersey().register(RolesAllowedDynamicFeature.class);
		environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AuthUser.class));

		com.anfelisa.user.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.user.AppRegistration.registerConsumers();

		com.anfelisa.course.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.course.AppRegistration.registerConsumers();

		com.anfelisa.lesson.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.lesson.AppRegistration.registerConsumers();

		com.anfelisa.test.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.test.AppRegistration.registerConsumers();

		com.anfelisa.result.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.result.AppRegistration.registerConsumers();

		com.anfelisa.box.AppRegistration.registerResources(environment, jdbi);
		com.anfelisa.box.AppRegistration.registerConsumers();

	}

}