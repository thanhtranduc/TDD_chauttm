package StringCalculator;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
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
       Assert.assertEquals(12,StringCalculator.add("12"));
    }

    @Test
    public void returnSums(){
        assertEquals(3,StringCalculator.add("1,2"));
    }

    @Test
    public void returnTowNumberWithNewline(){
        Assert.assertEquals(6,StringCalculator.add("1\\n2,3"));
    }

    @Test
    public void returnNegativeNumber(){
        Assert.assertEquals(-1,StringCalculator.add("-1"));
    }
    @Test
    public void returnSumOfNumber(){
        assertEquals(13,StringCalculator.add("1*******2**            ****6%%%4"));
    }
    @Test
    public void returnSumOfNumbers(){
        assertEquals(6,StringCalculator.add("//[*][%]\\n1*2%3"));
    }
    @Test
    public void returnTowNumberBigger1000(){
        Assert.assertEquals(3,StringCalculator.add("2353aaa//[***]\\n1***2***35737"));
    }
}
