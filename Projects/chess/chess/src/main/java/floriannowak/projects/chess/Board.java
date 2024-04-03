package floriannowak.projects.chess;

public class Board {

    

    class Square{
        private char contains = '.';

        public char getContains() {
            return contains;
        }

        public void setContains(char contains) {
            this.contains = contains;          
        }


    }

    private Square[][] boardmap = new Square [8][8];

    public char getSquare(int x, int y) {
        return boardmap [x][y].getContains();
    }


    boolean whiteCastled = false;
    boolean blackCastled = false;
    boolean whiteToMove = true;


    public Board() {   //(int iteration, int depth), future AI

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                boardmap[x][y] = new Square();
            }
        }

        char[] pieces = {'r', 'n', 'b', 'k', 'q', 'b', 'n', 'r'};
        
        for (int i = 0; i < pieces.length; i++){
            boardmap [7][i].setContains(pieces[i]);
            boardmap [0][i].setContains(Character.toUpperCase(pieces[i]));
        }

        for (int i = 0; i < 8; i++){
            boardmap [6][i].setContains('p');
            boardmap [1][i].setContains('P');
        }

    }

    public void printBoard () {

        for (int x = 7; x >= 0; x--)
        {
            for (int y = 0; y < 8; y++){
                System.out.print(this.boardmap[x][y].getContains() + " ");
            }
            System.out.print("\n");
        }
    }    
    


}
