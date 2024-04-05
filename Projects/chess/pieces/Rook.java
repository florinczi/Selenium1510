package floriannowak.projects.chess.pieces;

import java.util.Set;

import floriannowak.projects.chess.Board;
import floriannowak.projects.chess.Coordinates;

public class Rook extends Piece{

    public Rook(PlayerColor player, Coordinates location, Board activeBoard) {
        super(player, location, activeBoard);
        if (player == PlayerColor.BLACK) super.setShortType('r');
        else super.setShortType('R');
    }

    @Override
    public Set<Coordinates> checkPossibleMoves() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isValidMove(Coordinates coordinates) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        
    }

}
