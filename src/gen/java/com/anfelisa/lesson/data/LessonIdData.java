package com.anfelisa.lesson.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.lesson.models.ILessonIdModel;

@SuppressWarnings("all")
public class LessonIdData implements ILessonIdData {
	
	private String uuid;
	
	private String outcome;
	
	private String createdId;
	
	private String[] notifiedListeners;
	
	@NotNull
	private Integer lessonId;
	

	private org.joda.time.DateTime systemTime;
	
	public LessonIdData(
		@JsonProperty("lessonId") Integer lessonId
,		@JsonProperty("uuid") String uuid
	) {
		this.lessonId = lessonId;
		this.uuid = uuid;
		
	}

	public LessonIdData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public Integer getLessonId() {
		return this.lessonId;
	}
	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}
	public LessonIdData withLessonId(Integer lessonId) {
		this.lessonId = lessonId;
		return this;
	}
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonIgnore
	public String getCreatedId() {
		return createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	@JsonProperty
	public org.joda.time.DateTime getSystemTime() {
		return systemTime;
	}

	@JsonProperty
	public void setSystemTime(org.joda.time.DateTime systemTime) {
		this.systemTime = systemTime;
	}

	@JsonProperty
	public String getOutcome() {
		return outcome;
	}

	@JsonProperty
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	@Override
	@JsonProperty
	public String[] getNotifiedListeners() {
		return notifiedListeners;
	}

	@Override
	@JsonProperty
	public void setNotifiedListeners(String[] listeners) {
		this.notifiedListeners = listeners;
	}

	@Override
	public Object toPresentationalData() {
		return new LessonIdPresentationalData(
			this.lessonId
		);
	}

}

/*       S.D.G.       */
