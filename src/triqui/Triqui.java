package triqui;

import java.util.Scanner;

public class Triqui {

    public static void startGame(){
        // 1. Indetificar el primer jugador X - O
        // 2. Inicializar y mostrar tablero
        // 3. Leer el movimiento del jugador
        // 4. Verificar si hizo 3 en linea
        // Si lo hizo digo gano
        // sino
            // cambia de jugador
            // volver a 3
            var sc = new Scanner(System.in);
            var player = 'X';
            var isFinished = false;
            var counter = 0;

            var board = initializeBoard();
            do{
            showBoard(board);

            System.out.printf("Jugador %c ingresa tu movimiento: %n", player);
            System.out.print("Fila (1-3): ");
            var row =sc.nextInt() -1;
            System.out.print("Columna (1-3): ");
            var column = sc.nextInt() - 1;
            if(makeMove(board, row, column, player)){
                counter++;
               
                if(checkWinner(board, player)){
                    showBoard(board);
                    System.out.printf("Jugador %c gano! %n", player);
                    //Terminar el programa
                    isFinished = true;
                }else{
                    //cambiar de jugador
                    player = (player == 'X') ? 'O' : 'X';
                  
                }

            }else{
                System.err.println("Movimiento invalido, Intenta de nuevo");
            }
            if (counter == 9){
                showBoard(board);
                System.out.println("Han quedado empatados");
                isFinished = true;
            }
        }while(!isFinished);

                 sc.close();
                }

                private static boolean checkWinner(char[][] board, char player){
                    //validar las filas
                   for (var row : board){
                        if(row[0]== player && row[1] == player && row[2] == player){
                            return true;
                        }
                   }
                   //Validar las columnas
                   for (int i = 0; i < board[0].length; i++) {
                    if(board[0][i] == player && board[1][i] == player && board[2][i] == player){
                        return true;
                    }
                    
                   }
                   //Validar las diagonales
                   if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
                    return true;
                   }
                   if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
                    return true;
                   }
                   
                    return false;

                }

                       
                private static boolean makeMove(char[][] board, int row, int column, char player) {
                  if(board [row][column] != ' ') {
                    //Ya hay un valor en esta pociscion
                    return false;

                  }
                  else{
                    board[row][column] = player;
                    return true;
                  }
                }
            
                            private static void showBoard(char[][] board) {
                    for (int i = 0; i < board.length; i++) {
                        for (int j = 0; j < board[i].length; j++) {
                            System.out.print(board[i][j]);
                            if( j< board.length -1 ){
                                System.out.print(" | ");
                            }
                            
                        }
                        System.out.println();
                        if( i < board.length - 1 ){
                            System.out.println(" -------");
                        }
                        
                    }
                }
                private static char[][] initializeBoard() {
        var board = new char [3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j]= ' ';
            }
        }

        return board;
    }

}
