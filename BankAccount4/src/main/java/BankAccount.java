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

}
