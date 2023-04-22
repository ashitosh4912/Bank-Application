package com.rest.model;

public class Withdraw {

	private long accountNo;
	private String accountHolderName;
	private String accountPass;
	private double withAmt;

	public Withdraw() {
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

	public double getWithAmt() {
		return withAmt;
	}

	public void setWithAmt(double withAmt) {
		this.withAmt = withAmt;
	}

}

