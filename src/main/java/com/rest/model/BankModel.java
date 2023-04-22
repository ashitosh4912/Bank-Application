package com.rest.model;



public class BankModel {
	private long accountNo;
	private String accountHolderName;
	private String accountPass;
	private String cfnAccountPass;
	private double accountBalance;
	private String address;
	private long mobileNo;

	public BankModel() {
		super();
	}

	public BankModel(long accountNo, String accountHolderName, String accountPass, String cfnAccountPass,
			double accountBalance, String address, long mobileNo) {
		super();
		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.accountPass = accountPass;
		this.cfnAccountPass = cfnAccountPass;
		this.accountBalance = accountBalance;
		this.address = address;
		this.mobileNo = mobileNo;
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

	public String getCfnAccountPass() {
		return cfnAccountPass;
	}

	public void setCfnAccountPass(String cfnAccountPass) {
		this.cfnAccountPass = cfnAccountPass;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
}
