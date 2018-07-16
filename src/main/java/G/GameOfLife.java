package G;

public class GameOfLife {
    public static void main(String arg[]) {
        int[][] Input = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        int[][] output = new GameOfLife().gameOfLife1(Input);
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public int[][] gameOfLife1(int[][] board) {


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int countLive = calculateLive(board,i,j);
                if(countLive<2 && board[i][j]==1){
                    board[i][j]=1;
                } else if((countLive==2 && board[i][j]==1) || (countLive==3 && board[i][j]==1)){
                    board[i][j]=3;
                } else if(countLive> 3 && board[i][j]==1){
                    board[i][j]=1;
                }else if(countLive==3 && board[i][j]==0){
                    board[i][j]=2;
                } else {
                    board[i][j] = board[i][j];
                }

            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j]/2;
            }
        }
        return board;
    }

    public void gameOfLife(int[][] board) {
        int[][] oriBoard = new int[board.length][board[0].length];
        for (int i = 0; i < oriBoard.length; i++) {
            for (int j = 0; j < oriBoard[0].length; j++) {
                oriBoard[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < oriBoard.length; i++) {
            for (int j = 0; j < oriBoard[i].length; j++) {
                int countLive = calculateLive(oriBoard,i,j);
                if(countLive<2 && oriBoard[i][j]==1){
                    board[i][j]=0;
                } else if((countLive==2 && oriBoard[i][j]==1) || (countLive==3 && oriBoard[i][j]==1)){
                    board[i][j]=1;
                } else if(countLive> 3 && oriBoard[i][j]==1){
                    board[i][j]=0;
                }else if(countLive==3 && oriBoard[i][j]==0){
                    board[i][j]=1;
                } else {
                    board[i][j] = oriBoard[i][j];
                }

            }
        }

    }

    public int calculateLive(int[][] board,int rowPos,int colPos){
        int count =0;

            int newRow = rowPos-1;
            int newCol = colPos-1;
            if(newRow>=0&&newCol>=0 && newRow<board.length &&  newCol<board[0].length  && board[newRow][newCol]%2==1){
                count ++;
            }
            newCol =newCol+1;
           if(newRow>=0&&newCol>=0 && newRow<board.length &&  newCol<board[0].length  && board[newRow][newCol]%2==1){
                count ++;
            }
            newCol =newCol+1;
            if(newRow>=0&&newCol>=0 && newRow<board.length &&  newCol<board[0].length  && board[newRow][newCol]%2==1){
                count ++;
            }
            newRow = newRow +1;
            if(newRow>=0&&newCol>=0 && newRow<board.length &&  newCol<board[0].length  && board[newRow][newCol]%2==1){
                count ++;
            }
            newRow = newRow +1;
        if(newRow>=0&&newCol>=0 && newRow<board.length &&  newCol<board[0].length  && board[newRow][newCol]%2==1){
                count ++;
            }
            newCol = newCol-1;
        if(newRow>=0&&newCol>=0 && newRow<board.length &&  newCol<board[0].length  && board[newRow][newCol]%2==1){
                count ++;
            }
            newCol = newCol-1;
        if(newRow>=0&&newCol>=0 && newRow<board.length &&  newCol<board[0].length  && board[newRow][newCol]%2==1){
                count ++;
            }
            newRow = newRow-1;
        if(newRow>=0&&newCol>=0 && newRow<board.length &&  newCol<board[0].length  && board[newRow][newCol]%2==1){
                count ++;
            }
            return count;




    }
}
