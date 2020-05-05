package de.acegen;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AceAuthenticator;

import de.acegen.auth.AuthUser;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.jdbi3.bundles.JdbiExceptionsBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<CustomAppConfiguration> {

	static final Logger LOG = LoggerFactory.getLogger(App.class);

	static EmailService EMAIL_SERVICE;

	private static String mode;

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public String getName() {
		return "anfelisa";
	}

	public static String getVersion() {
		return "0.8.1";
	}

	public static String getMode() {
		return mode;
	}

	public static void reportException(Exception x) {
		if (EMAIL_SERVICE != null) {
			try {
				if (x != null && x.getMessage() != null) {
					// EMAIL_SERVICE.sendAdminEmail("!!! Anfelisa exception !!!", x.getMessage());
				} else {
					// EMAIL_SERVICE.sendAdminEmail("!!! Anfelisa exception !!!", "unknown
					// exception");
				}
			} catch (Exception e) {
				LOG.error("failed to notify about exception", x.getMessage());
			}
		}
	}

	@Override
	public void initialize(Bootstrap<CustomAppConfiguration> bootstrap) {
		bootstrap.addBundle(new MigrationsBundle<CustomAppConfiguration>() {
			@Override
			public DataSourceFactory getDataSourceFactory(CustomAppConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});

		if (!ServerConfiguration.LIVE.equals(mode)) {
			bootstrap.addCommand(new EventReplayCommand(this));
		}
	}

	@Override
	public void run(CustomAppConfiguration configuration, Environment environment) throws ClassNotFoundException {
		LOG.info("running version {}", getVersion());

		EMAIL_SERVICE = new EmailService(configuration.getEmail());

		DaoProvider daoProvider = new DaoProvider();
		ViewProvider viewProvider = new ViewProvider(daoProvider, new EmailService(configuration.getEmail()));

		final JdbiFactory factory = new JdbiFactory();

		Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "data-source-name");

		E2E e2e = new E2E();

		mode = configuration.getServerConfiguration().getMode();
		if (ServerConfiguration.REPLAY.equals(mode)) {
			environment.jersey().register(new PrepareE2EResource(jdbi, daoProvider, viewProvider, e2e, configuration));
			environment.jersey().register(new StartE2ESessionResource(jdbi, daoProvider, e2e, configuration));
			environment.jersey().register(new StopE2ESessionResource(e2e, configuration));
			environment.jersey().register(new GetServerTimelineResource(jdbi, configuration));
			LOG.warn("You are running in REPLAY mode. This is a security risc.");
		} else if (ServerConfiguration.DEV.equals(mode)) {
			environment.jersey().register(new GetServerTimelineResource(jdbi, configuration));
			LOG.warn("You are running in DEV mode. This is a security risc.");
		}

		environment.jersey().register(new GetServerInfoResource());

		JdbiExceptionsBundle dbiExceptionsBundle = new JdbiExceptionsBundle();
		environment.jersey().register(dbiExceptionsBundle);

		environment.jersey()
				.register(new AuthDynamicFeature(
						new BasicCredentialAuthFilter.Builder<AuthUser>()
								.setAuthenticator(new AceAuthenticator(new PersistenceConnection(jdbi)))
								.setPrefix("anfelisaBasic").setRealm("anfelisaBasic private realm").buildAuthFilter()));
		environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AuthUser.class));

		environment.jersey().register(RolesAllowedDynamicFeature.class);

		configureCors(environment);

		AppRegistration.registerResources(environment, new PersistenceConnection(jdbi), configuration, daoProvider,
				viewProvider, e2e);
		AppRegistration.registerConsumers(viewProvider, mode);
	}

	private void configureCors(Environment environment) {
		final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

		// Configure CORS parameters
		cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
		cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM,
				"X-Requested-With,Content-Type,Accept,Origin,Authorization");
		cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
		cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

		// Add URL mapping
		cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

	}

}
