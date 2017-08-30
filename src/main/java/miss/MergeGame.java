package miss;

import java.util.*;

/**
 * Created by parmana on 8/30/17.
 */
public class MergeGame {

    public static void main(String[] args) {

       //  int n =50,k=5,winNumber=10,maxmerge=5;
        int n =30,k=5,winNumber=25,maxmerge=4;

        List<Integer> playset= new java.util.ArrayList<Integer>() ;
        playset.add(20);
        playset.add(15);
        playset.add(12);
        playset.add(7);
        playset.add(10);
        Collections.sort(playset, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for(int i:playset){
            System.out.println(i);
        }

      List<Integer> supperSet= new java.util.ArrayList<Integer>()  ;
       for(int i=1;i<=n;i++){
            if(!playset.contains(i))
            supperSet.add(i);
        }


        for(int j=1;j<=maxmerge;j++){
            if(playset.size()>=2) {
                int least1 = playset.get(0);
                int least2 = playset.get(1);
                int sum =least1+least2;
                if(playset.contains(sum)){
                    playset.remove(0);
                    playset.remove(0);
                } else if(supperSet.contains(sum)) {
                    playset.remove(0);
                    playset.remove(0);
                    supperSet.remove(new Integer(sum));
                    playset.add(sum);
                    Collections.sort(playset);

                } else {
                    int wincondition =0;
                    for(int i:playset){
                        wincondition=wincondition+i;
                    }
                    if(wincondition>=winNumber && wincondition<=n){
                        System.out.println("Win");
                        return;

                    } else {
                        System.out.println("Lose");
                        return;
                    }
                }

            }

        }


        int wincondition =0;
        for(int i:playset){
            wincondition=wincondition+i;
        }
        if(wincondition>=winNumber){
            System.out.println("Win");
            return;

        } else {
            System.out.println("Lose");
            return;
        }



    }





}
