package G;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Fibonicc {
    public static void main(String arg[])
    {
        new Fibonicc().printAllFibo("123456578");

    }
    public void slice(String s,int c){
        for(int i=c*3;i<=s.length();){
            System.out.println( i+" first "+s.substring(i-3*c,i-2*c));
            System.out.println( i+" second "+s.substring(i-2*c,i-c));
            System.out.println( i+" thrid "+s.substring(i-c,i));
            i=i+c;
            System.out.println( "after"+i);
        }
    }
    public void printAllFibo(String s){
        int group =1;
        HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        char[] chArr =s.toCharArray();

            while(group<s.length()) {
                String pattern =  "^[0-9]{2}$";
                boolean fl =false;
                for (int i = 3*group; i <= s.length(); ) {
                    int first = Integer.parseInt(s.substring(i-3*group,i-2*group));
                    int second = Integer.parseInt(s.substring(i-2*group,i-group));
                    int third = Integer.parseInt(s.substring(i-group,i));
                    System.out.println("first " + first + " Second " + second + " third " + third);
                    System.out.println(first + second == third);
                    i=i+group;
                    if (first + second == third) {
                        ar.add(first);
                        if(i>s.length()){
                            ar.add(second);
                            ar.add(third);
                            fl=true;
                        }


                    } else{
                        break;
                    }

                }
                if (fl) {
                    System.out.println(ar);
                    return;
                } else {

                    group++;
                    ar.clear();

                }
            }
        System.out.println(-1);

    }

    public static class SpiralMatrix {

        public static void main(String arg[]){
            int [][] arr1 ={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
            int [][] arr2 ={{1,2,3},{4,5,6},{7,8,9}};
            int [][] arr ={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
            System.out.println(new SpiralMatrix().spiralOrder(arr));

        }

        public List<Integer> spiralOrder(int[][] matrix) {
            if(matrix.length==0 ) return null;
            ArrayList<Integer> al = new ArrayList<Integer>();
            int col1=0,row=0;
            int count =0;
            while(col1<matrix[0].length && row<matrix.length ){
               col1 =count;
               row =count;
               while(col1<matrix[0].length-count){
                al.add(matrix[row][col1]);
                col1++;
               }
               if(matrix[0].length*matrix.length==al.size()){
                   return al;
               }
                col1--;
                row++;
                while(row<matrix.length-count){
                    al.add(matrix[row][col1]);
                    row++;
                }
                if(matrix[0].length*matrix.length==al.size()){
                    return al;
                }
                row--;
                col1--;
                while(col1<matrix[0].length-count && col1>=count){
                    al.add(matrix[row][col1]);
                    col1--;
                }
                if(matrix[0].length*matrix.length==al.size()){
                    return al;
                }
                row--;
                col1++;
                while(row<matrix.length-count && row>count){
                    al.add(matrix[row][col1]);
                    row--;
                }
                if(matrix[0].length*matrix.length==al.size()){
                    return al;
                }

                count++;

            }
           return al;
        };

    }
}
