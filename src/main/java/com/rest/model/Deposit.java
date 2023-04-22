package com.rest.model;

public class Deposit {

	private long accountNo;
	private String accountHolderName;
	private String accountPass;
	private double deptAmt;

	public Deposit() {
		super();
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountPass() {
		return accountPass;
	}

	public void setAccountPass(String accountPass) {
		this.accountPass = accountPass;
	}

	public double getDeptAmt() {
		return deptAmt;
	}

	public void setDeptAmt(double deptAmt) {
		this.deptAmt = deptAmt;
	}

}
