package com.taxi.vo.room.base;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taxi.util.CustomDateSerializer;


public class BaseRoom implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int 		roomNo;
	protected Date		roomStartTime;
	protected int		roomMbrNumLimit;
	protected Date		roomRegDate;
	
	
	public int getRoomNo() {
		return roomNo;
	}
	public BaseRoom setRoomNo(int roomNo) {
		this.roomNo = roomNo;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getRoomStartTime() {
		return roomStartTime;
	}
	public BaseRoom setRoomStartTime(Date roomStartTime) {
		this.roomStartTime = roomStartTime;
		return this;
	}
	public int getRoomMbrNumLimit() {
		return roomMbrNumLimit;
	}
	public BaseRoom setRoomMbrNumLimit(int roomMbrNumLimit) {
		this.roomMbrNumLimit = roomMbrNumLimit;
		return this;
	}
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getRoomRegDate() {
		return roomRegDate;
	}
	public BaseRoom setRoomRegDate(Date roomRegDate) {
		this.roomRegDate = roomRegDate;
		return this;
	}
	
	
	
}

