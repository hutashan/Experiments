package stringex;


import java.util.Set;

public class ConvertStringToAlphabat {

    public static void main(String arg[]){
        char [] setIn = {1,2,3};
        convert(setIn,setIn.length,0,"");
    }
    public static void convert(char [] setIn,int n,int k,String res){
        char[] alph ="ABCDEFGHIJKLMNOPQRSTUJVXWZ".toCharArray();
            if (n==k){
                System.out.println(res);
                return;
            }
        int sum=0;
        for (int i=k;i<=Math.min(k+1,n-1);i++){
            sum = sum*10+setIn[i];
            if (sum<=26){
                convert(setIn,n,i+1,res+alph[sum-1]);
            }
        }

    }

}
