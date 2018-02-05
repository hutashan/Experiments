package stringex;
// https://www.hackerrank.com/challenges/game-of-thrones?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

public class GameOfThrone {
    public static void main(String a[]){
        gameOfThrones("cdcdcdcdeeeef");
    }
    static String gameOfThrones(String s){
       int[] indicator =  new int [26] ;
       char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
           int charIndex = arr[i]-'a';
             int v = indicator[charIndex] ;
            if(v==1){
                v=0;
            } else if(v==0){
                v=1;
            }
            indicator[charIndex] =v;

        }
        int sum=0;
        for(int i =0;i<indicator.length;i++){
            sum = sum+indicator[i];

        }
        String res="";
        if(sum==0 || sum==1){
            res="YES";
        } else{
            res="NO";
        }
        System.out.println(res);
     return "";
    }
}
