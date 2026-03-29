package LLD.Problems.ChessGame.models;

import LLD.Problems.ChessGame.pieces.Pieces;

public class Cell {
  private final int row;
  private final int col;
  private Pieces piece;

  public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isOccupied() {
        return piece != null;
    }

    public Pieces getPiece() { return piece; }
    public void setPiece(Pieces piece) { this.piece = piece; }

    public int getRow() { return row; }
    public int getCol() { return col; }

}
