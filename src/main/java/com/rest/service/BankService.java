package com.rest.service;

import com.rest.entity.Bank;
import com.rest.model.BankModel;
import com.rest.model.Delete;
import com.rest.model.Deposit;
import com.rest.model.Transfer;
import com.rest.model.Withdraw;

public interface BankService {

	public Bank saveData(BankModel bankmodel);
	public String getBalance(Long accountNo);
	public String depositAmt(Deposit depo);
	public String withdrawAmt(Withdraw with);
	public String transferAmt(Transfer trans);
	public String deactivateAccount(Delete delete);
}
