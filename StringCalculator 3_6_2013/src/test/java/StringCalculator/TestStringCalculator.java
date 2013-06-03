package StringCalculator;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhIntel
 * Date: 6/3/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStringCalculator {
    @Test
    public void returnZero(){
        assertEquals(0, StringCalculator.add(""));
    }
    @Test
    public void returnOneNumber(){
        assertEquals(1,StringCalculator.add("1"));
    }
    @Test
    public void returnTowNumber(){
        assertEquals(12,StringCalculator.add("12"));
    }

    @Test
    public void returnSumBasic(){
        assertEquals(3,StringCalculator.add("1,2"));
    }

    @Test
    public void returnSumWithNewline(){
        assertEquals(6,StringCalculator.add("1\\n2,3"));
    }

    @Test
    public void returnNegativeNumber(){
        assertEquals(-1,StringCalculator.add("-1"));
    }
    @Test
    public void returnSumOfNumberWithStart(){
        assertEquals(13,StringCalculator.add("1***2***6%%%4"));
    }
    @Test
    public void returnSumOfNumbers(){
        assertEquals(6,StringCalculator.add("//[*][%]\\n1*2%3"));
    }
    @Test
    public void returnTowNumberBigger1000(){
        assertEquals(3,StringCalculator.add("2353aaa//[***]\\n1***2***35737"));
    }
}
