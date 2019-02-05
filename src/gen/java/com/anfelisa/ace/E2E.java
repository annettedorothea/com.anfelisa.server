package com.anfelisa.ace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

public class E2E {

	private boolean sessionIsRunning;

	private DateTime sessionStartedAt;

	private Map<String, AceOperation> timeline;

	private List<String> uuidList;

	private int index;

	public E2E() {
		this.sessionIsRunning = false;
		this.sessionStartedAt = null;
		this.timeline = null;
		this.index = 0;
	}
	
	public boolean isSessionRunning() {
		return this.sessionIsRunning;
	}

	public DateTime getSessionStartedAt() {
		return this.sessionStartedAt;
	}

	public void reset() {
		this.sessionIsRunning = false;
		this.sessionStartedAt = null;
		this.timeline = null;
		this.index = 0;
	}

	public void init(List<ITimelineItem> initialTimeline) {
		timeline = new HashMap<>();
		uuidList = new ArrayList<>();
		for (ITimelineItem timelineItem : initialTimeline) {
			String uuid = timelineItem.getUuid();
			if (!uuidList.contains(uuid)) {
				uuidList.add(uuid);
			}
			AceOperation aceOperation = timeline.get(uuid);
			if (aceOperation == null) {
				aceOperation = new AceOperation(uuid);
				timeline.put(uuid, aceOperation);
			}
			if ("action".equals(timelineItem.getType())) {
				aceOperation.setAction(timelineItem);
			} else if ("command".equals(timelineItem.getType())) {
				aceOperation.setCommand(timelineItem);
			} else if ("event".equals(timelineItem.getType())) {
				aceOperation.setEvent(timelineItem);
			}
		}
		this.sessionIsRunning = true;
		this.sessionStartedAt = new DateTime(System.currentTimeMillis());
		this.index = 0;
	}

	public ITimelineItem selectNextAction() {
		if (index < uuidList.size()) {
			String uuid = uuidList.get(index);
			index++;
			return timeline.get(uuid).getAction();
		}
		return null;
	}

	public ITimelineItem selectAction(String uuid) {
		return timeline.get(uuid).getAction();
	}

	public ITimelineItem selectCommand(String uuid) {
		return timeline.get(uuid).getCommand();
	}

	public ITimelineItem selectEvent(String uuid) {
		return timeline.get(uuid).getEvent();
	}
	
}

