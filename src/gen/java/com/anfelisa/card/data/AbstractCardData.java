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




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.card.models.ICardModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractCardData extends AbstractData implements ICardData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCardData.class);
	
	@NotNull
	private String cardId;
	
	private String given;
	
	private String wanted;
	
	private String image;
	
	@NotNull
	private String cardAuthor;
	
	@NotNull
	private Integer cardIndex;
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String rootCategoryId;
	

	public AbstractCardData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("image") String image,
		@JsonProperty("cardAuthor") String cardAuthor,
		@JsonProperty("cardIndex") Integer cardIndex,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.image = image;
		this.cardAuthor = cardAuthor;
		this.cardIndex = cardIndex;
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
	}

	public AbstractCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
		public String getCardId() {
			return this.cardId;
		}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public ICardData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
		public String getGiven() {
			return this.given;
		}
	public void setGiven(String given) {
		this.given = given;
	}
	public ICardData withGiven(String given) {
		this.given = given;
		return this;
	}
	
	@JsonProperty
		public String getWanted() {
			return this.wanted;
		}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	public ICardData withWanted(String wanted) {
		this.wanted = wanted;
		return this;
	}
	
	@JsonProperty
		public String getImage() {
			return this.image;
		}
	public void setImage(String image) {
		this.image = image;
	}
	public ICardData withImage(String image) {
		this.image = image;
		return this;
	}
	
	@JsonProperty
		public String getCardAuthor() {
			return this.cardAuthor;
		}
	public void setCardAuthor(String cardAuthor) {
		this.cardAuthor = cardAuthor;
	}
	public ICardData withCardAuthor(String cardAuthor) {
		this.cardAuthor = cardAuthor;
		return this;
	}
	
	@JsonProperty
		public Integer getCardIndex() {
			return this.cardIndex;
		}
	public void setCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
	}
	public ICardData withCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
		return this;
	}
	
	@JsonProperty
		public String getCategoryId() {
			return this.categoryId;
		}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public ICardData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
		public String getRootCategoryId() {
			return this.rootCategoryId;
		}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	public ICardData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	
	
}




/******* S.D.G. *******/



