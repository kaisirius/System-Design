package LLD.Problems.TicTacToeGame.state;

import LLD.Problems.TicTacToeGame.Controller.GameController.TicTacToeGame;
import LLD.Problems.TicTacToeGame.state.context.GameContext;

public interface GameState {
  public void nextState(GameContext context, TicTacToeGame game);
}
