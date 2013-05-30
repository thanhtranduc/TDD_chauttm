package NumberToWord;

import junit.framework.Assert;
import org.junit.Test;
/**
 * Created with IntelliJ IDEA.
 * User: ThanhIntel
 * Date: 5/16/13
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class NumberToEnglishTest{
    @Test
    public void readOneToNine(){
        Assert.assertEquals("zero", NumberToEnglish.NumberToWord(0));
    }
    @Test
    public void readTenToNineteen(){
        Assert.assertEquals("eleven",NumberToEnglish.NumberToWord(11));
    }
    @Test
    public void readNineteenToHundered(){
        Assert.assertEquals("twenty two",NumberToEnglish.NumberToWord(22));
    }
    @Test
    public void readNineteenToNinety(){
        Assert.assertEquals("ninety nine", NumberToEnglish.NumberToWord(99));
    }
    @Test
    public void readHundred(){
        Assert.assertEquals("one hundred ", NumberToEnglish.NumberToWord(100));
    }
    @Test
    public void readHundred_999(){
        Assert.assertEquals("nine hundred ninety nine ", NumberToEnglish.NumberToWord(999));
    }
    @Test
    public void readThousand_1000(){
        Assert.assertEquals("one thousand ",NumberToEnglish.NumberToWord(1000));
    }
    @Test
    public void readThousand_9999(){
        Assert.assertEquals("nine thousand nine hundred ninety nine ",NumberToEnglish.NumberToWord(9999));
    }
    @Test
    public void readThousand_10000(){
        Assert.assertEquals("ten thousand ",NumberToEnglish.NumberToWord(10000));
    }
    @Test
    public void readThousand_99000(){
        Assert.assertEquals("ninety nine thousand ",NumberToEnglish.NumberToWord(99000));
    }
    @Test
    public void readThousand_99999(){
        Assert.assertEquals("ninety nine thousand nine hundred ninety nine ",NumberToEnglish.NumberToWord(99999));
    }
    @Test
    public void readThousand_999000(){
        Assert.assertEquals("nine hundred ninety nine thousand ",NumberToEnglish.NumberToWord(999000));
    }
    @Test
    public void readThousand_999010(){
        Assert.assertEquals("nine hundred ninety nine thousand ten ",NumberToEnglish.NumberToWord(999010));
    }
    @Test
    public void readThousand_999098(){
        Assert.assertEquals("nine hundred ninety nine thousand ninety eight ",NumberToEnglish.NumberToWord(999098));
    }
    @Test
    public void readThousand_999017(){
        Assert.assertEquals("nine hundred ninety nine thousand seventeen ",NumberToEnglish.NumberToWord(999017));
    }

    @Test
    public void readMillion_999999(){
        Assert.assertEquals("nine hundred ninety nine thousand nine hundred ninety nine ",NumberToEnglish.NumberToWord(999999));
    }

    @Test
    public void readMillion_1000000(){
        Assert.assertEquals("one million ",NumberToEnglish.NumberToWord(1000000));
    }
    @Test
    public void readMillion_1900900(){
        Assert.assertEquals("one million nine hundred thousand nine hundred ",NumberToEnglish.NumberToWord(1900900));
    }

    @Test
    public void readMillion_99000000(){
        Assert.assertEquals("ninety nine million ",NumberToEnglish.NumberToWord(99000000));
    }
    @Test
    public void readMillion_99900900(){
        Assert.assertEquals("ninety nine million nine hundred thousand nine hundred ",NumberToEnglish.NumberToWord(99900900));
    }

    @Test
    public void readMillion_999000000(){
        Assert.assertEquals("nine hundred ninety nine million ",NumberToEnglish.NumberToWord(999000000));
    }
    @Test
    public void readMillion_999900900(){
        Assert.assertEquals("nine hundred ninety nine million nine hundred thousand nine hundred ",NumberToEnglish.NumberToWord(999900900));
    }

    @Test
    public void readMillion_999099900(){
        Assert.assertEquals("nine hundred ninety nine million ninety nine thousand nine hundred ",NumberToEnglish.NumberToWord(999099900));
    }
    @Test
    public void readMillion_999009900(){
        Assert.assertEquals("nine hundred ninety nine million nine thousand nine hundred ",NumberToEnglish.NumberToWord(999009900));
    }

    @Test
    public void readMillion_999999999(){
        Assert.assertEquals("nine hundred ninety nine million nine hundred ninety nine thousand nine hundred ninety nine ",NumberToEnglish.NumberToWord(999999999));
    }

}
