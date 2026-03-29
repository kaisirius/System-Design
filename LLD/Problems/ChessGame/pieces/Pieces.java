package LLD.Problems.ChessGame.pieces;

import LLD.Problems.ChessGame.enums.Color;
import LLD.Problems.ChessGame.models.Cell;

public abstract class Pieces {
  protected Color color;

  public Pieces(Color color) {
    this.color = color;
  }

  public abstract boolean validMove(Cell from, Cell to);

  public Color getColor() {
    return color;
  }
}
