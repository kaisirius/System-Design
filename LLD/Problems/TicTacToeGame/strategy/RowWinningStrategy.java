package LLD.Problems.TicTacToeGame.strategy;

import LLD.Problems.TicTacToeGame.enums.Symbol;
import LLD.Problems.TicTacToeGame.models.Board;
import LLD.Problems.TicTacToeGame.models.Player;

public class RowWinningStrategy implements WinningStrategy {
  @Override
  public boolean checkWinner(Board board, Player player) { 
    Symbol playerSymbol = player.getSymbol();

    for(int row = 0; row < board.getRows(); row++) {
      boolean win = true;
      
      for(int col = 0; col < board.getColumns(); col++) {
        if(board.getCell(row, col) != playerSymbol) {
          win = false;
          break;
        }
      }

      if(win) return true;
    }
    return false;
  }
}
