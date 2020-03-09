/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.ace;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseHandle {

	static final Logger LOG = LoggerFactory.getLogger(DatabaseHandle.class);

	private PersistenceHandle writeHandle;
	private PersistenceHandle readonlyHandle;
	private PersistenceHandle timelineHandle;

	public DatabaseHandle(Jdbi jdbi) {
		super();
		this.writeHandle = new PersistenceHandle(jdbi.open());
		this.readonlyHandle = new PersistenceHandle(jdbi.open());
		this.timelineHandle = new PersistenceHandle(jdbi.open());
	}

	synchronized public void beginTransaction() {
		writeHandle.getHandle().begin();
		readonlyHandle.getHandle().begin();
		timelineHandle.getHandle().begin();
	}

	synchronized public void commitTransaction() {
		writeHandle.getHandle().commit();
		readonlyHandle.getHandle().rollback();
		timelineHandle.getHandle().commit();
	}

	synchronized public void rollbackTransaction() {
		writeHandle.getHandle().rollback();
		readonlyHandle.getHandle().rollback();
		timelineHandle.getHandle().commit();
	}

	synchronized public void close() {
		writeHandle.getHandle().close();
		readonlyHandle.getHandle().close();
		timelineHandle.getHandle().close();
	}

	public PersistenceHandle getHandle() {
		return writeHandle;
	}

	public PersistenceHandle getReadonlyHandle() {
		return readonlyHandle;
	}

	public PersistenceHandle getTimelineHandle() {
		return timelineHandle;
	}

}



/******* S.D.G. *******/



