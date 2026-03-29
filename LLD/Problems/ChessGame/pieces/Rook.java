package LLD.Problems.ChessGame.pieces;

import LLD.Problems.ChessGame.enums.Color;
import LLD.Problems.ChessGame.models.Cell;

public class Rook extends Pieces {
  
  public Rook(Color color) {
    super(color);
  }

  @Override
  public boolean validMove(Cell from, Cell to) {
    return (from.getRow() == to.getRow() || from.getCol() == to.getCol());
  }
}
