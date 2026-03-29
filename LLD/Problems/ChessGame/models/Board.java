package LLD.Problems.ChessGame.models;

import LLD.Problems.ChessGame.enums.Color;
import LLD.Problems.ChessGame.pieces.Bishop;
import LLD.Problems.ChessGame.pieces.King;
import LLD.Problems.ChessGame.pieces.Knight;
import LLD.Problems.ChessGame.pieces.Pawn;
import LLD.Problems.ChessGame.pieces.Queen;
import LLD.Problems.ChessGame.pieces.Rook;

public class Board {
  private Cell[][] grid;

  public Board() {
    grid = new Cell[8][8];
    for (int row = 0; row < 8; row++)
      for (int col = 0; col < 8; col++)
          grid[row][col] = new Cell(row, col);

    setupPieces();
  }

  private void setupPieces() {
    for (int j = 0; j < 8; j++) {
            grid[1][j].setPiece(new Pawn(Color.WHITE));
            grid[6][j].setPiece(new Pawn(Color.BLACK));
        }

        // Initialize white pieces
        grid[0][0].setPiece(new Rook(Color.WHITE));
        grid[0][1].setPiece(new Knight(Color.WHITE));
        grid[0][2].setPiece(new Bishop(Color.WHITE));
        grid[0][3].setPiece(new Queen(Color.WHITE));
        grid[0][4].setPiece(new King(Color.WHITE));
        grid[0][5].setPiece(new Bishop(Color.WHITE));
        grid[0][6].setPiece(new Knight(Color.WHITE));
        grid[0][7].setPiece(new Rook(Color.WHITE));

        // Initialize black pieces
        grid[7][0].setPiece(new Rook(Color.BLACK));
        grid[7][1].setPiece(new Knight(Color.BLACK));
        grid[7][2].setPiece(new Bishop(Color.BLACK));
        grid[7][3].setPiece(new Queen(Color.BLACK));
        grid[7][4].setPiece(new King(Color.BLACK));
        grid[7][5].setPiece(new Bishop(Color.BLACK));
        grid[7][6].setPiece(new Knight(Color.BLACK));
        grid[7][7].setPiece(new Rook(Color.BLACK));
  }

  public Cell getCell(int row, int col) {
    return grid[row][col];
  }

  public boolean isLegalMove(Player player, Cell from, Cell to) {
    return (from.getPiece() != null && player.getColor() == from.getPiece().getColor());
  }

  public void makeMove(Cell from, Cell to) {
    to.setPiece(from.getPiece());
    from.setPiece(null);
  }

  public void printBoard() {
    // TODO
  }


}
