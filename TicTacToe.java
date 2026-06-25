import java.util.*;
public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int row = 0; row <board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }
        char player = 'X';
        boolean gameover = false;
        int moves = 0;

        Scanner sc = new Scanner(System.in);
        while (!gameover){
            printboard(board);
            System.out.println("player" + player + "enter");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid Position! Try Again.");
                continue;
            }

            if(board[row][col]==' '){
                board[row][col] = player;
                gameover = haswon(board,player);
                if(gameover){
                    System.out.println("player " + player + "has won");
                }
                if (moves == 9) {
                    printboard(board);
                    System.out.println("Match Draw!");
                    break;
                }
                else {
                    if(player=='X'){
                        player ='O';
                    }else {
                        player = 'X';
                    }
                }

            }
            else {
                System.out.println("invaliad move try again");
            }
        }
        printboard(board);
        sc.close();
    }
    public static boolean haswon(char[][] board, char player){
        for (int row = 0; row <board.length; row++) {
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player ){
                return true;
            }
        }

        for (int col = 0;  col<board.length; col++) {
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player ){
                return true;
            }
        }
        //diagonally chck
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }

        return false;
    }
    public static void printboard(char[][] board){
        System.out.println();
        for (int row = 0; row <board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print( board[row][col] + " ");
                if (col < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
