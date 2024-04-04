package floriannowak.projects.chess.pieces;

import java.util.Set;

import floriannowak.projects.chess.Board;
import floriannowak.projects.chess.Coordinates;

public class Queen extends Piece{

    public Queen(PlayerColor player, Coordinates location, Board activeBoard) {
        super(player, location, activeBoard);
        if (player == PlayerColor.BLACK) super.setShortType('q');
        else super.setShortType('Q');
    }

    @Override
    public boolean isValidMove(Coordinates coordinates) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValidMove'");
    }

    @Override
    public Set<Coordinates> checkPossibleMoves() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkPossibleMoves'");
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'move'");
    }

}
