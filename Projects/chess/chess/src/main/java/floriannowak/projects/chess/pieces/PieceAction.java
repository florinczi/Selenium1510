package floriannowak.projects.chess.pieces;

import java.util.Set;

import floriannowak.projects.chess.Coordinates;

public interface PieceAction {

    boolean isValidMove(int x, int y);
    Set<Coordinates> checkPossibleMoves();
    void move();

}
