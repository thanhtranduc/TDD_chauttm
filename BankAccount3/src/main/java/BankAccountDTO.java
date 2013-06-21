import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 21/06/2013
 * Time: 14:01
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {

    private String accountNumber;
    private long balance = 0;
    static Calendar calendar = Calendar.getInstance();
    long openTimeStamp;
    public BankAccountDTO(String accountNumber){
        this.accountNumber = accountNumber;
        balance = 0;
        openTimeStamp = calendar.getTimeInMillis();
    }

    public static void setCalendar(Calendar calendars) {
        calendar = calendars;
    }

    public void setBalance(long balance){
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;  //To change body of created methods use File | Settings | File Templates.
    }

    public long getOpenTimeStamp() {
        return openTimeStamp;  //To change body of created methods use File | Settings | File Templates.
    }
}
