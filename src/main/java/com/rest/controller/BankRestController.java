package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.Bank;
import com.rest.model.BankModel;
import com.rest.model.Delete;
import com.rest.model.Deposit;
import com.rest.model.Transfer;
import com.rest.model.Withdraw;
import com.rest.service.BankService;

@RestController
public class BankRestController {

	@Autowired
	private BankService bankserv;

	@PostMapping("/saveData")
	public String saveAmt(@RequestBody BankModel bankmodel) {
		Bank b = bankserv.saveData(bankmodel);
		String sms = null;
		if (b != null)
			sms = "Data Save SuccessFullyy....!!!!";
		else
			sms = "Data Save Failed....!!!!";
		return sms;
	}

	@GetMapping("/getBal/{accountNo}")
	public String get(@PathVariable Long accountNo) {
		return bankserv.getBalance(accountNo);
	}

	@PutMapping("/depositAmt")
	public String depoAmt(@RequestBody Deposit depo) {
		return bankserv.depositAmt(depo);
	}

	@PutMapping("/withdrawAmt")
	public String withAmt(@RequestBody Withdraw with) {
		return bankserv.withdrawAmt(with);
	}

	@PutMapping("/transfer")
  public String transfer(@RequestBody Transfer trans)
  {
	 return bankserv.transferAmt(trans);
  }
	
	@PutMapping("/deactivate")
	public String dactivateAccount(@RequestBody Delete delete)
	{
		return bankserv.deactivateAccount(delete);
	}
}

