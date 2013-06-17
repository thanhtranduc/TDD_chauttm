import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 17/06/2013
 * Time: 9:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {
    private String accountNumber;
    private long balance = 0;
    long openTimeStamp;
    static Calendar calendar = Calendar.getInstance();

    public BankAccountDTO(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        openTimeStamp = calendar.getTimeInMillis();

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getBalance() {
        return balance;
    }


    public void setBalance(long balance) {
        this.balance = balance;
    }
    @Override
    public boolean equals(Object o){
        if (o == this)
            return true;
        BankAccountDTO b = (BankAccountDTO) o;
        return accountNumber.equals(b.accountNumber) && balance == b.balance;
    }

    public static void setCalendar(Calendar calendars) {
        calendar = calendars;
        //To change body of created methods use File | Settings | File Templates.
    }

    public long getOpenTimeStamp() {
        return openTimeStamp;  //To change body of created methods use File | Settings | File Templates.
    }
}
