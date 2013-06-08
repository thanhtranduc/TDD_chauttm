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
    public void returnZero(){
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void returnOneNumber(){
        Assert.assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void returnSumBasic(){
        Assert.assertEquals(3, StringCalculator.add("1,2"));
    }
    @Test
    public void returnSumWithNewline(){
        Assert.assertEquals(6, StringCalculator.add("1\\n2,3"));
    }
    @Test
    public void returnNegativeNumber(){
        try {
            Assert.assertEquals(-1, StringCalculator.add("-1,2"));
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(), "negatives not allowed");
        }
    }
    @Test
    public void returnMultipleNegativeNumber()throws Exception{
        try {
            Assert.assertEquals(-1, StringCalculator.add("1,-1,-2,5,-3"));
        }catch (Exception e){
            Assert.assertEquals(e.getMessage(), "negatives not allowed -1-2-3");
        }
    }

    @Test
    public void returnNotBigger1000() throws Exception{
        Assert.assertEquals(1, StringCalculator.add("1,1001"));
    }

    @Test
    public void returnSumWithDelimiter() throws Exception{
        Assert.assertEquals(6, StringCalculator.add("//[***]\\n1***2***3"));
    }
}
