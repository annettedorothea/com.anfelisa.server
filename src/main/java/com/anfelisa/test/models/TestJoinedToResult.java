package com.anfelisa.test.models;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.anfelisa.result.models.IResultAbstractModel;

public class TestJoinedToResult implements IMyTestModel, IResultAbstractModel {

	private DateTime date;
	private Integer points;
	private Integer maxPoints;
	private String name;
	private Integer sequence;
	private List<IResultAbstractModel> resultList;
	private Integer testId;
	private Integer resultId;

	public TestJoinedToResult(DateTime date, Integer points, Integer maxPoints, String name, Integer sequence,
			Integer testId, Integer resultId) {
		super();
		this.date = date;
		this.points = points;
		this.maxPoints = maxPoints;
		this.name = name;
		this.sequence = sequence;
		this.testId = testId;
		this.resultId = resultId;
		this.resultList = new ArrayList<IResultAbstractModel>();
	}

	@Override
	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	@Override
	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public Integer getMaxPoints() {
		return maxPoints;
	}

	public void setMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	@Override
	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer id) {
		this.testId = id;
	}

	@Override
	public List<IResultAbstractModel> getResultAbstractList() {
		return resultList;
	}

	public void setIResultAbstractModelList(List<IResultAbstractModel> resultList) {
		this.resultList = resultList;
	}

	@Override
	public Integer getResultId() {
		return resultId;
	}

	public void setResultId(Integer resultId) {
		this.resultId = resultId;
	}

	@Override
	public Integer getResultCount() {
		return null;
	}

	@Override
	public Boolean getHasResults() {
		return null;
	}
}