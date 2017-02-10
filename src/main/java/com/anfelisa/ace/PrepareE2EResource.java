package com.anfelisa.ace;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import com.anfelisa.models.SchemaDao;

public class PrepareE2EResource extends AbstractPrepareE2EResource{

	private SchemaDao schemaDao = new SchemaDao();
	
	private Handle handle;

	public PrepareE2EResource(DBI jdbi) {
		super(jdbi);
		this.handle = this.getJdbi().open();
	}

	@Override
	protected void dropSchema(String schema) {
		schemaDao.dropSchema(handle, schema);
	}

	@Override
	protected void createSchema(String schema) {
		schemaDao.createSchema(handle, schema);
	}

	@Override
	protected void createTables(String schema) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected IAction getNextAction(String uuidOfLastAction, String uuidOfE2EStartAction) {
		// TODO Auto-generated method stub
		return null;
	}

}
