package floriannowak.projects.chess;

public class Coordinates {

    public class Vector {

        int x;
        int y;

        public Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public void setX(int x) {
            this.x = x;
        }
        public int getY() {
            return y;
        }
        public void setY(int y) {
            this.y = y;
        }
        public void set(int x, int y){
            this.x = x;
            this.y = y;
        }


    }


    private static final int MIN_X = 0;
    private static final int MAX_X = 7;
    private static final int MIN_Y = 0;
    private static final int MAX_Y = 7;

    private int x;
    private int y;
    private boolean isCapture;

    

    /**
     * Class to store coordinates for possible moves
     * @param x 
     * @param y
     */

    public Coordinates(int x, int y) {
        setX(x);
        setY(y);
    }

    public Coordinates (Coordinates coordinates){
        setX(coordinates.getX());
        setY(coordinates.getY());
        setCapture(false);
    }

    public Coordinates (Coordinates coordinates, boolean capture){
        setX(coordinates.getX());
        setY(coordinates.getY());
        setCapture(capture);
    }


    public boolean isCapture() {
        return isCapture;
    }

    public void setCapture(boolean isCapture) {
        this.isCapture = isCapture;
    }

    public boolean isValidVector(Vector probe){
        int probeX = this.getX() + probe.getX();
        int probeY = this.getY() + probe.getY();
        return (probeX >= MIN_X || probeX <= MAX_X && probeY >= MIN_Y || probeY <= MIN_Y);
    }


    public void setX(int x) {
        if (x < MIN_X || x > MAX_X) throw new IllegalArgumentException("x coordinate out of bound");
        this.x = x;
    }

    public void setY(int y) {
        if (y < MIN_Y || y > MAX_Y) throw new IllegalArgumentException("y coordinate out of bound");
        this.y = y;
    }

    public int getX() {
        return x;
    }
   
    public int getY() {
        return y;
    }
    public void addVector(Vector vector) {
                   
        if (isValidVector(vector) == false) throw new IllegalArgumentException("coordinates out of bound");
        this.y = this.y + vector.getY();
        this.x = this.x + vector.getX();
    }
    

    

    
}
