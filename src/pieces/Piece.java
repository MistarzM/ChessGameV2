package pieces;

import main.Board;

import java.awt.*;

public class Piece {

    public int col;
    public int row;

    public int xPosition;
    public int yPosition;

    public boolean colorOfTeam;         // true -> white : false -> black
    public String pieceName;
    public int value;

    Image sprite;

    Board board;

    public Piece(Board board, String pieceName, boolean colorOfTeam, int col, int row, int xPosition, int yPosition) {
        this.board = board;
        this.pieceName =  pieceName;
        this.colorOfTeam = colorOfTeam;
        this.col = col;
        this.row = row;
        this.xPosition = xPosition;
        this.yPosition = yPosition;

    }

    public void paint(Graphics2D g) {

        g.drawImage(sprite, xPosition, yPosition, null);
    }

    //movement
    public boolean isMovementLegal(int col, int row){
        return true;
    }
    public boolean moveOverlapPiece(int col, int row){
        return false;
    }
}
