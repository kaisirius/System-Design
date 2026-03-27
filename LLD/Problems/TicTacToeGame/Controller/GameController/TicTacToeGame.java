package LLD.Problems.TicTacToeGame.Controller.GameController;

import java.util.List;
import java.util.Scanner;

import LLD.Problems.TicTacToeGame.Controller.BoardGames;
import LLD.Problems.TicTacToeGame.enums.GameStatus;
import LLD.Problems.TicTacToeGame.models.Board;
import LLD.Problems.TicTacToeGame.models.Player;
import LLD.Problems.TicTacToeGame.state.XTurn;
import LLD.Problems.TicTacToeGame.state.context.GameContext;
import LLD.Problems.TicTacToeGame.strategy.ColumnWinningStrategy;
import LLD.Problems.TicTacToeGame.strategy.DiagonalWinningStrategy;
import LLD.Problems.TicTacToeGame.strategy.RowWinningStrategy;
import LLD.Problems.TicTacToeGame.strategy.WinningStrategy;

public class TicTacToeGame implements BoardGames{
  private Player playerX;
  private Player playerO;
  private Player currentPlayer;
  private Board board;
  private GameStatus gameStatus;
  private GameContext gameContext;
  private List<WinningStrategy> winningStrategies; 


  public TicTacToeGame(Player playerX, Player playerO) {
    this.playerO = playerO;
    this.playerX = playerX;
    currentPlayer = playerX;
    board = new Board(3, 3);
    gameStatus = GameStatus.IN_PROGRESS;
    gameContext = new GameContext(new XTurn());
    winningStrategies = List.of(
      new RowWinningStrategy(), 
      new ColumnWinningStrategy(), 
      new DiagonalWinningStrategy()
    );
  }

  @Override
  public void play() {
    Scanner scanner = new Scanner(System.in);

    while(gameStatus == GameStatus.IN_PROGRESS) {
      printBoard();

      System.out.println("Player " + (currentPlayer == playerX ? "X" : "O") + " enter your move. rows(0-2) & column(0-2): ");
      
      int row = scanner.nextInt();
      int col = scanner.nextInt();

      if(!board.isLegalMove(row, col)) {
        System.out.println("Enter valid move.");
      } else {
        handleMove(row, col);
        gameContext.nextState(this);
      }
    }
    displayResult();
    scanner.close();
  }

  public void handleMove(int row, int col) {
    board.makeMove(currentPlayer, row, col);
  }

  public void switchPlayer() {
    currentPlayer = currentPlayer == playerX ? playerO : playerX;
  }

  public boolean checkWinner() {
    boolean win = false;
    for(int i = 0; i < winningStrategies.size(); i++) {
      win |= winningStrategies.get(i).checkWinner(board, currentPlayer);
    }
    return win;
  }

  public boolean checkDraw() {
    return board.isFull();
  }

  public void printBoard() {
    board.printGrid();
  }

  public void displayResult() {
    switch(gameStatus) {
      case GameStatus.WINNER_X: 
        System.out.println("Player X " + playerX.getName() + " Won!");
        break;
      case GameStatus.WINNER_O: 
        System.out.println("Player O " + playerO.getName() + " Won!");
        break;
      case GameStatus.DRAW: 
        System.out.println("Draw!");
        break;
      default: 
        System.out.println("Game not completed, Runtime error occured!");
        break;
    }
  }

  public void setGameStatus(GameStatus status) {
    this.gameStatus = status;
  }

}
