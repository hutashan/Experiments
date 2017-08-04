package stringex;


public class IncreaseNumber {

    public static void main(String a[]){
        increasingNumber("",8,0);
    }

    static  public void increasingNumber(String res,int n,int prev){
        if (n!=0){
            for (int ch = prev+1;ch<=9;ch++ ){
                increasingNumber(res+""+ch,n-1,ch);
            }
        } else{
            System.out.println(res);
        }
    }

}
