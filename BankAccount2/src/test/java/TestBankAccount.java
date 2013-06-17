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

}
