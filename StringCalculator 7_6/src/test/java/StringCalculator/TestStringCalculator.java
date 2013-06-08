package StringCalculator;

import org.junit.Assert;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 08/06/2013
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */
public class TestStringCalculator {

    @Test
    public void returnZero() throws Exception {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void returnOneNumber(){
        Assert.assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void returnSumBasic()throws Exception{
        Assert.assertEquals(3, StringCalculator.add("1,2"));
    }
}
