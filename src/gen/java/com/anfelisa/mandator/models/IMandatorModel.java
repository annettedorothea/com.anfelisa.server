package com.anfelisa.mandator.models;

import org.joda.time.DateTime;

@SuppressWarnings("unused")
public interface IMandatorModel {

	Long getId();
	String getMandatorId();
	String getUsername();
	String getPassword();
	String getName();
	String getPrename();
	String getEmail();
	String getRole();
	Boolean getEmailConfirmed();
	String getEmailConfirmationHash();

}

/*       S.D.G.       */
