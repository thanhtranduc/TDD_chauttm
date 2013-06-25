/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 25/06/2013
 * Time: 11:56
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDTO {
    String accountNumber;
    long timeStamp;
    long amount;
    String description;
    public TransactionDTO(String accountNumber,Long timeStamp, long amount, String description){
        this.accountNumber = accountNumber;
        this.timeStamp = timeStamp;
        this.amount = amount;
        this.description = description;
    }
}
