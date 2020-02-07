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




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IInitBoxesModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractInitBoxesData extends AbstractData implements IInitBoxesData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractInitBoxesData.class);
	
	private Integer daysBehindSchedule;
	
	@NotNull
	private String boxId;
	

	public AbstractInitBoxesData(
		@JsonProperty("daysBehindSchedule") Integer daysBehindSchedule,
		@JsonProperty("boxId") String boxId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.daysBehindSchedule = daysBehindSchedule;
		this.boxId = boxId;
	}

	public AbstractInitBoxesData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
		public Integer getDaysBehindSchedule() {
			return this.daysBehindSchedule;
		}
	public void setDaysBehindSchedule(Integer daysBehindSchedule) {
		this.daysBehindSchedule = daysBehindSchedule;
	}
	public IInitBoxesData withDaysBehindSchedule(Integer daysBehindSchedule) {
		this.daysBehindSchedule = daysBehindSchedule;
		return this;
	}
	
	@JsonProperty
		public String getBoxId() {
			return this.boxId;
		}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IInitBoxesData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	
	
}




/******* S.D.G. *******/


