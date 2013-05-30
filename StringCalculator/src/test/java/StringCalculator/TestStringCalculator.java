package StringCalculator;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhIntel
 * Date: 5/30/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class TestStringCalculator {
    @Test
    public void returnZero(){
        assertEquals(0, StringCalculator.add(""));
    }
    @Test
    public void returnOneNumber(){
       Assert.assertEquals(1,StringCalculator.add("1"));
    }
    @Test
    public void returnTowNumber(){
       Assert.assertEquals(3, StringCalculator.add("1,2"));
    }
}
