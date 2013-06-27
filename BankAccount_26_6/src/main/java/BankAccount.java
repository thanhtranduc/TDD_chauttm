import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 27/06/2013
 * Time: 07:49
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDao bankAccountDao;
    public static BankAccountDTO openAccount(String accountNumber) {
        BankAccountDTO newAccDTO = new BankAccountDTO(accountNumber);
        bankAccountDao.save(newAccDTO);
        return newAccDTO;
        //To change body of created methods use File | Settings | File Templates.
    }

    public static void setBankAccountDao(BankAccountDao mockAccountDao) {
        BankAccount.bankAccountDao = mockAccountDao;
        //To change body of created methods use File | Settings | File Templates.
    }

    public static void deposit(String accountNumber, long amount, String description) {
        doTransaction(accountNumber,amount, description);
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void doTransaction(String accountNumber, long amount, String description) {
        BankAccountDTO b = bankAccountDao.get(accountNumber);
        b.setBalance(b.getBalance() + amount);
        bankAccountDao.save(b);
        Transaction.save(accountNumber,amount,description);
        //To change body of created methods use File | Settings | File Templates.
    }

    public static void withDraw(String accountNumber, long amount, String description) {
        doTransaction(accountNumber,-amount, description);
        //To change body of created methods use File | Settings | File Templates.
    }

    public static List<TransactionDTO> getTransactionOccurred(String accountNumber) {
        return Transaction.getTransactionOccurred(accountNumber);  //To change body of created methods use File | Settings | File Templates.
    }

    public static List<TransactionDTO> getTransactionOccurred(String accountNumber, long starTime, long endTime) {
        return Transaction.getTransactionOccurred(accountNumber,starTime,endTime);
        //To change body of created methods use File | Settings | File Templates.
    }

    public static List<TransactionDTO> getTransactionOccurred(String accountNumber, int n) {
        return Transaction.getTransactionOccurred(accountNumber,n);
        //To change body of created methods use File | Settings | File Templates.
    }
}
