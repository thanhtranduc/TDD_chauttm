import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 25/06/2013
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount {
    BankAccountDao mockAccountDao = mock(BankAccountDao.class);
    TransactionDao transactionDao = mock(TransactionDao.class);
    Calendar mockCalendar = mock(Calendar.class);
    private String accountNumber = "1234567890";

    @Before
    public void setUp(){
        reset(mockAccountDao);
        BankAccount.setBankAccountDao(mockAccountDao);
        Transaction.setTransactionDao(transactionDao);
        Transaction.setCalendar(mockCalendar);
    }

    @Test
    public void testCreateNewAccountHasBalanceZero(){
        ArgumentCaptor<BankAccountDTO> argumentCaptor = ArgumentCaptor.forClass(BankAccountDTO.class);
        BankAccountDTO.setCalendar(mockCalendar);
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L);

        BankAccountDTO newAcc = BankAccount.openAccount(accountNumber);
        verify(mockAccountDao).save(argumentCaptor.capture());

        assertEquals(accountNumber, argumentCaptor.getValue().getAccountNumber());
        assertEquals(argumentCaptor.getValue().getBalance(),0,0.01);
        assertEquals(argumentCaptor.getValue().getOpenTimeStamp(),1000L);
    }

    @Test
    public void testDepositBalanceAccount(){
        BankAccountDTO newAcc = BankAccount.openAccount(accountNumber);
        when(mockAccountDao.get(accountNumber)).thenReturn(newAcc);
        BankAccount.deposit(accountNumber,100,"deposit");
        ArgumentCaptor<BankAccountDTO> argumentCaptor = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockAccountDao,times(2)).save(argumentCaptor.capture());
        List<BankAccountDTO> saveRecord = argumentCaptor.getAllValues();
        assertEquals(saveRecord.get(1).getBalance(),100,0.01);
    }

    @Test
    public void testWithdrawBalanceAccount(){
        BankAccountDTO accountDTO = BankAccount.openAccount("1234567890");
        when(mockAccountDao.get("1234567890")).thenReturn(accountDTO);
        BankAccount.deposit("1234567890",100,"deposit");
        BankAccount.withDraw("1234567890",50,"deposit");
        ArgumentCaptor<BankAccountDTO> argumentAccount = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockAccountDao,times(3)).save(argumentAccount.capture());
        List<BankAccountDTO> savedAccountDB = argumentAccount.getAllValues();
        Assert.assertEquals(savedAccountDB.get(1).getBalance(), 50, 0.01);
    }

    @Test
    public void testGetTransactionOccurred(){
        List<TransactionDTO> list = BankAccount.getTransactionOccurred(accountNumber);
    }
    @Test
    public void testGetTransactionsOccurredDifferenceTime(){
        long starTime = 100;
        long endTime = 1000;
        List<TransactionDTO> list = BankAccount.getTransactionOccurred(accountNumber,starTime,endTime);
    }
}
