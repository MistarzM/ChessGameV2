package pieces;

import main.Board;
import utils.LoadAndSave;

import java.awt.image.BufferedImage;

public class Pawn extends Piece{

    private boolean isFirstMove;

    public Pawn(Board board, boolean colorOfTeam, int col, int row){
        super(board, "Pawn", colorOfTeam, col, row, col * Board.TILE_SIZE, row*Board.TILE_SIZE);

        this.isFirstMove = true;

        this.sprite = (colorOfTeam ? LoadAndSave.GetImg(LoadAndSave.WHITE_PAWN) : LoadAndSave.GetImg(LoadAndSave.BLACK_PAWN)).getScaledInstance(Board.TILE_SIZE, Board.TILE_SIZE, BufferedImage.SCALE_SMOOTH);
    }

    public void setFirstMove(boolean firstMove){
        this.isFirstMove = firstMove;
    }

    public boolean isMovementLegal(int col, int row){
        if (this.colorOfTeam) { // piece is white
            if (this.col == col && row - this.row == -1 && board.getPiece(col, row) == null)
                return true;

            if(isFirstMove && this.col == col && row - this.row== -2 && board.getPiece(col, row) == null && board.getPiece(col, row + 1) == null)
                return true;

            if(col == this.col - 1 && row - this.row == -1 && board.getPiece(col, row) != null)     // capture left-top
                return true;

            if(col == this.col + 1 && row - this.row== -1 && board.getPiece(col, row) != null)      // capture right-top
                return true;

            if(board.getTileNumber(col, row) == board.enPassantTile && Math.abs(col - this.col) == 1 && row -this.row == -1 && board.getPiece(col, row + 1) != null){   //en passant
                return true;
            }
        }
        if(!this.colorOfTeam){    // piece is black
            if (this.col == col && row - this.row == 1 && board.getPiece(col, row) == null)
                return true;

            if(isFirstMove && this.col == col && row - this.row == 2 && board.getPiece(col, row) == null && board.getPiece(col, row - 1) == null)
                return true;

            if(col == this.col - 1 && row - this.row == 1 && board.getPiece(col, row) != null)      // capture left-down
                return true;

            if(col == this.col + 1 && row - this.row == 1 && board.getPiece(col, row) != null)      // capture right-down
                return true;

            if(board.getTileNumber(col, row) == board.enPassantTile && Math.abs(col - this.col) == 1 && row -this.row == 1 && board.getPiece(col, row -1 ) != null){    //en passant
                return true;
            }
        }



        return false;
    }

}
