package LLD.Problems.SnakeFoodGame.models;

public class Cell {
  private int row, col;

  public Cell(int row, int col) {
    this.row = row;
    this.col = col;
  }
  
  // getters
  public int getRow() {
    return row;
  } 

  public int getCol() {
    return col;
  }
}
