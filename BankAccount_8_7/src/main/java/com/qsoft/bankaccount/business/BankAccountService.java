package com.qsoft.bankaccount.business;

import com.qsoft.bankaccount.persistence.dao.impl.BankAccountDAOImpl;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 00:50
 */
public interface BankAccountService
{

    void setBankAccountDao(BankAccountDAOImpl mockAccountDao);

    public BankAccountEntity openAccount(String accountNumber) throws Exception;

    public BankAccountEntity getAccount(String accountNumber) throws Exception;

    public void deposit(String accountNumber, long amount, String description) throws Exception;

    public void withdraw(String accountNumber, long amount, String description) throws Exception;

}
