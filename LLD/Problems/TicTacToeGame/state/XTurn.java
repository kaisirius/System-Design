package LLD.Problems.TicTacToeGame.state;

import LLD.Problems.TicTacToeGame.Controller.GameController.TicTacToeGame;
import LLD.Problems.TicTacToeGame.enums.GameStatus;
import LLD.Problems.TicTacToeGame.state.context.GameContext;

public class XTurn implements GameState {
  @Override
  public void nextState(GameContext context, TicTacToeGame game) {
    if(game.checkWinner()) {
      game.setGameStatus(GameStatus.WINNER_X);
      context.setState(new XWon());
    } else if(game.checkDraw()) {
      game.setGameStatus(GameStatus.DRAW);
      context.setState(new Draw());
    } else {
      // still in progress
      game.switchPlayer();
      context.setState(new OTurn());
    }
  }
} 
