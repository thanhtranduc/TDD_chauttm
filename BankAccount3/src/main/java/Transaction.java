import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 21/06/2013
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private static TransactionDao transactionDao;
    private static Calendar calendar;

    public static void setTransactionDao(TransactionDao transactionDao) {
        Transaction.transactionDao = transactionDao;

    }

    public static List<TransactionDTO> getTransactions(String accountNumber,long startTime,long stopTime) {
        return transactionDao.get(accountNumber,startTime,stopTime);
    }

    public static void setCalendar(Calendar calendar) {
        Transaction.calendar = calendar;
    }

    public static void save(String accountNumber, long amount, String description) {
        Long timeStamp = calendar.getTimeInMillis();
        TransactionDTO transactionDTO = new TransactionDTO(accountNumber,timeStamp,amount,description);
        transactionDao.save(transactionDTO);
    }

    public static List<TransactionDTO> getTransactionOccurred(String accountNumber) {
        return transactionDao.getTransactionsOccurred(accountNumber);  //To change body of created methods use File | Settings | File Templates.
    }

    public static List<TransactionDTO> getTransactionOccurred(String accountNumber, long starTime, long endTime) {
        return transactionDao.getTransactionsOccurred(accountNumber,starTime,endTime);  //To change body of created methods use File | Settings | File Templates.
    }

    public static List<TransactionDTO> getTransactionOccurred(String accountNumber, int n) {
        return transactionDao.getTransactionsOccurred(accountNumber,n);  //To change body of created methods use File | Settings | File Templates.
    }
}
