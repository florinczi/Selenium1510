package florinczi.projects.chessgame;

import florinczi.projects.chessgame.pieces.PlayerColor;

import java.util.ArrayList;
import java.util.List;

public class Minmax {

    public static float minmax(Board board, int depth) {
        Engine engine = board.getEngine();

        if (depth == 0 || board.getMoveList().isEmpty()) {
            return Evaluator.evaluate(board);
        }

        List<Board> children = new ArrayList<>();
        board.getMoveList().forEach(move -> children.add(engine.prepareMove(board, move))); //now we have populated children

        float eval;

        if (board.getNowPlaying() == PlayerColor.WHITE) {
            eval = Float.NEGATIVE_INFINITY;
            for (Board child : children) {
                eval = Math.max(eval, minmax(child, depth - 1));
            }
        }
        else {
            eval = Float.POSITIVE_INFINITY;
            for (Board child : children) {
                eval = Math.min(eval, minmax(child, depth - 1));
            }
        }
        return eval;
    }

    public static Board minmaxRoot(Board board, int depth){
        List<Board> children = new ArrayList<>();
        Board winner = null;
        float eval ;
        board.getMoveList().forEach(move -> children.add(board.getEngine().prepareMove(board, move)));

        if (board.getNowPlaying() == PlayerColor.WHITE) {
            eval = Float.NEGATIVE_INFINITY;
            for (Board child : children) {
                float childEval = minmax(child, depth);
                if (childEval > eval){
                    eval = childEval;
                    winner = child;
                }
            }
        }
        else {
            eval = Float.POSITIVE_INFINITY;
            for (Board child : children) {
                float childEval = minmax(child, depth);
                if (childEval < eval){
                    eval = childEval;
                    winner = child;
                }
            }
        }

        return winner;
    }



}


