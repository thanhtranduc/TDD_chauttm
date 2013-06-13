import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 12/06/2013
 * Time: 16:07
 * To change this template use File | Settings | File Templates.
 */
public class TestAccount {
    BankAccountDAO mockAccountDao = mock(BankAccountDAO.class);

    @Before
    public void setUp(){
        reset(mockAccountDao);
        BankAccount.setBankAccountDAO(mockAccountDao);
    }
    @Test
    public void newAccountHasZeroBalance(){
        BankAccountDTO newAccount = BankAccount.openAccount("1234567890");
        verify(mockAccountDao).save(newAccount);
        ArgumentCaptor<BankAccountDTO> argumentAccoun = ArgumentCaptor.forClass(BankAccountDTO.class);
        verify(mockAccountDao,times(1)).save(argumentAccoun.capture());

        assertEquals("1234567890",argumentAccoun.getValue().getAccountNumber());
        assertEquals(argumentAccoun.getValue().getBalance(), 0.0, 0.01);
    }

    @Test
    public void changBalanceAccount(){
        ArgumentCaptor<BankAccountDTO> argumentAccoun = ArgumentCaptor.forClass(BankAccountDTO.class);
        BankAccountDTO accountDTO = BankAccount.openAccount("1234567890");
        BankAccount.doTransaction(100,accountDTO);
        verify(mockAccountDao,times(2)).save(argumentAccoun.capture());
        List<BankAccountDTO> savedAccountDB = argumentAccoun.getAllValues();
        assertEquals(savedAccountDB.get(1).getBalance(),100,0.01);

        BankAccount.doTransaction(-50,accountDTO);
        verify(mockAccountDao,times(3)).save(argumentAccoun.capture());
        savedAccountDB = argumentAccoun.getAllValues();
        assertEquals(savedAccountDB.get(2).getBalance(),50,0.01);
    }

}
