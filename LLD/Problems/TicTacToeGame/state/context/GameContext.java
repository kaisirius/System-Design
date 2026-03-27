package LLD.Problems.TicTacToeGame.state.context;

import LLD.Problems.TicTacToeGame.Controller.GameController.TicTacToeGame;
import LLD.Problems.TicTacToeGame.state.*;

public class GameContext {
  private GameState state;

  public GameContext(GameState state) {
    this.state = state;
  }

  public void setState(GameState newState) {
    state = newState;
  }

  public void nextState(TicTacToeGame game) {
    state.nextState(this, game);
  }
}
