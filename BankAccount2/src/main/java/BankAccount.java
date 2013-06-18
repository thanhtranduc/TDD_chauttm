import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 17/06/2013
 * Time: 9:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDao bankAccountDAO;

    public static BankAccountDTO openAccount(String accountNumber) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO(accountNumber);
        bankAccountDAO.save(bankAccountDTO);
        return bankAccountDTO;
    }

    public static void setBankAccountDao(BankAccountDao bankAccountDao) {
        BankAccount.bankAccountDAO = bankAccountDao;
    }

    public static BankAccountDTO getAccount(String accountNumber) {
        return bankAccountDAO.get(accountNumber);
    }

    private static void doTransaction(String accountNumber,long amount,String description){
        BankAccountDTO b = bankAccountDAO.get(accountNumber);
        b.setBalance(b.getBalance() + amount);
        bankAccountDAO.save(b);
        Transaction.save(accountNumber,amount,description);
    }

    public static void deposit(String accountNumber, long amount, String description) {
        doTransaction(accountNumber,amount,description);
    }

    public static void withDraw(String accountNumber, long amount, String description) {
        doTransaction(accountNumber,-amount,description);
    }


    public static List<TransactionDTO> getTransactionOccurred(String accountNumber,Long startTime,long stopTime) {
        return Transaction.getTransactions(accountNumber,startTime,stopTime);
    }
}
