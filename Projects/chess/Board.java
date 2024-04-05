package floriannowak.projects.chess;

import floriannowak.projects.chess.pieces.*;
import static floriannowak.projects.chess.pieces.PlayerColor.*;
public class Board {

    

    
    private Piece[][] boardmap = new Piece [8][8];

    public char printSquare(int x, int y) {
        if (boardmap[x][y] == null) return '.';
        return boardmap [x][y].getShortType();
    }

    public boolean isSquareFree(Coordinates probe){
        return boardmap[probe.getX()][probe.getY()] == null;
    }
    

    boolean whiteCastled = false;
    boolean blackCastled = false;
    PlayerColor nowPlaying = WHITE;


    public Board() {   //(int iteration, int depth), future AI


        for (int i = 0; i < 8; i++){
            char 
            boardmap [6][i] = new Pawn(BLACK, new Coordinates(6, i), this);
            boardmap [1][i] = new Pawn(WHITE, new Coordinates(1, i), this);
        }
        // Populate the board with other pieces
        // Black pieces
        boardmap[7][0] = new Rook(BLACK, new Coordinates(7, 0), this);
        boardmap[7][1] = new Knight(BLACK, new Coordinates(7, 1), this);
        boardmap[7][2] = new Bishop(BLACK, new Coordinates(7, 2), this);
        boardmap[7][3] = new Queen(BLACK, new Coordinates(7, 3), this);
        boardmap[7][4] = new King(BLACK, new Coordinates(7, 4), this);
        boardmap[7][5] = new Bishop(BLACK, new Coordinates(7, 5), this);
        boardmap[7][6] = new Knight(BLACK, new Coordinates(7, 6), this);
        boardmap[7][7] = new Rook(BLACK, new Coordinates(7, 7), this);

        // White pieces
        boardmap[0][0] = new Rook(WHITE, new Coordinates(0, 0), this);
        boardmap[0][1] = new Knight(WHITE, new Coordinates(0, 1), this);
        boardmap[0][2] = new Bishop(WHITE, new Coordinates(0, 2), this);
        boardmap[0][3] = new Queen(WHITE, new Coordinates(0, 3), this);
        boardmap[0][4] = new King(WHITE, new Coordinates(0, 4), this);
        boardmap[0][5] = new Bishop(WHITE, new Coordinates(0, 5), this);
        boardmap[0][6] = new Knight(WHITE, new Coordinates(0, 6), this);
        boardmap[0][7] = new Rook(WHITE, new Coordinates(0, 7), this);

    }

    
    
    


}
