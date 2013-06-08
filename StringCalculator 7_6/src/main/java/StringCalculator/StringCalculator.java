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
        if(str.isEmpty()){
            return 0;
        }else{
            for (int i = 0; i < str.length(); i++) {
                try{

                    if(Integer.parseInt(String.valueOf(str.charAt(i)))%1 == 0){
                        tmp+=str.charAt(i);
                        flag =true;
                    }
                    if( (i == (str.length()-1)) && Integer.parseInt(String.valueOf(str.charAt(i))) % 1 ==0){
                        temp +=Integer.parseInt(tmp);
                    }
                }catch (Exception e){
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
}
