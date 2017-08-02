package stringex;


public class ReplaceNumberWithStr {

    public static void main(String arg[]){

        char [] setIn ={1,2,2};
        convertString(setIn,0);


    }
    public static void convertString(char [] set,int index){

        char[] c = new char[set.length];
        for(int i=0;i<set.length;i++){

            char re ='A';
            if (set[i]==1){
                c[i] =re;
            } else{
                c[i]= (char) (re+1);
            }

            System.out.print(c[i]);
        }



       // System.out.printf("result" + c.toString());

    }

}
