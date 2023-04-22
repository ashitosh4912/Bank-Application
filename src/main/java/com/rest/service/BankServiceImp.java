package com.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.rest.entity.Bank;
import com.rest.model.BankModel;
import com.rest.model.Delete;
import com.rest.model.Deposit;
import com.rest.model.GetModel;
import com.rest.model.Transfer;
import com.rest.model.Withdraw;
import com.rest.repo.BankRepo;

@Service
public class BankServiceImp implements BankService {

	@Autowired
	private BankRepo bankrepo;
	
	
	@Override
	public Bank saveData(@RequestBody BankModel bankmodel) {
		
		Bank bank=new Bank();
		
		if(bankmodel.getAccountPass().equalsIgnoreCase(bankmodel.getCfnAccountPass()))
				bank.setAccountPass(bankmodel.getAccountPass());  
		
		bank.setAccountNo(bankmodel.getAccountNo());
		bank.setAccountHolderName(bankmodel.getAccountHolderName());
		bank.setAccountBalance(bankmodel.getAccountBalance());
		bank.setAddress(bankmodel.getAddress());
		bank.setMobileNo(bankmodel.getMobileNo());
		bank.setStatus(1);
		return bankrepo.save(bank);
	}

	@Override
	public String getBalance(Long accountNo) {
		Bank bk=bankrepo.findById(accountNo).get();
		GetModel bk1=new GetModel();
		if(bk.getStatus()==1 && bk.getAccountNo()==accountNo)
		{
		bk1.setAccountNo(bk.getAccountNo());
		bk1.setAccountHolderName(bk.getAccountHolderName());
		bk1.setAccountBalance(bk.getAccountBalance());
		bk1.setAddress(bk.getAddress());
		return "Account No : -->"+bk1.getAccountNo()+"\nAccount Holder Name : -->"+bk1.getAccountHolderName()+"\nAccount Balance : -->'"+bk1.getAccountBalance()+"\nAddress : -->"+bk1.getAddress();
		}
		else
		{
			return "Your Account Is Deactivated...!!! \nCan't Get Deatils or Check Your Input...!!!"; 
		}
	}

	@Override
	public String depositAmt(Deposit depo) 
	{
		Bank data=bankrepo.findById(depo.getAccountNo()).get();
		if(data.getStatus()==1 && data.getAccountNo()==depo.getAccountNo() && data.getAccountPass().equalsIgnoreCase(depo.getAccountPass()))
		{
		String sms="Previous Account Balance ---> "+data.getAccountBalance()+" \nAnd  Your Deposit Amount is --->"+depo.getDeptAmt();
		double newAmt=data.getAccountBalance()+depo.getDeptAmt();
		data.setAccountBalance(newAmt);
		Bank bk= bankrepo.save(data);
		String sms1=null;
		if(bk!=null)
		{
			sms1=sms+"\nYour Orignal balance Is : ----->"+data.getAccountBalance();
		}
		return sms1;
		}
		else
		{
			return " Your Account Is Deactivated...!!\n Opretions Not Possible or Check Your Input...!!!";
		}
	}

	@Override
	public String withdrawAmt(Withdraw with)
	{
		Bank data=bankrepo.findById(with.getAccountNo()).get();
		if(data.getStatus()==1 && with.getAccountNo()==data.getAccountNo() && data.getAccountPass().equalsIgnoreCase(with.getAccountPass())) 
		{
		String sms="Previous Account Balance ---> "+data.getAccountBalance()+" \nAnd  Your Withdraw Amount is --->"+with.getWithAmt();
		double newAmt=data.getAccountBalance()-with.getWithAmt();
		data.setAccountBalance(newAmt);
		Bank bk= bankrepo.save(data);
		String sms1=null;
		if(bk!=null)
		{
			sms1=sms+"\nYour Orignal balance Is : ----->"+data.getAccountBalance();
		}
		return sms1;
		}
		else
		{
			return " Your Account Is Deactivated...!!\n Opretions Not Possible Or Check Your Input...!!!";
			}
	}

	@Override
	public String transferAmt(Transfer trans) {
		Bank data=bankrepo.findById(trans.getAccountNo()).get();
		Bank data1=bankrepo.findById(trans.getTargetAccountNo()).get();
		if(data.getStatus()==1 && data.getAccountNo()==trans.getAccountNo() && data.getAccountPass().equalsIgnoreCase(trans.getAccountPass()))
		{
		String s1="Your Account previous Amount : --->"+data.getAccountBalance()+"\nYour Transfer Amount : ---->"+trans.getTransferAmt();
		String s2="\nYour Target Account Amount : ----> "+data1.getAccountBalance();
		data.setAccountBalance(data.getAccountBalance()-trans.getTransferAmt());
		data1.setAccountBalance(data1.getAccountBalance()+trans.getTransferAmt());
		
		Bank bk=bankrepo.save(data);
		Bank bk1=bankrepo.save(data1);
		
		String sms=null;
		if(bk!=null && bk1!=null) {
			sms=s1+"\nYour Current Balance  : ----->"+data.getAccountBalance()+s2+"\nTarget Account Current Balance : --->"+data1.getAccountBalance();
		}
		return sms;
		}
		else
		{
			return " Your Account Is Deactivated...!!\n Opretions Not Possible Or Check Your Input..!!!";
		}
	}

	@Override
	public String deactivateAccount(Delete delete) {
		Bank data=bankrepo.findById(delete.getAccountNo()).get();
		String sms=null;
		if(data.getStatus()==1 && data.getAccountNo()==delete.getAccountNo() && data.getAccountPass().equalsIgnoreCase(delete.getAccountPass()))
		{
			data.setStatus(0);
			bankrepo.save(data);
			if(data!=null)
			{
				sms="Your Account Is Deactivated...!!!!";
			}
			return sms;
		}
		else
		{
			return "Your Account Is Allready Deactivated...!!! OR\n Check Your Input...!!!!";
		}
	}

}


