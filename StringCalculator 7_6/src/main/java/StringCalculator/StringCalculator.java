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
        String standardStr = standardString(str);
        if(str.isEmpty()){
            return 0;
        }else if(!isNotDelimiter(standardStr)){
            return -1;
        }
        else{
            for (int i = 0; i < standardStr.length(); i++) {
                try{

                    if(isNumber(String.valueOf(standardStr.charAt(i)))){
                        tmp+=standardStr.charAt(i);
                        flag =true;
                    }
                    if( (i == (standardStr.length()-1)) && isNumber(String.valueOf(standardStr.charAt(i)))){
                        if(Integer.parseInt(tmp) <= 1000)
                            temp +=Integer.parseInt(tmp);
                        tmp="0";
                    }
                }catch (Exception e){
                    if ((String.valueOf(standardStr.charAt(i)).equals("-")) && isNumber(String.valueOf(standardStr.charAt(i + 1)))){
                        negative = true;
                        while (i != standardStr.length()){
                            if(String.valueOf(standardStr.charAt(i)).equals("-") && isNumber(String.valueOf(standardStr.charAt(i + 1)))){
                                negativeStr+="-"+String.valueOf(standardStr.charAt(i+1));
                            }
                            i++;
                        }
                        if(negativeStr.length() == 2)
                            throw new IllegalArgumentException("negatives not allowed");
                        throw new IllegalArgumentException("negatives not allowed "+ negativeStr);
                    }
                    if(flag && Integer.parseInt(tmp) <= 1000){
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
    static boolean isNotDelimiter(String str){
        for (int i = 0; i < str.length(); i++){
            if(String.valueOf(str.charAt(i)).equals("n") || String.valueOf(str.charAt(i)).equals("\\") || (String.valueOf(str.charAt(i)).equals("!")) || (String.valueOf(str.charAt(i)).equals(",")) || (String.valueOf(str.charAt(i)).equals("-")) || (isNumber(String.valueOf(str.charAt(i))))){
            }else{
                return false;
            }
        }
        return true;
    }
    public static String standardString(String str){
        String tempStr1 ="";
        String tempStr2 ="";
        String returnStr ="";
        boolean flag = false;
        boolean two = false;
        if (str.isEmpty()){
            return "";
        }else{
            for(int i = 0; i < str.length(); i++){
                int j = 0;
                if(String.valueOf(str.charAt(i)).equals("/") && String.valueOf(str.charAt(i+1)).equals("/")){
                    j = i+2;
                    while (j < (str.length()-1) &&!(String.valueOf(str.charAt(j)).equals("\\")) && !(String.valueOf(str.charAt(j+1)).equals("n"))){
                        if(String.valueOf((str.charAt(j))).equals("[")){
                            int k = j+1;
                            while (!String.valueOf(str.charAt(k)).equals("]")){
                                tempStr1 +="\\"+String.valueOf((str.charAt(k)));
                                k++;
                            }
                        }
                        j++;
                    }
                    i = j+2;
                    flag = true;
                }
                returnStr += String.valueOf(str.charAt(i));
            }
            String temp ="";
            if(flag == true && two == false){
                temp = returnStr.replaceAll(tempStr1,"!");
                return temp;
            }else if(flag == true && two ==true){
                temp = returnStr.replaceAll(tempStr1,"!");
                String temp2 = temp.replaceAll(tempStr2,"!");
                return temp2;
            }else{
                return returnStr;
            }
        }
    }
}
