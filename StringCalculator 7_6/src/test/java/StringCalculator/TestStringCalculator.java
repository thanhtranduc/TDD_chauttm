package StringCalculator;

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
}
