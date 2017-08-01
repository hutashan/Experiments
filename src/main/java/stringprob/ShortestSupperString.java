package stringprob;

/**
 * Created by parmana on 7/20/17.
 */
public class ShortestSupperString {

    public static void main(String[] args) {

        String arr[]={"CATGC","CTAAGT","GCTA","TTCA","ATGCATC"};

        int l,r;

          for(int i=0;i<arr.length;i++){

              for(int j=i+1;j<arr.length;j++){
               String res= findMaxOverLapPair(arr[i],arr[j]);

              }


          }



        }


    public static String findMaxOverLapPair(String str1,String str2){

        int max=Integer.MIN_VALUE;
        String combinedstr="";

        // preFixTiSuffix



        // sufixtoPrefix
        int len=str1.length();
        int counter =0;
        for (int i=0;i<Math.min(str1.length(),str2.length());i++){

            if(str1.charAt(len)==str2.charAt(i)){
                counter++;
                if(counter>=max){
                    max=counter;
                }
            }
        }
        combinedstr=str1+str2.substring(counter,str2.length());

      return combinedstr+"#"+max;

    }


}
