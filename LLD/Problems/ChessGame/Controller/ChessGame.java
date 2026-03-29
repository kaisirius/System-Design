package LLD.Problems.ChessGame.Controller;

import LLD.Problems.ChessGame.enums.Color;
import LLD.Problems.ChessGame.enums.GameStatus;
import LLD.Problems.ChessGame.models.Board;
import LLD.Problems.ChessGame.models.Cell;
import LLD.Problems.ChessGame.models.Player;

public class ChessGame {
  private Player blackPlayer;
  private Player whitePlayer;
  private Player currentPlayer;
  private GameStatus gameStatus;
  private Board board;

  public ChessGame(Player blackPlayer, Player whitePlayer) {
    this.blackPlayer = blackPlayer;
    this.whitePlayer = whitePlayer;
    currentPlayer = whitePlayer;
    gameStatus = GameStatus.IN_PROGRESS;
    board = new Board();
  }

  public void play() {
    // we can also shift all these check conditions inside handleMove for better code structure
    while(gameStatus == GameStatus.IN_PROGRESS) {
      
      // check stalemate for current player
      if(checkStalemate(currentPlayer)) {
        gameStatus = GameStatus.STALEMATE;
      } else {
        // take input, validate it for 8*8 grid and make move
        int fromRow = 1, fromCol = 1, toRow = 2, toCol = 1;
        
        if(board.isLegalMove(currentPlayer, board.getCell(fromRow, fromCol), board.getCell(toRow, toCol))) {

          handleMove(board.getCell(fromRow, fromCol), board.getCell(toRow, toCol));

          // check winner after current player 
          if(checkWinner(currentPlayer)) {
            gameStatus = (currentPlayer.getColor() == Color.BLACK) ? GameStatus.BLACK_WINS : GameStatus.WHITE_WINS;
          } else {
            switchPlayer();
          }

        } else {
          System.out.println("Enter a valid move");
        }
      }
    }
    displayResult();
  }

  private void handleMove(Cell from, Cell to) {
    board.makeMove(from, to);
  }

  private boolean checkStalemate(Player currentPlayer) {
    // TODO
    // checks for currentplayers no legal moves and no check state
    return false;
  }

  private boolean checkWinner(Player currentPlayer) {
    // TODO
    // checks for other color to be in a checked position with no legal moves
    return false;
  }

  private void switchPlayer() {
    currentPlayer = (currentPlayer == blackPlayer) ? whitePlayer : blackPlayer;
  }

  private void displayResult() {
    switch(gameStatus) {
      case BLACK_WINS: 
        System.out.println("Black player won!");
        break;
      case WHITE_WINS: 
        System.out.println("White player won!");
        break;
      case STALEMATE: 
        System.out.println("Game ended up in a stalemate state. Draw!");
        break;
      default:
        System.out.println("Runtime error!");
        break;
    }
  }
}
