package com.taxi.vo.room.base;

import java.io.Serializable;


public class BaseRoomMbr implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int 		roomNo;
	protected int	 	mbrNo;
	protected String 	gcmRegId;
	protected int 		roomMbrNo;
	protected String 	roomMbrSt;
	protected String 	relFrndPhoneNo;
	protected String 	mutualYn;
	protected int 		roomMbrRank;
	
	
	public int getRoomNo() {
		return roomNo;
	}
	public BaseRoomMbr setRoomNo(int roomNo) {
		this.roomNo = roomNo;
		return this;
	}
	public int getMbrNo() {
		return mbrNo;
	}
	public BaseRoomMbr setMbrNo(int mbrNo) {
		this.mbrNo = mbrNo;
		return this;
	}
	public String getGcmRegId() {
		return gcmRegId;
	}
	public BaseRoomMbr setGcmRegId(String gcmRegId) {
		this.gcmRegId = gcmRegId;
		return this;
	}
	public int getRoomMbrNo() {
		return roomMbrNo;
	}
	public BaseRoomMbr setRoomMbrNo(int roomMbrNo) {
		this.roomMbrNo = roomMbrNo;
		return this;
	}
	public String getRoomMbrSt() {
		return roomMbrSt;
	}
	public BaseRoomMbr setRoomMbrSt(String roomMbrSt) {
		this.roomMbrSt = roomMbrSt;
		return this;
	}
	public String getRelFrndPhoneNo() {
		return relFrndPhoneNo;
	}
	public BaseRoomMbr setRelFrndPhoneNo(String relFrndPhoneNo) {
		this.relFrndPhoneNo = relFrndPhoneNo;
		return this;
	}
	public String getMutualYn() {
		return mutualYn;
	}
	public BaseRoomMbr setMutualYn(String mutualYn) {
		this.mutualYn = mutualYn;
		return this;
	}
	public int getRoomMbrRank() {
		return roomMbrRank;
	}
	public BaseRoomMbr setRoomMbrRank(int roomMbrRank) {
		this.roomMbrRank = roomMbrRank;
		return this;
	}	
	
}
