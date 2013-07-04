import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 25/06/2013
 * Time: 13:33
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDao {
    private Connection dbConnection;


    public void save(BankAccountDTO capture) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public BankAccountDTO get(String accountNumber) {
        return  null;
    }

    public BankAccount getAccount(String accountNumber)
    {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
