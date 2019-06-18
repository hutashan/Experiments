package TopQ;

import java.util.*;

public class IsValidSudoku {
   

    public static void main(String[] args) {
char[][]board= {{'.','.','.','1','8','.','.','.','7'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','.','.','.','.','.','3'},
                {'4','.','3','.','.','.','.','1','9'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'1','.','.','.','5','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','6'}

                
    };
        System.out.println(new IsValidSudoku().isValidSudoku(board));
    }
        Set<Integer> colvalidated = new HashSet<Integer>();
        Set<Integer> rowvalidated = new HashSet<Integer>();
        Set<String> blockedvalidated = new HashSet<String>();
        public boolean isValidSudoku(char[][] board) {
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board.length;j++){
                    if(board[i][j]!='.')
                    if(!isRow(board,i,j) || !isCol(board,i,j) || !isBlock(board,i,j)) return false;
                }
            }

            return true;

        }

        private boolean isRow(char[][] board,int i,int j){
            Set<Character> testSet = new HashSet<>();
            if(rowvalidated.contains(i)) return true;
            for(int k=0;k<board.length;k++){
                if(board[i][k]!='.'){
                    Character c = board[i][k];
                    if(testSet.contains(c)) return false;
                    else testSet.add(c);
                }
            }
            rowvalidated.add(i);
            return true;
        }
        private boolean isCol(char[][] board,int i,int j){
            Set<Character> testSet = new HashSet<>();
            if(colvalidated.contains(j)) return true;
            for(int k=0;k<board.length;k++){
                if(board[k][j]!='.'){
                    Character c = board[k][j];
                    if(testSet.contains(c)) return false;
                    else testSet.add(c);
                }
            }
            colvalidated.add(j);
            return true;
        }
        private boolean isBlock(char[][] board,int i,int j){
            String memKey = i+","+j;
            Set<Character> testSet = new HashSet<>();
            int rowStart =0;
            int colStart =0;
            if((i>3)&& i<6) rowStart=3;
            else if(i>=6) rowStart =6;
            if((j>3)&& j<6) colStart=3;
            else if(j>=6) colStart =6;

            if(blockedvalidated.contains(testSet)) return true;
            for(int k=rowStart;k<=(rowStart+2);k++) {
                for (int l = colStart; l <= (colStart + 2); l++) {
                    if (board[k][l] != '.') {
                        Character c = board[k][l];
                        if (testSet.contains(c)) return false;
                        else testSet.add(c);
                    }
                }
            }
            blockedvalidated.add(memKey);
            return true;
        }
}
