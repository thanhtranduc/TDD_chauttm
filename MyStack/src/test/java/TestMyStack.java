import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhIntel
 * Date: 6/17/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestMyStack {

    @Test
    public void checkSize(){
        new MyStack();
        assertEquals(0,MyStack.size());
    }

    @Test
    public void pushElement(){
        new MyStack();
        MyStack.push("1");
        assertEquals(1, MyStack.size());
        MyStack.push("2");
        MyStack.push("3");
        MyStack.push("4");
        //exits 4 elements
        assertEquals(4,MyStack.size());
        MyStack.push("5");
        assertEquals(5,MyStack.size());//exits five elements
    }
    @Test
    public void topElement(){
        new MyStack();
        MyStack.top();
        assertFalse(MyStack.top());
    }
}
