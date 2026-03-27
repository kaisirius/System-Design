package LLD.Problems.TicTacToeGame.strategy;

import LLD.Problems.TicTacToeGame.models.Board;
import LLD.Problems.TicTacToeGame.models.Player;


public interface WinningStrategy {
  public boolean checkWinner(Board board, Player player);
}
