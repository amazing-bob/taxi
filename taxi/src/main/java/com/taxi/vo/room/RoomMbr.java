package com.taxi.vo.room;

import java.io.Serializable;

import com.taxi.vo.room.base.BaseRoomMbr;


public class RoomMbr extends BaseRoomMbr implements Serializable {
	private static final long serialVersionUID = 1L;

	/* Base 변수
	 * 
	 * protected int 		roomNo;
	 * protected int 		mbrNo;
	 * protected String 	gcmRegId;
	 * protected int		roomMbrNo;
	 * protected String 	roomMbrSt;
	 * protected String 	relFrndPhoneNo;
	 * protected String 	relFrndName;
	 * protected String 	mutualYn;
	 * protected int		roomMbrRank;
	 */
	protected String 	mbrName;
	protected String 	mbrPhoneNo;
	protected String 	mbrPhotoUrl;
	protected String 	roomMbrName;

	
	public RoomMbr setRoomNo(int roomNo) {
		return (RoomMbr) super.setRoomNo(roomNo);
	}
	public RoomMbr setMbrNo(int mbrNo) {
		return (RoomMbr) super.setMbrNo(mbrNo);
	}
	public RoomMbr setGcmRegId(String gcmRegId) {
		return (RoomMbr) super.setGcmRegId(gcmRegId);
	}
	public RoomMbr setRoomMbrNo(int roomMbrNo) {
		return (RoomMbr) super.setRoomMbrNo(roomMbrNo);
	}
	public RoomMbr setRoomMbrSt(String roomMbrSt) {
		return (RoomMbr) super.setRoomMbrSt(roomMbrSt);
	}
	public RoomMbr setRelFrndPhoneNo(String relFrndPhoneNo) {
		return (RoomMbr) super.setRelFrndPhoneNo(relFrndPhoneNo);
	}
	public RoomMbr setRelFrndName(String relFrndName) {
		return (RoomMbr) super.setRelFrndName(relFrndName);
	}
	public RoomMbr setMutualYn(String mutualYn) {
		return (RoomMbr) super.setMutualYn(mutualYn);
	}
	public RoomMbr setRoomMbrRank(int roomMbrRank) {
		return (RoomMbr) super.setRoomMbrRank(roomMbrRank);
	}
	
	public String getMbrName() {
		return mbrName;
	}
	public RoomMbr setMbrName(String mbrName) {
		this.mbrName = mbrName;
		return this;
	}
	public String getMbrPhoneNo() {
		return mbrPhoneNo;
	}
	public RoomMbr setMbrPhoneNo(String mbrPhoneNo) {
		this.mbrPhoneNo = mbrPhoneNo;
		return this;
	}
	public String getMbrPhotoUrl() {
		return mbrPhotoUrl;
	}
	public RoomMbr setMbrPhotoUrl(String mbrPhotoUrl) {
		this.mbrPhotoUrl = mbrPhotoUrl;
		return this;
	}
	public String getRoomMbrName() {
		return roomMbrName;
	}
	public RoomMbr setRoomMbrName(String roomMbrName) {
		this.roomMbrName = roomMbrName;
		return this;
	}
	
	
	
/*	//====================== AS-IS =======================//
 	
	protected int 			roomNo;
	protected String		mbrId;
	protected String		gcmRegId;
	protected String		roomMbrId;
	protected String		frndRelId;
	protected int			roomMbrRank;
	protected String		mbrName;
	protected String		mbrPhoneNo;
	protected String		mbrPhotoUrl;
	protected String		roomMbrName;
	protected String		roomMbrPhotoUrl;
	protected String		frndRelName;


	public int getRoomNo() {
		return roomNo;
	}
	public RoomMbr setRoomNo(int roomNo) {
		this.roomNo = roomNo;
		return this;
	}
	public String getMbrId() {
		return mbrId;
	}
	public RoomMbr setMbrId(String mbrId) {
		this.mbrId = mbrId;
		return this;
	}
	public String getRoomMbrId() {
		return roomMbrId;
	}
	public RoomMbr setRoomMbrId(String roomMbrId) {
		this.roomMbrId = roomMbrId;
		return this;
	}
	public String getGcmRegId() {
		return gcmRegId;
	}
	public RoomMbr setGcmRegId(String gcmRegId) {
		this.gcmRegId = gcmRegId;
		return this;
	}
	public String getFrndRelId() {
		return frndRelId;
	}
	public RoomMbr setFrndRelId(String frndRelId) {
		this.frndRelId = frndRelId;
		return this;
	}
	public int getRoomMbrRank() {
		return roomMbrRank;
	}
	public RoomMbr setRoomMbrRank(int roomMbrRank) {
		this.roomMbrRank = roomMbrRank;
		return this;
	}
	public String getMbrName() {
		return mbrName;
	}
	public RoomMbr setMbrName(String mbrName) {
		this.mbrName = mbrName;
		return this;
	}
	public String getMbrPhoneNo() {
		return mbrPhoneNo;
	}
	public RoomMbr setMbrPhoneNo(String mbrPhoneNo) {
		this.mbrPhoneNo = mbrPhoneNo;
		return this;
	}
	public String getMbrPhotoUrl() {
		return mbrPhotoUrl;
	}
	public RoomMbr setMbrPhotoUrl(String mbrPhotoUrl) {
		this.mbrPhotoUrl = mbrPhotoUrl;
		return this;
	}
	public String getRoomMbrName() {
		return roomMbrName;
	}
	public RoomMbr setRoomMbrName(String roomMbrName) {
		this.roomMbrName = roomMbrName;
		return this;
	}
	public String getRoomMbrPhotoUrl() {
		return roomMbrPhotoUrl;
	}
	public RoomMbr setRoomMbrPhotoUrl(String roomMbrPhotoUrl) {
		this.roomMbrPhotoUrl = roomMbrPhotoUrl;
		return this;
	}
	public String getFrndRelName() {
		return frndRelName;
	}
	public RoomMbr setFrndRelName(String frndRelName) {
		this.frndRelName = frndRelName;
		return this;
	}
*/
	
}
