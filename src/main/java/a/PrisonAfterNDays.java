package a;
import java.util.*;

public class PrisonAfterNDays {
    public static void main(String[] args) {
        int[] input ={1,0,0,1,0,0,1,0};
        int N=1000000000;
        int [] result = new PrisonAfterNDays().prisonAfterNDays(input,N);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
    public int[] prisonAfterNDays(int[] cells, int N) {

        int[] firstSimulation = new int[8];
        for (int i=1; i<7; i++) firstSimulation[i] = (cells[i-1] == cells[i+1] ? 1 : 0);
        cells = firstSimulation.clone();
        N -= 1;
        int cycle = 1;
        while (N-- > 0) {
            int[] nextSimulation = new int[8];
            for (int i=1; i<7; i++) nextSimulation[i] = (cells[i-1] == cells[i+1] ? 1 : 0);
            if (Arrays.equals(firstSimulation, nextSimulation)) N %= cycle;
            cells = nextSimulation.clone();
            cycle++;
        }
        return cells;
    }

}
