package com.taxi.vo.feed;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taxi.util.CustomDateSerializer;
import com.taxi.vo.feed.base.BaseFeed;


public class Feed extends BaseFeed implements Serializable {
	private static final long serialVersionUID = 1L;

	
/*	//====================== AS-IS =======================//
 	
	protected int 			feedNo;
	protected int 			roomNo;
	protected String 		feedContent;
	protected String		mbrId;
	protected String		mbrName;
	protected String		mbrPhotoUrl;
	protected Date			feedRegDate;
	
	public int getFeedNo() {
		return feedNo;
	}
	public Feed setFeedNo(int feedNo) {
		this.feedNo = feedNo;
		return this;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public Feed setRoomNo(int roomNo) {
		this.roomNo = roomNo;
		return this;
	}
	public String getFeedContent() {
		return feedContent;
	}
	public Feed setFeedContent(String feedContent) {
		this.feedContent = feedContent;
		return this;
	}
	public String getMbrId() {
		return mbrId;
	}
	public Feed setMbrId(String mbrId) {
		this.mbrId = mbrId;
		return this;
	}
	public String getMbrName() {
		return mbrName;
	}
	public Feed setMbrName(String mbrName) {
		this.mbrName = mbrName;
		return this;
	}
	public String getMbrPhotoUrl() {
		return mbrPhotoUrl;
	}
	public Feed setMbrPhotoUrl(String mbrPhotoUrl) {
		this.mbrPhotoUrl = mbrPhotoUrl;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getFeedRegDate() {
		return feedRegDate;
	}
	public Feed setFeedRegDate(Date feedRegDate) {
		this.feedRegDate = feedRegDate;
		return this;
	}
*/
	
}
