package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class PointsModel implements IPointsModel {

	@NotNull
	private Integer points;
	

	public PointsModel(
		@JsonProperty("points") Integer points
	) {
		this.points = points;
	}

	@JsonProperty
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	

}

/*       S.D.G.       */
