package com.anfelisa.ace;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServerInfo {

	private String serverVersion;
	
	public ServerInfo(String serverVersion) {
		super();
		this.serverVersion = serverVersion;
	}

	@JsonProperty
	public String getServerVersion() {
		return serverVersion;
	}
	
}
