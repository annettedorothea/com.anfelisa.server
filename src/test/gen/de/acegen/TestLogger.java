/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package de.acegen;

import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger implements TestWatcher {

	static final Logger LOG = LoggerFactory.getLogger(TestLogger.class);

	@Override
	public void testDisabled(ExtensionContext context, Optional<String> reason) {
		LOG.info("DISABLED {}", reason.orElse(""));
		LOG.info("*********************************************************************************");
	}

	@Override
	public void testSuccessful(ExtensionContext context) {
		LOG.info("SUCCESS");
		LOG.info("*********************************************************************************");
	}

	@Override
	public void testAborted(ExtensionContext context, Throwable cause) {
		LOG.error("ABORTED", cause);
		LOG.error("*********************************************************************************");
	}

	@Override
	public void testFailed(ExtensionContext context, Throwable cause) {
		LOG.error("FAILED", cause);
		LOG.error("*********************************************************************************");
	}


}




/******* S.D.G. *******/



