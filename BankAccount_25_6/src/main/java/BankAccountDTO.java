import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 25/06/2013
 * Time: 13:35
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {
    private String accountNumber;
    private long balance;
    static Calendar calendar = Calendar.getInstance();
    long openTimeStamp;
    public BankAccountDTO(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        openTimeStamp = calendar.getTimeInMillis();
        //To change body of created methods use File | Settings | File Templates.
    }

    public static void setCalendar(Calendar mockCalendar) {
        calendar = mockCalendar;
        //To change body of created methods use File | Settings | File Templates.
    }

    public String getAccountNumber() {
        return accountNumber;  //To change body of created methods use File | Settings | File Templates.
    }

    public long getBalance() {
        return balance;  //To change body of created methods use File | Settings | File Templates.
    }

    public long getOpenTimeStamp() {
        return openTimeStamp;  //To change body of created methods use File | Settings | File Templates.
    }

    public void setBalance(long balance) {
        this.balance = balance;
        //To change body of created methods use File | Settings | File Templates.
    }
}
