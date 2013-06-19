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
 * Date: 17/06/2013
 * Time: 9:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount {
    BankAccountDao mockAccountDao = mock(BankAccountDao.class);
    TransactionDao transactionDao = mock(TransactionDao.class);
    Calendar calendar = mock(Calendar.class);

    public void initTransaction(){
        BankAccountDTO newAcc = BankAccount.openAccount("1234567890");
        when(mockAccountDao.get("1234567890")).thenReturn(newAcc);
        when(calendar.getTimeInMillis()).thenReturn(0L).thenReturn(1000L);
        BankAccount.deposit("1234567890",100L,"first deposit");
        BankAccount.withDraw("1234567890",50L,"first withdraw");
    }
    @Before
    public void setUp(){
        reset(mockAccountDao);
        BankAccount.setBankAccountDao(mockAccountDao);
        Transaction.setTransactionDao(transactionDao);
        Transaction.setCalendar(calendar);
    }

    @Test
    public void newAccountHasZeroBalance(){
        ArgumentCaptor<BankAccountDTO> argumentAccount = ArgumentCaptor.forClass(BankAccountDTO.class);
        Calendar mockCalendar = mock(Calendar.class);
        BankAccountDTO.setCalendar(mockCalendar);
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L);

        BankAccountDTO newAccount = BankAccount.openAccount("1234567890");
        verify(mockAccountDao).save(argumentAccount.capture());

        assertEquals("1234567890", argumentAccount.getValue().getAccountNumber());
        assertEquals(argumentAccount.getValue().getBalance(), 0.0, 0.01);
        assertEquals(argumentAccount.getValue().getOpenTimeStamp(), 1000L);
    }
    @Test
    public void depositBalanceAccount(){
        BankAccountDTO accountDTO = BankAccount.openAccount("1234567890");
        when(mockAccountDao.get("1234567890")).thenReturn(accountDTO);

        BankAccount.deposit("1234567890",100,"deposit");
        ArgumentCaptor<BankAccountDTO> argumentDeposit = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockAccountDao,times(2)).save(argumentDeposit.capture());
        List<BankAccountDTO> savedAccountDB = argumentDeposit.getAllValues();
        assertEquals(savedAccountDB.get(1).getBalance(),100,0.01);
    }
    @Test
    public void withdrawBalanceAccount(){
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
        ArgumentCaptor<TransactionDTO> argumentCaptor = ArgumentCaptor.forClass(TransactionDTO.class);
        initTransaction();
        verify(transactionDao,times(2)).save(argumentCaptor.capture());
        List<TransactionDTO> saveDB = argumentCaptor.getAllValues();
        when(transactionDao.get("1234567890",0L,100L)).thenReturn(saveDB);
        List<TransactionDTO> actualRecords = BankAccount.getTransactionOccurred("1234567890",0L,100L);
        assertEquals(saveDB,actualRecords);
    }

    @Test
    public void testGetTransactionInAPeriod(){

        ArgumentCaptor<TransactionDTO> transactionRecordDB = ArgumentCaptor.forClass(TransactionDTO.class);
        initTransaction();
        verify(transactionDao,times(2)).save(transactionRecordDB.capture());
        List<TransactionDTO> savedRecords = transactionRecordDB.getAllValues();
        when(transactionDao.get("1234567890",0L,100L)).thenReturn(savedRecords);
        List<TransactionDTO> actualRecords = BankAccount.getTransactionOccurred("1234567890",0L,100L);
        assertEquals(savedRecords,actualRecords);
    }
    @Test
    public void testGetNTransactions(){
        ArgumentCaptor<TransactionDTO> argumentCaptor = ArgumentCaptor.forClass(TransactionDTO.class);
        initTransaction();
        verify(transactionDao,times(2)).save(argumentCaptor.capture());
        List<TransactionDTO> savedRecords = argumentCaptor.getAllValues();
        when(transactionDao.get("1234567890",2)).thenReturn(savedRecords);
        List<TransactionDTO> actualRecords = BankAccount.getTransactionOccurred("1234567890",2);
        assertEquals(savedRecords,actualRecords);
    }

}
