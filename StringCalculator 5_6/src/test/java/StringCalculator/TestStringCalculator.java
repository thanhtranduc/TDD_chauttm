package StringCalculator;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhIntel
 * Date: 6/5/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStringCalculator {
    @Test
    public void returnZero() throws Exception {
        assertEquals(0, StringCalculator.add(""));
    }
    @Test
    public void returnOneNumber()throws Exception{
        assertEquals(1,StringCalculator.add("1"));
    }
    @Test
    public void returnTowNumber()throws Exception{
        assertEquals(12,StringCalculator.add("12"));
    }

    @Test
    public void returnSumBasic()throws Exception{
        assertEquals(3,StringCalculator.add("1,2"));
    }

    @Test
    public void returnSumWithNewline()throws Exception{
        assertEquals(6,StringCalculator.add("1\\n2,3"));
    }

    @Test
    public void returnMultipleNegativeNumber()throws Exception{
        try {
            assertEquals(-1,StringCalculator.add("1,-1,-2,5,-3"));
        }catch (Exception e){
            assertEquals(e.getMessage(),"negatives not allowed -1-2-3");
        }
    }

    @Test
    public void returnNegativeNumber(){
        try {
            assertEquals(-1,StringCalculator.add("//;\\n-1;2"));
        }catch (Exception e){
            assertEquals(e.getMessage(), "negatives not allowed");
        }
    }

    @Test
    public void returnNotBigger1000() throws Exception{
        assertEquals(1,StringCalculator.add("1,1001"));
    }

    /*@Test
    public void returnSumWithDelimiters() throws Exception{
        assertEquals(6,StringCalculator.add("//[***]\\n1***2***3"));
    } */
}
