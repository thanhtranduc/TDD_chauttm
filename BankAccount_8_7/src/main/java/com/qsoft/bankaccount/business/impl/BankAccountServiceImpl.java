package com.qsoft.bankaccount.business.impl;

import com.qsoft.bankaccount.business.BankAccountService;
import com.qsoft.bankaccount.persistence.dao.impl.BankAccountDAOImpl;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 00:51
 */
public class BankAccountServiceImpl implements BankAccountService
{
    private static BankAccountDAOImpl bankAccountDao;

    public BankAccountEntity openAccount(String accountNumber){
        BankAccountEntity newAccDTO = new BankAccountEntity(accountNumber);
        bankAccountDao.save(newAccDTO);
        return newAccDTO;

    }

    @Override
    public BankAccountEntity getAccount(String accountNumber) throws Exception
    {
        return null;
    }

    public void setBankAccountDao(BankAccountDAOImpl mockAccountDao) {
        BankAccountServiceImpl.bankAccountDao = mockAccountDao;
    }

    public void deposit(String accountNumber, long amount, String description) {
        doTransaction(accountNumber,amount, description);
    }

    private static void doTransaction(String accountNumber, long amount, String description) {
        BankAccountEntity b = bankAccountDao.get(accountNumber);
        b.setBalance(b.getBalance() + amount);
        bankAccountDao.save(b);
        TransactionServiceImpl.save(accountNumber,amount,description);
    }

    public void withdraw(String accountNumber, long amount, String description) {
        doTransaction(accountNumber,-amount, description);
    }


}
