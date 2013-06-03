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
        String tmp = "0";
        boolean flag = false;
        int temp = 0;
        boolean negative = false;
        if(str.isEmpty()){
            return 0;
        }else{
            for (int i = 0; i < str.length(); i++) {
                try {
                    if ((String.valueOf(str.charAt(i)).equals("-")) && Integer.parseInt(String.valueOf(str.charAt(i+1))) % 1 == 0){
                        //System.out.println("ok");
                        negative = true;
                        System.out.println("negatives not allowed: "+ "-" + Integer.parseInt(String.valueOf(str.charAt(i+1))));
                    }
                    if (Integer.parseInt(String.valueOf(str.charAt(i))) % 1 == 0) {
                        tmp+=str.charAt(i);
                        flag = true;
                    }
                    if( (i == (str.length()-1)) && ((Integer.parseInt(String.valueOf(str.charAt(i))) % 1) == 0)){
                       if(Integer.parseInt(tmp) <= 1000){
                           temp +=Integer.parseInt(tmp);
                       }else{
                           tmp="0";
                       }
                    }

                } catch (Exception e) {
                    if (flag && Integer.parseInt(tmp) <= 1000){
                        temp += Integer.parseInt(tmp);
                        flag = false;
                        tmp="0";
                    }else {
                        tmp="0";
                    }
                }
            }
            if (negative){
                return -1;
            }else {
                return temp;
            }



        }
    }
}

