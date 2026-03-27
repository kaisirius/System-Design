package LLD.Problems.TicTacToeGame.models;

import LLD.Problems.TicTacToeGame.enums.Symbol;

public class Player {
  private String name;
  private Symbol symbol;
  
  public Player(String name, Symbol symbol) {
    this.name = name;
    this.symbol = symbol;
  }

  // GETTERS
  public String getName() {
    return name;
  }

  public Symbol getSymbol() {
    return symbol;
  }
}
