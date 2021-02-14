package com.training.model;

import com.training.enums.Status;

public class Waiter {
	private int waiterId;
	private String waiterName;
	private Status waiterStatus;

	public Waiter() {
	}

	public Waiter(int waiterId, String waiterName) {
		this.waiterId = waiterId;
		this.waiterName = waiterName;
		this.waiterStatus = Status.AVAILABLE;
	}

	public Waiter(int waiterId, String waiterName, Status waiterStatus) {
		this.waiterId = waiterId;
		this.waiterName = waiterName;
		this.waiterStatus = waiterStatus;
	}

	public int getWaiterId() {
		return waiterId;
	}

	public void setWaiterId(int waiterId) {
		this.waiterId = waiterId;
	}

	public String getWaiterName() {
		return waiterName;
	}

	public void setWaiterName(String waiterName) {
		this.waiterName = waiterName;
	}

	public Status getWaiterStatus() {
		return waiterStatus;
	}

	public void setWaiterStatus(Status waiterStatus) {
		this.waiterStatus = waiterStatus;
	}

	@Override
	public String toString() {
		return "Waiter [waiterId=" + waiterId + ", waiterName=" + waiterName + ", waiterStatus=" + waiterStatus + "]";
	}

}
