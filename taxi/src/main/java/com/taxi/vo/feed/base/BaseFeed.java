package com.taxi.vo.feed.base;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taxi.util.CustomDateSerializer;


public class BaseFeed implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int 		feedNo;
	protected int 		roomNo;
	protected int 		mbrNo;
	protected String 	feedContent;
	protected Date		feedRegDate;
	
	
	public int getFeedNo() {
		return feedNo;
	}
	public BaseFeed setFeedNo(int feedNo) {
		this.feedNo = feedNo;
		return this;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public BaseFeed setRoomNo(int roomNo) {
		this.roomNo = roomNo;
		return this;
	}
	public int getMbrNo() {
		return mbrNo;
	}
	public BaseFeed setMbrNo(int mbrNo) {
		this.mbrNo = mbrNo;
		return this;
	}
	public String getFeedContent() {
		return feedContent;
	}
	public BaseFeed setFeedContent(String feedContent) {
		this.feedContent = feedContent;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getFeedRegDate() {
		return feedRegDate;
	}
	public BaseFeed setFeedRegDate(Date feedRegDate) {
		this.feedRegDate = feedRegDate;
		return this;
	}
	
	
	
}
