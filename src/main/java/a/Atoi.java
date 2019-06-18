package a;

import java.io.CharArrayReader;

public class Atoi {
    public static void main(String[] args) {
        String test ="12  -34";
        System.out.println(new Atoi().myAtoi(test));
    }
    public int myAtoi(String str) {
        char[] strInChars = str.toCharArray();
        long value = 0;

        boolean hasNonSpace = false;
        boolean signLoaded = false;
        boolean isNegative = false;

        for(int i = 0; i < strInChars.length; i ++) {
            char current = strInChars[i];
            if(current == ' ') {
                if(hasNonSpace) {
                    break;
                }
            } else if(!signLoaded && current == '-') {
                isNegative = true;
                signLoaded = true;
                hasNonSpace = true;
            } else if(!signLoaded && current == '+') {
                signLoaded = true;
                hasNonSpace = true;
            } else if(current >= 48 && current <= 57) {
                hasNonSpace = true;
                signLoaded  = true;
                value *= 10;
                value += (current - 48);

                if(!isNegative && value >= Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }

                if(isNegative && -value <= Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        return (int)(isNegative ? -value : value);
    }
}
