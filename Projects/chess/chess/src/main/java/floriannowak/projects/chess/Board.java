package floriannowak.projects.chess;

import floriannowak.projects.chess.pieces.*;

public class Board {

    

    
    private Piece[][] boardmap = new Piece [8][8];

    public char printSquare(int x, int y) {
        if (boardmap[x][y] == null) return '.';
        return boardmap [x][y].getShortType();
    }


    boolean whiteCastled = false;
    boolean blackCastled = false;
    boolean whiteToMove = true;


    public Board() {   //(int iteration, int depth), future AI


        for (int i = 0; i < 8; i++){
            boardmap [6][i] = new Pawn(PlayerColor.BLACK, new Coordinates(6, i));
            boardmap [1][i] = new Pawn(PlayerColor.WHITE, new Coordinates(1, i));
        }

    }

    /**
     * 
     */
    public void printBoard () {

        for (int x = 7; x >= 0; x--)
        {
            for (int y = 0; y < 8; y++){
                System.out.print(printSquare(x, y) + " ");
            }
            System.out.print("\n");
        }
    }    
    


}
