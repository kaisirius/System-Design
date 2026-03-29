package LLD.Problems.ChessGame.pieces;

import LLD.Problems.ChessGame.enums.Color;
import LLD.Problems.ChessGame.models.Cell;
import LLD.Problems.TicTacToeGame.models.Board;

public class Pawn extends Pieces {
  public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean validMove(Cell from, Cell to) {
        int rowDiff = to.getRow() - from.getRow();
        int colDiff = Math.abs(to.getCol() - from.getCol());

        if (color == Color.WHITE) {
            return (rowDiff == 1 && colDiff == 0) ||
                    (from.getRow() == 1 && rowDiff == 2 && colDiff == 0) ||
                    (rowDiff == 1 && colDiff == 1);
        } else {
            return (rowDiff == -1 && colDiff == 0) ||
                    (from.getRow() == 6 && rowDiff == -2 && colDiff == 0) ||
                    (rowDiff == -1 && colDiff == 1);
        }
    }
}
