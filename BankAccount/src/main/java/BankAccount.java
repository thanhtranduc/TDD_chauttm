/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 12/06/2013
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDAO bankAccountDAO;

    public static BankAccountDTO openAccount(String strNumberAccount) {
        BankAccountDTO accountDTO = new BankAccountDTO(strNumberAccount,0);

        bankAccountDAO.save(accountDTO);
        return accountDTO;
        //To change body of created methods use File | Settings | File Templates.
    }

    public static void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
        BankAccount.bankAccountDAO = bankAccountDAO;
    }

    public static boolean doTransaction(int amount, BankAccountDTO accountDTO) {
        accountDTO.setBalance(accountDTO.getBalance()+ amount);
        bankAccountDAO.save(accountDTO);
        return true;
        //To change body of created methods use File | Settings | File Templates.
    }
    public static void doTransaction(int i, BankAccountDTO accountDTO, long l){
        bankAccountDAO.save(accountDTO, l);
    }
}
