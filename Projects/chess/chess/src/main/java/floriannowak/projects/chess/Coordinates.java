package floriannowak.projects.chess;

public class Coordinates {

    private int x;
    private int y;

    /**
     * Class to store coordinates for possible moves
     * @param x 
     * @param y
     */

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
   
    public int getY() {
        return y;
    }

    
}
