package com.anfelisa.user.models;

import org.joda.time.DateTime;

@SuppressWarnings("unused")
public interface IEmailRegistrationModel {

	String getHost();
	Integer getPort();
	String getEmail();
	String getEmailConfirmationHash();
	String getLocale();

}

/*       S.D.G.       */
