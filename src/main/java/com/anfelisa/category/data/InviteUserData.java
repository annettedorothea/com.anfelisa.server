package com.anfelisa.category.data;

import java.io.IOException;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.category.events.EventFactory;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;

public class InviteUserData extends AbstractInviteUserData implements IInviteUserData {

	private JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);

	public InviteUserData(@JsonProperty("categoryId") String categoryId,
			@JsonProperty("rootCategoryId") String rootCategoryId, @JsonProperty("invitedUserId") String invitedUserId,
			@JsonProperty("invitedUsername") String invitedUsername, @JsonProperty("userId") String userId,
			@JsonProperty("uuid") String uuid) {
		super(categoryId, rootCategoryId, invitedUserId, invitedUsername, userId, uuid);
	}

	public InviteUserData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
		try {
			HashMap<String, String> map = mapper.readValue(json, new TypeReference<HashMap<String, String>>() {
			});
			String username = map.get("username");
			this.setInvitedUsername(username);
		} catch (IOException e) {
			LOG.error("failed to migrate legacy data of InviteUserData with {}", json, e);
		}
	}

}

/* S.D.G. */
