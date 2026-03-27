package LLD.Problems.TicTacToeGame.strategy;

import LLD.Problems.TicTacToeGame.enums.Symbol;
import LLD.Problems.TicTacToeGame.models.Board;
import LLD.Problems.TicTacToeGame.models.Player;

public class DiagonalWinningStrategy implements WinningStrategy {
  @Override
  public boolean checkWinner(Board board, Player player) {
    Symbol playerSymbol = player.getSymbol();
    boolean win = true;
    int row = 0, col = 0;
    while(row < board.getRows() && col < board.getColumns()) {
      if(board.getCell(row, col) != playerSymbol) {
        win = false;
      }
      row++;
      col++;
    }
    if(win) return true;

    win = true;
    row = 0; col = board.getColumns() - 1;
    while(row < board.getRows() && col >= 0) {
      if(board.getCell(row, col) != playerSymbol) {
        win = false;
      }
      row++;
      col--;
    }
    return win;
  }
}
