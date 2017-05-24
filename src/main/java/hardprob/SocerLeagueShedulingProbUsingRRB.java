package hardprob;

/**
 * Created by parmana on 5/23/17.
 */
public class SocerLeagueShedulingProbUsingRRB {

    static String [] teams ={"A","B","C","D","E","F"};

    static String [] group1 = new String[teams.length/2];
    static String [] group2 = new String[teams.length/2];

    public static void main(String[] args) {

       // System.out.println(teams.length);
     teamAssign();

        System.out.println(" ---- Teams Playing -----  ");
        for(int i=1;i<teams.length;i++){
            teamsPlaying(i);
            teamShift();
        }
    }


   public static void teamAssign(){

       for(int i=0;i<teams.length/2;i++){
           group1[i]=teams[i];
       }
       int len=teams.length/2;
       for(int i=teams.length/2;i<teams.length;i++){
           group2[i-len]=teams[i];
       }
     // printGrpTeam();

   }

    public static void teamShift(){
        String currentTeam=group1[1];
        for(int i=2;i<group1.length;i++){
            String temp=group1[i];
            group1[i]=currentTeam;
            currentTeam=temp;
        }

        for(int i=group2.length-1;i>=0;i--){
            String temp=group2[i];
            group2[i]=currentTeam;
            currentTeam=temp;
        }
        group1[1]=currentTeam;
       // printGrpTeam();
    }

    public static void printGrpTeam(){
        System.out.println("Group 1");
        for(String a:group1){
            System.out.print(a);
        }
        System.out.println();
        System.out.println("Group 2");
        for(String a:group2){
            System.out.print(a);
        }
        System.out.println();
    }

  public static void teamsPlaying(int round){
      System.out.println("Round - "+round);
       for(int i=0;i<group1.length;i++){
           System.out.print(group1[i]+""+group2[i] +" - ");
       }
      System.out.println();
  }


}
