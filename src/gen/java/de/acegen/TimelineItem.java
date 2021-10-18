/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package de.acegen;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimelineItem implements ITimelineItem {

	private String type;
	
	private String name;
	
	private LocalDateTime timestamp;
	
	private String data;
	
	private String uuid;

	
	public TimelineItem(
		@JsonProperty("type") String type, 
		@JsonProperty("name") String name, 
		@JsonProperty("timestamp") LocalDateTime timestamp, 
		@JsonProperty("data") String data,
		@JsonProperty("uuid") String uuid
	) {
		super();
		this.type = type;
		this.name = name;
		this.timestamp = timestamp;
		this.data = data;
		this.uuid = uuid;
	}

	@JsonProperty
	public String getType() {
		return type;
	}

	@JsonProperty
	public String getName() {
		return name;
	}

	@JsonProperty
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	@JsonProperty
	public String getData() {
		return data;
	}

	@JsonProperty
	public String getUuid() {
		return uuid;
	}
	
	@Override
	public String toString() {
		return "TimelineItem [type=" + type + ", name=" + name + ", timestamp="
				+ timestamp + ", uuid=" + uuid + "]";
	}

}




/******* S.D.G. *******/



