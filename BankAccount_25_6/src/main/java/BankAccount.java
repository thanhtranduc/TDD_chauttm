/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 25/06/2013
 * Time: 13:32
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDao bankAccountDao;

    public static BankAccountDTO openAccount(String accountNumber){
        BankAccountDTO newAccDTO = new BankAccountDTO(accountNumber);
        bankAccountDao.save(newAccDTO);
        return newAccDTO;

    }

    public static void setBankAccountDao(BankAccountDao mockAccountDao) {
        BankAccount.bankAccountDao = mockAccountDao;
        //To change body of created methods use File | Settings | File Templates.
    }
}
