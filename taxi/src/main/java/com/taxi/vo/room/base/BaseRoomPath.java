package com.taxi.vo.room.base;

import java.io.Serializable;

public class BaseRoomPath implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int 		roomNo;
	protected int		pathRank;
	protected String	pathName;
	protected double 	pathLat;
	protected double 	pathLng;
	
	
	public int getRoomNo() {
		return roomNo;
	}
	public BaseRoomPath setRoomNo(int roomNo) {
		this.roomNo = roomNo;
		return this;
	}
	public int getPathRank() {
		return pathRank;
	}
	public BaseRoomPath setPathRank(int pathRank) {
		this.pathRank = pathRank;
		return this;
	}
	public String getPathName() {
		return pathName;
	}
	public BaseRoomPath setPathName(String pathName) {
		this.pathName = pathName;
		return this;
	}
	public double getPathLat() {
		return pathLat;
	}
	public BaseRoomPath setPathLat(double pathLat) {
		this.pathLat = pathLat;
		return this;
	}
	public double getPathLng() {
		return pathLng;
	}
	public BaseRoomPath setPathLng(double pathLng) {
		this.pathLng = pathLng;
		return this;
	}
}

