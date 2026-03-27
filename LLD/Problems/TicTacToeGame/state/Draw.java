package LLD.Problems.TicTacToeGame.state;

import LLD.Problems.TicTacToeGame.Controller.GameController.TicTacToeGame;
import LLD.Problems.TicTacToeGame.state.context.GameContext;

public class Draw implements GameState {
  @Override
  public void nextState(GameContext context, TicTacToeGame game) {
    // no next state, it's a draw, game is over
  }
}
