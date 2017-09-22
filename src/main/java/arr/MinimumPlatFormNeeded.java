package arr;

import java.util.Arrays;

/**
 * Created by parmana on 9/11/17.
 */

// find the minimum platoform needed in the stattion so to avoid any delay in arriavl any train
public class MinimumPlatFormNeeded {


    public static void main(String[] args) {

        double[] arrival={2.00,2.10,3.00,3.20,3.50,5.00};
        double[] departure={2.30,3.40,3.20,4.30,4.00,5.20};

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int count=0;
        int platform=0;
        int i=0,j=0;

        while (i<arrival.length-1){

                while (arrival[i]<departure[j]){

                    platform = Math.max(platform,++count);
                    i++;
                }

            count--;
            j++;

        }


        System.out.println(platform);



    }




}
