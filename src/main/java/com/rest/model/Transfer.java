package com.rest.model;

public class Transfer {

	private long accountNo;
	private String accountHolderName;
	private String accountPass;
	private long targetAccountNo;
	private double transferAmt;

	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
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

	public long getTargetAccountNo() {
		return targetAccountNo;
	}

	public void setTargetAccountNo(long targetAccountNo) {
		this.targetAccountNo = targetAccountNo;
	}

	public double getTransferAmt() {
		return transferAmt;
	}

	public void setTransferAmt(double transferAmt) {
		this.transferAmt = transferAmt;
	}

}

