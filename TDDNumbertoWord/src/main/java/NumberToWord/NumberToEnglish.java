package NumberToWord;

/**
 * Created with IntelliJ IDEA.
 * User: ThanhIntel
 * Date: 5/16/13
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class NumberToEnglish {
    public int number;
    public String str;
    public static String NumberToWord(int n){
        String str;
        if (n == 0){
            return "zero";
        }
        if( n > 0 && n <= 10){
            return readUnit(n,"");
        }
        if (n > 10 && n < 100){
            return readDozens(n);
        }
        if ( n >= 100 && n < 1000){
            return readHundred(n);
        }
        if ( n>=1000 && n < 1000000){
            int temp = n/1000;
            int mode = n%1000;
            if(temp <=10){
                return readUnit(temp," thousand")+" "+ readHundred(mode);
            }else if(temp > 10 && temp <= 99){
                return readDozens(temp)+" thousand "+ readHundred(mode);
            }else if(temp >99 && temp < 1000){
                return readHundred(temp)+ "thousand "+ readHundred(mode);
            }
        }
        if ( n >= 1000000 && n < 1000000000){
            int temp = n/1000000;
            int mode = n%1000000;
            int temp1 = mode/1000;
            int mode1 = mode%1000;
            if(temp <=10 && temp1 ==0){
                return readUnit(temp," million ")+readHundred(mode1);
            }else if(temp <=10 && temp1 !=0){
                return readUnit(temp," million ") + readHundred(temp1)+"thousand "+ readHundred(mode1);
            }else if(temp >10 && temp <= 99 && temp1 !=0){
                return readDozens(temp)+" million "+ readHundred(temp1)+"thousand "+ readHundred(mode1);
            }else if(temp >10 && temp <= 99 && temp1 ==0){
                return readDozens(temp)+" million "+ readHundred(mode1);
            }else if(temp > 99 && temp < 1000000 && temp1 != 0){
                return readHundred(temp)+"million "+ readHundred(temp1)+"thousand "+ readHundred(mode1);
            }else if (temp > 99 && temp < 1000000 && temp1 == 0){
                return readHundred(temp)+"million "+ readHundred(mode1);
            }
        }
        return null;
    }

    public static String readHundred(int number){
        int temp = number/100;
        int mode = number%100;
        if(temp != 0 && mode == 0){
            return readUnit(temp," hundred ");
        }else if(temp != 0 && mode != 0){
            return readUnit(temp," hundred ") + readDozens(mode) +" ";
        }else if(temp ==0 && (mode >0 && mode < 11) ){
            return readUnit(mode," ");
        }else if(temp ==0 && (mode >10 && mode <100) ){
            return readDozens(mode)+" ";
        }else{
            return "";
        }
    }
    public static String readUnit(int number, String str){
        //if(number >= 0 && number <= 10){
            switch (number){
                case 0:
                    return "" +str;
                case 1:
                    return "one" +str;
                case 2:
                    return "two" +str;
                case 3:
                    return "three"+str;
                case 4:
                    return "four"+str;
                case 5:
                    return "five"+str;
                case 6:
                    return "six"+str;
                case 7:
                    return "seven"+str;
                case 8:
                    return "eight"+str;
                case 9:
                    return "nine"+str;
                case 10:
                    return "ten"+str;
            }
       // }
        return null;
    }

    public static String readDozens(int num){
        //if (num > 10 && num < 100){
            int _num = num/10;
            int mode = num%10;
            switch (_num){
                case 0:
                    return "";
                case 1:
                    if(mode == 1){
                        return "eleven";
                    }else if(mode == 2){
                        return "twelve";
                    }else{
                        return readUnit(mode,"")+"teen";
                    }
                case 2:
                    return "twenty "+ readUnit(mode,"");
                case 3:
                    return "thirty "+ readUnit(mode,"");
                case 4:
                    return "forty "+ readUnit(mode,"");
                case 5:
                    return "fifty "+ readUnit(mode,"");
                case 6:
                    return "sixty "+ readUnit(mode,"");
                case 7:
                    return "seventy "+ readUnit(mode,"");
                case 8:
                    return "eighty "+ readUnit(mode,"");
                case 9:
                    return "ninety "+ readUnit(mode,"");
            }
        //}

        return null;
    }

}
