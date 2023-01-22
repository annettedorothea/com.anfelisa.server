package de.acegen;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.auth.AceAuthenticator;
import com.codahale.metrics.servlets.AdminServlet;

import de.acegen.auth.AuthUser;
import de.acegen.resources.GetServerInfoResource;
import de.acegen.resources.SquishyDataProviderResource;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.jdbi3.bundles.JdbiExceptionsBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<CustomAppConfiguration> {

	static final Logger LOG = LoggerFactory.getLogger(App.class);

	private static String mode;

	public static void main(String[] args) throws Exception {
		new App().run(args);
	}

	@Override
	public String getName() {
		return "anfelisa";
	}

	public static String getVersion() {
		String version = App.class.getPackage().getImplementationVersion();
		if (version == null) {
			version = "development";
		}
		return version;
	}

	@Override
	public void initialize(Bootstrap<CustomAppConfiguration> bootstrap) {
		bootstrap.addBundle(new MigrationsBundle<CustomAppConfiguration>() {
			@Override
			public DataSourceFactory getDataSourceFactory(CustomAppConfiguration configuration) {
				return configuration.getDataSourceFactory();
			}
		});

		if (!Config.LIVE.equals(mode)) {
			bootstrap.addCommand(new EventReplayCommand(this));
		}
		bootstrap.setConfigurationSourceProvider(
				new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
						new EnvironmentVariableSubstitutor()));
	}

	@Override
	public void run(CustomAppConfiguration configuration, Environment environment) throws ClassNotFoundException {
		LOG.info("running version {}", getVersion());
		
		DaoProvider daoProvider = new DaoProvider();
		ViewProvider viewProvider = new ViewProvider(daoProvider, new EmailService(configuration));

		final JdbiFactory factory = new JdbiFactory();

		Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "anfelisa database");

		mode = configuration.getConfig().getMode();
		LOG.info("running in {} mode", mode);
		if (Config.DEV.equals(mode)) {
			environment.jersey().register(new SquishyDataProviderResource());
			LOG.warn("You are running in DEV mode. This is a security risc.");
		}

		environment.jersey().register(new GetServerInfoResource());

		JdbiExceptionsBundle dbiExceptionsBundle = new JdbiExceptionsBundle();
		environment.jersey().register(dbiExceptionsBundle);

		environment.jersey().register(new AuthDynamicFeature(
				new OAuthCredentialAuthFilter.Builder<AuthUser>()
						.setAuthenticator(new AceAuthenticator(configuration))
						.setPrefix("Bearer")
						.buildAuthFilter()));
		environment.jersey().register(RolesAllowedDynamicFeature.class);
		environment.jersey().register(new AuthValueFactoryProvider.Binder<>(AuthUser.class));

		environment.jersey().register(new AdminServlet());

		AppRegistration.registerResources(environment, new PersistenceConnection(jdbi), configuration, daoProvider,
				viewProvider);
		AppRegistration.registerConsumers(environment, viewProvider);
		
        
	}

}
