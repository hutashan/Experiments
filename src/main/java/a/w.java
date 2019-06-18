package a;

import java.util.ArrayList;
import java.util.*;

public class w {


    public static void main(String[] args) {




        List<List<Integer>> arrays = new ArrayList<List<Integer>>();
        int[] a = new int [arrays.get(0).size()];
        int[] b = new int [arrays.get(1).size()];
        int[] c = new int [arrays.get(2).size()];

        for (int i =0; i < arrays.get(0).size(); i++)
            a[i] = arrays.get(0).get(i);
        for (int i =0; i < arrays.get(1).size(); i++)
            b[i] = arrays.get(1).get(i);
        for (int i =0; i < arrays.get(2).size(); i++)
            c[i] = arrays.get(2).get(i);

    }

}
