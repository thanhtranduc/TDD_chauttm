import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 17/06/2013
 * Time: 9:00 AM
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
    public static List<TransactionDTO> getTransactions(String accountNumber,int n) {
        return transactionDao.get(accountNumber,n);
    }
    public static void setCalendar(Calendar calendar) {
        Transaction.calendar = calendar;
    }

    public static void save(String accountNumber, long amount, String description) {
        Long timeStamp = calendar.getTimeInMillis();
        TransactionDTO transactionDTO = new TransactionDTO(accountNumber,timeStamp,amount,description);
        transactionDao.save(transactionDTO);
    }
}
