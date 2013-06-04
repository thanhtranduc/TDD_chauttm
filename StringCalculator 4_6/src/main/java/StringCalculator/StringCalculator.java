package StringCalculator;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhIntel
 * Date: 6/4/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {
    public static int add(String str) throws Exception{
        String tmp = "0";
        boolean flag = false;
        int temp = 0;
        String negativeStr ="";
        boolean negative = false;
        boolean notAllow = false;
        if(str.isEmpty()){
            return 0;
        }else{
            //String standardStr = standardString(str);
            for (int i = 0; i < str.length(); i++) {
                try {
                    if (checkNumber(String.valueOf(str.charAt(i)))){
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
                    if ((String.valueOf(str.charAt(i)).equals("-")) && checkNumber(String.valueOf(str.charAt(i+1)))){
                        negative = true;
                        while (i != str.length()){
                            if(String.valueOf(str.charAt(i)).equals("-") && checkNumber(String.valueOf(str.charAt(i+1)))){
                                negativeStr+="-"+String.valueOf(str.charAt(i+1));
                            }
                            i++;
                        }
                        if(negativeStr.length() == 2){
                            throw new IllegalArgumentException("negatives not allowed");
                        }else {
                            throw new IllegalArgumentException("negatives not allowed "+ negativeStr);
                        }
                    }
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
    public static String standardString(String str){
        String tempStr ="";
        String returnStr = "";
        for(int i = 0; i < str.length(); i++){
            int j = 0;
            if(String.valueOf(str.charAt(i)).equals("/") && String.valueOf(str.charAt(i+1)).equals("/")){
                j = i+2;
                while (j < (str.length()-1) &&!(String.valueOf(str.charAt(j)).equals("\\")) && !(String.valueOf(str.charAt(j+1)).equals("n"))){
                    if(String.valueOf((str.charAt(j))).equals("[") || String.valueOf((str.charAt(j))).equals("]")){

                    }else {
                        tempStr +="\\"+String.valueOf(str.charAt(j));
                    }
                    j++;
                }
                i = j+2;
            }
            returnStr += String.valueOf(str.charAt(i));
        }
        String temp ="";
        temp = returnStr.replaceAll(tempStr,"`");
        return temp;
    }
}

