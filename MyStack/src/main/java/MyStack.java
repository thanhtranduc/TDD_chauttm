import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhIntel
 * Date: 6/17/13
 * Time: 1:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyStack {
    static List<String> list;
    MyStack(){
        list = new ArrayList<String>();
    }

    public static int size() {
        if(list.isEmpty()){
            return 0;
        }else {
            return list.size();
        }
    }

    public static List push(String str) {
        list.add(str);
        return list;
    }

    public static boolean top() {
        if(list.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

}
