package com.anfelisa.result.actions;

import org.skife.jdbi.v2.DBI;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.anfelisa.ace.Action;
import com.anfelisa.ace.HttpMethod;
import com.anfelisa.ace.ICommand;
import com.anfelisa.result.data.MyResultData;


public abstract class AbstractLoadResultAction extends Action<MyResultData> {

	public AbstractLoadResultAction(DBI jdbi) {
		super("LoadResultAction", HttpMethod.GET, jdbi);
	}

	@Override
	public ICommand getCommand() {
		return null;
	}


	protected void throwUnauthorized() {
		throw new WebApplicationException(Response.Status.UNAUTHORIZED);
	}

}

/*       S.D.G.       */
