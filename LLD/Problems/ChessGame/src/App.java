import LLD.Problems.ChessGame.enums.Color;
import LLD.Problems.ChessGame.models.Player;

public class App {
    public static void main(String[] args) throws Exception {
        Player blackPlayer = new Player("Bob", Color.BLACK);
        Player whitePlayer = new Player("Alice", Color.WHITE);

        ChessGameService gameService = ChessGameService.getInstance();
        gameService.initGame(blackPlayer, whitePlayer);
        gameService.startGame();
    }
}
