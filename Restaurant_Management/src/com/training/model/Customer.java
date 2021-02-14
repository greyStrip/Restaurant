package com.training.model;

import com.training.enums.CustomerStatus;

public class Customer {
	private int custId;
	private String custName;
	private CustomerStatus custStatus;

	public Customer() {
	}

	public Customer(int custId, String custName) {
		this.custId = custId;
		this.custName = custName;
		this.custStatus = CustomerStatus.WAITING;
	}

	public Customer(int custId, String custName, CustomerStatus custStatus) {
		this.custId = custId;
		this.custName = custName;
		this.custStatus = custStatus;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public CustomerStatus getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(CustomerStatus custStatus) {
		this.custStatus = custStatus;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custStatus=" + custStatus + "]";
	}

}
