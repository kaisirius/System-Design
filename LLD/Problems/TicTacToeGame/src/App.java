import LLD.Problems.TicTacToeGame.enums.Symbol;
import LLD.Problems.TicTacToeGame.models.Player;

public class App {
    public static void main(String[] args) throws Exception {
        TicTacToeSystem system = TicTacToeSystem.getInstance();

        Player playerX = new Player("Alice", Symbol.X);
        Player playerO = new Player("Bob", Symbol.O);

        system.createGame(playerX, playerO);
        system.startGame();
    }
}
