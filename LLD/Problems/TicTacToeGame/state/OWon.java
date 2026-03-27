package LLD.Problems.TicTacToeGame.state;

import LLD.Problems.TicTacToeGame.Controller.GameController.TicTacToeGame;
import LLD.Problems.TicTacToeGame.state.context.GameContext;

public class OWon implements GameState {
  @Override
  public void nextState(GameContext context, TicTacToeGame game) {
    // no next state, O already won, game is over
  }
}
