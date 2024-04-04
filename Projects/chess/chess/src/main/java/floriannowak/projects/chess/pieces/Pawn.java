package floriannowak.projects.chess.pieces;

import java.util.Set;
import floriannowak.projects.chess.Coordinates;

public class Pawn extends Piece{

   

    public Pawn(PlayerColor player, Coordinates location) {
        super(player, location);
       
        if (player == PlayerColor.BLACK) super.setShortType('p');
        else super.setShortType('P');
        
    }

    @Override
    public Set<Coordinates> checkPossibleMoves() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isValidMove(int x, int y) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void move() {
        // TODO Auto-generated method stub
        
    }

}
