package floriannowak.projects.chess.pieces;

import java.util.Set;

import floriannowak.projects.chess.Coordinates;

public interface PieceAction {

    boolean isValidMove(Coordinates coordinates);
    Set<Coordinates> checkPossibleMoves();
    void move();

}
