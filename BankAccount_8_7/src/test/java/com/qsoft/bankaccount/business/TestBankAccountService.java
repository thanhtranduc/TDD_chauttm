package com.qsoft.bankaccount.business;

import com.qsoft.bankaccount.business.impl.BankAccountServiceImpl;
import com.qsoft.bankaccount.persistence.dao.impl.BankAccountDAOImpl;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * User: thanhtd
 * Date: 06/07/2013
 * Time: 01:01
 */
public class TestBankAccountService
{
    BankAccountDAOImpl mockAccountDao = mock(BankAccountDAOImpl.class);
    BankAccountService bankAccountService = new BankAccountServiceImpl();
    Calendar mockCalendar = mock(Calendar.class);
    private String accountNumber = "1234567890";

    @Before
    public void setUp()
    {
        reset(mockAccountDao);
        bankAccountService.setBankAccountDao(mockAccountDao);
    }

    @Test
    public void testCreateNewAccountHasBalanceZero() throws Exception
    {
        ArgumentCaptor<BankAccountEntity> argumentCaptor = ArgumentCaptor.forClass(BankAccountEntity.class);
        BankAccountEntity.setCalendar(mockCalendar);
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L);

        BankAccountEntity newAcc = bankAccountService.openAccount(accountNumber);
        verify(mockAccountDao).save(argumentCaptor.capture());

        assertEquals(accountNumber, argumentCaptor.getValue().getAccountNumber());
        assertEquals(argumentCaptor.getValue().getBalance(), 0, 0.01);
        assertEquals(argumentCaptor.getValue().getOpenTimeStamp(), 1000L);
    }

    @Test
    public void testDepositBalanceAccount() throws Exception
    {
        BankAccountEntity newAcc = bankAccountService.openAccount(accountNumber);
        when(mockAccountDao.getAccount(accountNumber)).thenReturn(newAcc);
        bankAccountService.deposit(accountNumber, 1000, "deposit");
        ArgumentCaptor<BankAccountEntity> argumentCaptor = ArgumentCaptor.forClass(BankAccountEntity.class);
        verify(mockAccountDao, times(2)).save(argumentCaptor.capture());
        List<BankAccountEntity> saveRecord = argumentCaptor.getAllValues();
        assertEquals(saveRecord.get(1).getBalance(), 1000, 0.01);
    }

    @Test
    public void testWithdrawBalanceAccount() throws Exception
    {
        BankAccountEntity accountDTO = bankAccountService.openAccount("1234567890");
        when(mockAccountDao.getAccount("1234567890")).thenReturn(accountDTO);
        bankAccountService.deposit("1234567890", 1000, "deposit");
        bankAccountService.withdraw("1234567890", 500, "deposit");
        ArgumentCaptor<BankAccountEntity> argumentAccount = ArgumentCaptor.forClass(BankAccountEntity.class);
        verify(mockAccountDao, times(3)).save(argumentAccount.capture());
        List<BankAccountEntity> savedAccountDB = argumentAccount.getAllValues();
        Assert.assertEquals(savedAccountDB.get(1).getBalance(), 500, 0.01);
    }

}
