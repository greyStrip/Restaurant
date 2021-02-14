package com.training.model;

import com.training.enums.Status;

public class Seat {
	private int seatId;
	private Status seatStatus;
	public Seat() {
	}
	public Seat(int seatId) {
		this.seatId = seatId;
		this.seatStatus = Status.AVAILABLE;
	}
	public Seat(int seatId, Status seatStatus) {
		this.seatId = seatId;
		this.seatStatus = seatStatus;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public Status getSeatStatus() {
		return seatStatus;
	}
	public void setSeatStatus(Status seatStatus) {
		this.seatStatus = seatStatus;
	}
	@Override
	public String toString() {
		return "Seat [seatId=" + seatId + ", seatStatus=" + seatStatus + "]";
	}
	
}
