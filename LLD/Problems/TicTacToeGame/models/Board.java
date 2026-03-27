package LLD.Problems.TicTacToeGame.models;

import LLD.Problems.TicTacToeGame.enums.Symbol;

public class Board {
  private int rows;
  private int columns;
  private Symbol[][] grid;

  public Board(int rows, int columns) {
    this.rows = rows;
    this.columns = columns;
    grid = new Symbol[rows][columns];
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < columns; j++) {
        grid[i][j] = Symbol.EMPTY;
      }
    }
  }

  public boolean isFull() {
    for(int i = 0; i < rows; i++) {
      for(int j = 0; j < columns; j++) {
        if(grid[i][j] == Symbol.EMPTY) {
          return false;
        }
      }
    }

    return true;
  }

  public boolean isLegalMove(int row, int col) {
    if(row >= this.rows || row < 0 || col >= this.columns || col < 0) {
      return false;
    } 
    if(grid[row][col] != Symbol.EMPTY) {
      return false;
    }
    return true;
  }

  public void makeMove(Player player, int row, int col) {
    grid[row][col] = player.getSymbol();
  }

  public void printGrid() {
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        Symbol symbol = grid[i][j];
        switch (symbol) {
          case X:
            System.out.print(" X ");
            break;
          case O:
            System.out.print(" O ");
            break;
          case EMPTY:
          default:
            System.out.print(" . ");
        }

        if (j < columns - 1) {
          System.out.print("|");
        }
      }

      System.out.println();

      if (i < rows - 1) {
          System.out.println("---+---+---");
      }
    }
    System.out.println();
  }

  // GETTERS
  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }

  public Symbol getCell(int row, int col) {
    return grid[row][col];
  }
}
