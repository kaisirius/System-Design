import LLD.Problems.ChessGame.Controller.ChessGame;
import LLD.Problems.ChessGame.models.Player;

public class ChessGameService {
  private static volatile ChessGameService instance;
  private ChessGame game;

  private ChessGameService() {}

  public static ChessGameService getInstance() {
    if(instance == null) {
      synchronized(ChessGameService.class) {
        if(instance == null) {
          instance = new ChessGameService();
        }
      }
    }
    return instance;
  }

  public void initGame(Player blackPlayer, Player whitePlayer) {
    game = new ChessGame(blackPlayer, whitePlayer);
  }

  public void startGame() {
    if(game != null) {
      game.play();
    }
  }
}
