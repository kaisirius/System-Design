package LLD.Problems.TicTacToeGame.state;

import LLD.Problems.TicTacToeGame.Controller.GameController.TicTacToeGame;
import LLD.Problems.TicTacToeGame.state.context.GameContext;

public class XWon implements GameState {
  @Override
  public void nextState(GameContext context, TicTacToeGame game) {
    // no next state, X already won, game is over
  }
}
