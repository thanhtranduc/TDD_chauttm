import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 24/06/2013
 * Time: 13:44
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {

    private static BankAccountDao bankAccountDao;
    public static BankAccountDTO openAccount(String accountNumber) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO(accountNumber);
        bankAccountDao.save(bankAccountDTO);
        return bankAccountDTO;
    }

    public static void setBankAccountDao(BankAccountDao bankAccountDao) {
        BankAccount.bankAccountDao = bankAccountDao;
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void doTransaction(String accountNumber,long amount,String description){
        BankAccountDTO b = bankAccountDao.get(accountNumber);
        b.setBalance(b.getBalance() + amount);
        bankAccountDao.save(b);
        Transaction.save(accountNumber,amount,description);
    }

    public static void deposit(String accountNumber, long amount, String deposit) {
        doTransaction(accountNumber,amount,deposit);
    }

    public static void withDraw(String accountNumber, long amount, String description) {
        doTransaction(accountNumber,-amount,description);
    }

    public static List<TransactionDTO> getTransactionOccurred(String accountNumber) {
        return Transaction.getTransactionOccurred(accountNumber);  //To change body of created methods use File | Settings | File Templates.
    }

    public static List<TransactionDTO> getTransactionOccurred(String accountNumber, long starTime, long endTime) {
        return Transaction.getTransactionOccurred(accountNumber,starTime,endTime);  //To change body of created methods use File | Settings | File Templates.
    }

    public static List<TransactionDTO> getTransactionOccurred(String accountNumber, int n) {
        return Transaction.getTransactionOccurred(accountNumber,n);  //To change body of created methods use File | Settings | File Templates.
    }
}
