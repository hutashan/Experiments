package hardprob;

import java.util.*;

/**
 * Created by parmana on 4/14/17.
 */
public class SocerLeagueShedulingProb {

    static List<String> played= new java.util.ArrayList<String>() ;
    static  String teams[] = {"A","B","C","D","E","F"};
    public static void main(String[] args) {


       // shuffleArray(teams);
       // Collections.shuffle(Arrays.asList(teams));
        for(String a:teams){
            System.out.println(a);
        }


        /*List<String> teams = new java.util.ArrayList<String>();
        teams.add("A");
        teams.add("B");
        teams.add("C");
        teams.add("D");
        System.out.println(teams.contains("C"));*/
        int round =teams.length-1;

        for(int i=0;i<round;i++){
           String temp[]=  Arrays.copyOf(teams,teams.length);
                  // Collections.copy(temp,teams);
           /* int gcouter=0;
           for(String t:temp){
               int counter=0;

               while (counter<=round) {
                   String t2 = temp[counter];
                   if (t != t2 && t!="0" && t2!="0") {
                     String t3= getTeam(t+""+t2);
                       if(!played.contains(t3)){
                           played.add(t3);
                           temp[counter]="0";
                            temp[gcouter]="0";
                           break;
                       }
                   }
                   counter++;
               }
               gcouter++;
           }*/
            getTeamsToPlay(temp,i,0);
            played.add("round-"+i +"\n");


        }

        System.out.println(played.toString());
    }

   public static String getTeam(String teams){
      char[] t= teams.toCharArray();
       Arrays.sort(t);
       return new String(t);
   }


    private static void shuffleArray(String[] array)
    {

        int index;
        String temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    private static void getTeamsToPlay(String temp[],int round,int gcouter ){
        List <String> currentRoundTeams = new ArrayList<String>();
        for(String t:temp){
            int counter=0;

            while (counter<=temp.length-1 ) {
                String t2 = temp[counter];
                if (t != t2 && t!="0" && t2!="0") {
                    String t3= getTeam(t+""+t2);
                    if(!played.contains(t3)){
                        //played.add(t3);
                        currentRoundTeams.add(t3);
                        temp[counter]="0";
                        temp[gcouter]="0";
                        break;
                    }
                }
                counter=counter+1;
            }
            gcouter++;
        }
        System.out.println("currentRoundTeams---"+currentRoundTeams.size());
        if(currentRoundTeams.size()==3){
            for(String s:currentRoundTeams){
                played.add(s);
            }
        } else {
            //Collections.shuffle(Arrays.asList(teams));
             temp=  Arrays.copyOf(teams,teams.length);
            shuffleArray(temp);
            getTeamsToPlay(temp,round,0);
        }


    }



    public void rotateArray(){

        String[] a1={"A","B","C"};
        String[] a2={"D","E","F"};

          for(int i=1;i<5;i++){
            String temp1=a1[2];
              String temp2=a2[0];

              String temp=a1[1];
              for(int j=2;j<a1.length;j++){
                  String rep=temp;
                  a1[j]=temp;
                  temp=rep;
                  //temp=a1[j];
              }
              a1[1]=temp2;
               temp=a2[1];
              for(int j=2;j<a1.length;j++){
                  String rep=a1[j];
                  a1[j]=temp;
                  temp=a1[j];
              }
              a2[1]=temp2;

          }

    }

}
