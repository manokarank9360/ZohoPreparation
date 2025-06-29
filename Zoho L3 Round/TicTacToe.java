import java.util.*;

public class TicTacToe{
    private static int n;
    private static char[][] board;
    private static char currentPlayer;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the grid(n x n) : ");
        n=sc.nextInt();
        board=new char[n][n];
        initializeBoard();

        currentPlayer='X';
        int moves=0;
        boolean gameWon=false;

        while(moves<(n*n) && !gameWon){
            printBoard();
            System.out.printf("Player %c Enter Your Move(row and column)",currentPlayer);
            int row=sc.nextInt();
            int column=sc.nextInt();
            if(isValidMove(row, column)){
                board[row][column]=currentPlayer;
                moves++;
                if(checkWin(row, column)){
                    gameWon=true;
                    printBoard();
                    System.out.printf("Player %c wins the Game.",currentPlayer);
                    return;
                }
                else currentPlayer=currentPlayer=='X'?'O':'X';
            }
            else System.out.println("Invalid Choice!");
        }
        if(!gameWon){
            printBoard();
            System.out.println("Game is Draw!");
        }
        sc.close();
    }

    private static void initializeBoard(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='-';
            }
        }
    }

    private static void printBoard(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int column){
        return row>=0 && row<n && column>=0 && column<n && board[row][column]=='-';
    }

    private static boolean checkWin(int row, int column){
        return checkRow(row) || checkColumn(column) || checkDiagonal();
    }

    private static boolean checkRow(int row){
        for(int i=0;i<n;i++){
            if(board[row][i]!=currentPlayer){
                return false;
            }
        }
        return true;
    }

    private static boolean checkColumn(int column){
        for(int i=0;i<n;i++){
            if(board[i][column]!=currentPlayer){
                return false;
            }
        }
        return true;
    }

    private static boolean checkDiagonal(){
        boolean d1=true, d2=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j && board[i][j]!=currentPlayer){
                    d1=false;
                }
                if(j==n-i-1 && board[i][j]!=currentPlayer){
                    d2=false;
                }
            }
        }
        return d1 || d2;
    }
}