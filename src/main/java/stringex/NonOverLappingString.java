package stringex;

import datastructure.In;

public class NonOverLappingString {

    public static void main(String a[]){

        printString("ABCD".toCharArray(),"",4,0);
        generateBinayNumber(10);
    }

   public static void printString(char[] str,String res,int length,int start){

       if (length==start){
           System.out.println(res);
           return;
       }
       String con="";
       for(int i=start;i<length;i++){
           con=con+str[i]+"";
           printString(str,res+"{"+con+"}",length,i+1);
       }



    }


    static public void generateBinayNumber(int n){
        for(int i=0;i<=n;i++){
            System.out.println(Integer.toBinaryString(i));
        }
    }


}
