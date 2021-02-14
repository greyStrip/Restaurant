package com.training.model;

import com.training.enums.Status;

public class Cook {
	private int cookId;
	private String cookName;
	private Status cookStatus;

	public Cook() {
	}

	public Cook(int cookId, String cookName) {
		this.cookId = cookId;
		this.cookName = cookName;
		this.cookStatus = Status.AVAILABLE;
	}

	public Cook(int cookId, String cookName, Status cookStatus) {
		this.cookId = cookId;
		this.cookName = cookName;
		this.cookStatus = cookStatus;
	}

	public int getCookId() {
		return cookId;
	}

	public void setCookId(int cookId) {
		this.cookId = cookId;
	}

	public String getCookName() {
		return cookName;
	}

	public void setCookName(String cookName) {
		this.cookName = cookName;
	}

	public Status getCookStatus() {
		return cookStatus;
	}

	public void setCookStatus(Status cookStatus) {
		this.cookStatus = cookStatus;
	}

}
