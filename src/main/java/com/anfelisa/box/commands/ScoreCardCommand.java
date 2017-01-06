package com.anfelisa.box.commands;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.DatabaseHandle;
import com.anfelisa.box.data.ScoreCardData;

public class ScoreCardCommand extends AbstractScoreCardCommand {

	static final Logger LOG = LoggerFactory.getLogger(ScoreCardCommand.class);

	public ScoreCardCommand(ScoreCardData commandParam, DatabaseHandle databaseHandle) {
		super(commandParam, databaseHandle);
	}

	@Override
	protected void executeCommand() {
		// execute command and set outcome
		this.commandData = this.commandParam;
		Float ef = this.commandParam.getEf() == 0F ? 1F : this.commandParam.getEf();
		Integer interval = this.commandParam.getInterval() == 0 ? 1 : this.commandParam.getInterval();
		Integer count = this.commandParam.getCount() + 1;
		Integer maxPoints = this.commandParam.getMaxPoints();
		Integer n = this.commandParam.getN() + 1;
		Float newFactor = ef;
		Integer quality = commandParam.getSubmittedQuality();
		
		if (quality < 3) {
			n = 1;
		} else {
			Float qFactor = (float) (5 - quality);
			newFactor = (ef + (0.1F - qFactor * (0.08F + qFactor * 0.02F)));
			if (newFactor < 1.3) {
				newFactor = 1.3F;
			}
		}
		Integer newInterval = 1;
		if (n == 2) {
			newInterval = 6;
		} else if (n > 2){
			newInterval = Math.round(interval * newFactor);
		}
		DateTime next = this.commandParam.getNow().plusDays(newInterval);
		Integer points = 0;
		if (quality > 2) {
			points = maxPoints;
		} else if (quality == 2) {
			points = (maxPoints/2);
		}
		
		this.commandData.setCardOfBoxId(null);
		this.commandData.setEf(newFactor);
		this.commandData.setInterval(newInterval);
		this.commandData.setCount(count);
		this.commandData.setN(n);
		this.commandData.setDate(next);
		this.commandData.setTimestamp(this.commandData.getNow());
		this.commandData.setQuality(quality);
		this.commandData.setPoints(points);
		
		this.outcome = scored;
	}

}

/*       S.D.G.       */
