package StringCalculator;

/**
 * Created with IntelliJ IDEA.
 * User: thanhtd
 * Date: 08/06/2013
 * Time: 11:34
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {

    public static int add(String str) {
        boolean flag =false;
        String tmp = "0";
        int temp = 0;
        String negativeStr ="";
        boolean negative = false;
        if(str.isEmpty()){
            return 0;
        }else{
            for (int i = 0; i < str.length(); i++) {
                try{

                    if(isNumber(String.valueOf(str.charAt(i)))){
                        tmp+=str.charAt(i);
                        flag =true;
                    }
                    if( (i == (str.length()-1)) && isNumber(String.valueOf(str.charAt(i)))){
                        temp +=Integer.parseInt(tmp);
                    }
                }catch (Exception e){
                    if ((String.valueOf(str.charAt(i)).equals("-")) && isNumber(String.valueOf(str.charAt(i + 1)))){
                        negative = true;
                        while (i != str.length()){
                            if(String.valueOf(str.charAt(i)).equals("-") && isNumber(String.valueOf(str.charAt(i + 1)))){
                                negativeStr+="-"+String.valueOf(str.charAt(i+1));
                            }
                            i++;
                        }
                        if(negativeStr.length() == 2)
                            throw new IllegalArgumentException("negatives not allowed");
                        throw new IllegalArgumentException("negatives not allowed "+ negativeStr);
                    }
                    if(flag){
                        temp += Integer.parseInt(tmp);
                        flag =false;
                        tmp="0";
                    }
                }
            }
            return temp;
        }
    }
    static boolean isNumber(String str){
        if (Integer.parseInt(str) % 1 == 0)
            return true;
        return false;
    }
}
