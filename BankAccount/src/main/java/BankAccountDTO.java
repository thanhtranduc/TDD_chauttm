import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 12/06/2013
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDTO {
    private String strAccountNumber;
    private double balance;
    long openTimeStamp;
    private static Calendar calendar = Calendar.getInstance();
    BankAccountDTO(String accountNumber, double balance){
        this.strAccountNumber = accountNumber;
        this.balance = balance;
        openTimeStamp = calendar.getTimeInMillis();
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public static void setCalendar(Calendar calendar){
        BankAccountDTO.calendar = calendar;

    }

    public void setAccountNumber(String strAccountNumber){
        this.strAccountNumber = strAccountNumber;
    }

    public String getAccountNumber(){
        return strAccountNumber;
    }

    public long getOpenTimeStamp(){
        return openTimeStamp;
    }

    public void setOpenTimeStamp(Long openTimeStamp) {
        this.openTimeStamp = openTimeStamp;
    }


}
