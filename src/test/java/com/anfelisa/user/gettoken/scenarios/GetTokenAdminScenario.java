/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.user.gettoken.scenarios;

import com.anfelisa.user.data.GetTokenResponse;

@SuppressWarnings("unused")
public class GetTokenAdminScenario extends AbstractGetTokenAdminScenario {

	@Override
	protected void validToken(GetTokenResponse response) {
		validateToken(response.getToken(), "uuid-admin", "Admin", "ADMIN");
	}

	

}




/******* S.D.G. *******/



