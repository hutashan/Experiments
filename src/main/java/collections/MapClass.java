package collections;

import java.util.HashMap;

/**
 * Created by v708178 on 9/12/17.
 */
public class MapClass {
    public static void main(String arg[]){
        HashMap <String,String > hs2 = new  HashMap <String,String >();
        HashMap <String,String > hs1 = new  HashMap <String,String >();
        HashMap <String,String > hs = new  HashMap <String,String >();

        hs1.put("1","s1");
        hs2.put("1","s");
        hs.putAll(hs1);
        hs.putAll(hs2);
        System.out.println("t");


    }
}
