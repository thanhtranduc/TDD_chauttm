import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 27/06/2013
 * Time: 07:57
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private static TransactionDao transactionDao;
    private static Calendar calendar;
    public static void save(String accountNumber, long amount, String description) {
        Long timeStamp = calendar.getTimeInMillis();
        TransactionDTO transactionDTO = new TransactionDTO(accountNumber,timeStamp,amount,description);
        transactionDao.save(transactionDTO);
        //To change body of created methods use File | Settings | File Templates.
    }

    public static void setTransactionDao(TransactionDao transactionDao) {
        Transaction.transactionDao = transactionDao;
        //To change body of created methods use File | Settings | File Templates.
    }

    public static void setCalendar(Calendar mockCalendar) {
        Transaction.calendar = mockCalendar;
        //To change body of created methods use File | Settings | File Templates.
    }
}
