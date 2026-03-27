import LLD.Problems.TicTacToeGame.Controller.BoardGames;
import LLD.Problems.TicTacToeGame.Controller.GameController.TicTacToeGame;
import LLD.Problems.TicTacToeGame.models.Player;

public class TicTacToeSystem {
  private static volatile TicTacToeSystem instance;
  private BoardGames game;

  private TicTacToeSystem() {};

  public static TicTacToeSystem getInstance() {
    if(instance == null) {
      synchronized(TicTacToeSystem.class) {
        if(instance == null) {
          instance = new TicTacToeSystem();
        }
      }
    }
    return instance;
  }

  public void createGame(Player playerX, Player playerO) {
    game = new TicTacToeGame(playerX, playerO);
  }

  public void startGame() {
    if(game instanceof TicTacToeGame) {
      game.play();
    }
  }
}
