package StringCalculator;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhIntel
 * Date: 5/30/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {
    public static int add(String str){
        int temp = 0;
        String strTemp="";
        boolean flag = false;
        if(str.isEmpty()){
            return 0;
        }else if (Integer.parseInt(str) >= 0){
            return Integer.parseInt(str);
        }else{
            for (int i = 0; i < str.length(); i++) {
                try {
                    if (Integer.parseInt(String.valueOf(str.charAt(i))) % 1 == 0) {
                        strTemp+=str.charAt(i);
                        flag = true;
                    }
                } catch (Exception e) {
                    if(flag){
                        temp += Integer.parseInt(strTemp);
                        strTemp="";
                        flag = false;
                    }


                }
            }
            return temp;
        }
    }
}
