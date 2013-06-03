package StringCalculator;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhIntel
 * Date: 6/3/13
 * Time: 1:45 PM
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
                    if ((String.valueOf(str.charAt(i)).equals("-")) && checkNumber(String.valueOf(str.charAt(i+1)))){
                        negative = true;
                        System.out.println("negatives not allowed: "+ "-" + Integer.parseInt(String.valueOf(str.charAt(i+1))));
                    }
                    if (checkNumber(String.valueOf(str.charAt(i)))) {
                        tmp+=str.charAt(i);
                        flag = true;
                    }
                    if( (i == (str.length()-1)) && checkNumber(String.valueOf(str.charAt(i)))){
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
            if (negative)
                return -1;
            return temp;
        }
    }
    static boolean checkNumber(String str){
        if (Integer.parseInt(str) % 1 == 0)
            return true;
        return false;
    }
}

