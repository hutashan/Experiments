package hardprob;


import datastructure.In;

/*
egg-dropping-puzzle
 */
public class EggDroppingProblem {
    public static void main(String arg[]){
        System.out.println(eggDroppingProblemDynamic(2,5));

    }

    static public int eggDroppingProblemDynamic(int numberOfEggs,int floors) {


        int[][] lookup = new int[numberOfEggs + 1][floors + 1];
        for (int i = 1; i <= numberOfEggs; i++) {
            lookup[i][1] = 1;
            lookup[i][0] = 0;
        }
        for (int i = 0; i < floors; i++) {
            lookup[1][i] = i;
        }

        int min = Integer.MAX_VALUE, res;
        for (int y = 2; y <= numberOfEggs; y++)
            for (int x = 2; x <= floors; x++) {
                lookup[y][x] = Integer.MAX_VALUE;
                for (int z = 1; z <= x; z++) {
                    res = 1 + Math.max(lookup[y - 1][z - 1], lookup[y][x - z]);
                    if (res < lookup[y][x])
                        lookup[y][x] = res;
                }

            }
       return lookup[numberOfEggs][floors];
    }


   static public int eggDroppingProblem(int floors,int numberOfEggs) {
        if (floors==0 || floors ==1){
            return floors;
        }
        if (numberOfEggs==1){
            return floors;
        }
        int min= Integer.MAX_VALUE,res;
        for ( int x =1;x<=floors;x++){
            res=Math.max(eggDroppingProblem(x-1,numberOfEggs-1),eggDroppingProblem(floors-x,numberOfEggs));
            if (res < min)
                min = res;
        }
       return min +1;
   }
}
