package LLD.Problems.ChessGame.pieces;

import LLD.Problems.ChessGame.enums.Color;
import LLD.Problems.ChessGame.models.Cell;
import LLD.Problems.TicTacToeGame.models.Board;

public class King extends Pieces {
    public King(Color color) {
        super(color);
    }

    @Override
    public boolean validMove(Cell from, Cell to) {
        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getCol()- from.getCol());
        return (rowDiff <= 1 && colDiff <= 1);
    }
}
