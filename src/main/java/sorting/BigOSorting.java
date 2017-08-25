package sorting;

import java.util.Arrays;
import java.util.Comparator;

public class BigOSorting {
    public static void main(String a[]){
         String[] ar =   {"31415926535897932384626433832795","1","3","6","5"};
        Arrays.sort(ar,new Comparator<String>() {
            @Override
            public int compare(String a, String b)
            {
                return StringAsIntegerCompare(a,b);
            }
        });
        for (int i=0;i<ar.length;i++){

            System.out.println(ar[i]);
        }

    }
    static int StringAsIntegerCompare(String s1, String s2)
    {
        if(s1.length() > s2.length()) return 1;
        if(s1.length() < s2.length()) return -1;
        for(int i = 0; i < s1.length(); i++)
        {
            if((int)s1.charAt(i) > (int)s2.charAt(i)) return 1;
            if((int)s1.charAt(i) < (int)s2.charAt(i)) return -1;
        }
        return 0;
      //  String a = "s";

    }

}
