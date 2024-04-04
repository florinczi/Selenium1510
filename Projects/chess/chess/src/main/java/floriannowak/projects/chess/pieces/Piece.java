package floriannowak.projects.chess.pieces;

import floriannowak.projects.chess.Board;
import floriannowak.projects.chess.Coordinates;

public abstract class Piece implements PieceAction{

   

   

    protected Piece (PlayerColor player, Coordinates location, Board activeBoard){
        this.location = location;
        this.player = player;
        this.activeBoard = activeBoard;
    }

    private char shortType; // char representation of the piece on the board
  
    public char getShortType() {
        return shortType;
    }

    public void setShortType(char shortType) {
        this.shortType = shortType;
    }


    private Coordinates location; // where is the piece now

    public Coordinates getLocation() {
        return location;
    }

    public void setLocation(Coordinates location) {
        this.location = location;
    }

    private PlayerColor player; //whose piece is it

    public PlayerColor getPlayer() {
        return player;
    }

    private Board activeBoard;

    public Board getActiveBoard() {
        return activeBoard;
    }

   

}
