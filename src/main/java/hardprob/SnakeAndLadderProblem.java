package hardprob;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by parmana on 5/24/17.
 */
public class SnakeAndLadderProblem {

    public static class Qentry{
        int vertex;
        int distance;
    }

    public static int maximumThrow(int[] board,int N){

        boolean[] visited = new boolean[N];

        for (int i=0;i<N;i++){
            visited[i]=false;
        }

        Queue<Qentry> qn= new LinkedList<Qentry>();
        visited[0]=true;
        Qentry a= new Qentry();
        a.distance=0;
        a.vertex=0;

        qn.add(a);

        Qentry qe = new Qentry();

        while (!qn.isEmpty()){
         qe =qn.peek();

          int vertex= qe.vertex;
            if(vertex == N-1){
                break;
            }
            qn.remove();
            for(int i =vertex+1;i<=(vertex+6) && i<N;++i){

                  if(visited[i]==false) {
                      Qentry cell = new Qentry();
                      cell.distance = (qe.distance + 1);
                      visited[i] = true;

                       if(board[i]!=-1){
                           cell.vertex=board[i];
                       } else {
                           cell.vertex=i;
                       }

                      qn.add(cell);
                  }

            }


        }



return qe.distance;
    }

    public static void main(String[] args) {
        int N=30;
        int board[] = new int[N];

        for(int i=0;i<N;i++){
            board[i]=-1;
        }

        // ladder
        board[2]=21;
        board[4]=7;
        board[10]=25;
        board[19]=28;

       // snake
        board[26]=0;
        board[20]=8;
        board[16]=3;
        board[18]=6;

        System.out.println(maximumThrow(board, N));

    }

    //https://www.youtube.com/watch?v=19tY6Y90TP0


}
