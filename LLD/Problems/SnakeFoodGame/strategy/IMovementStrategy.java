package LLD.Problems.SnakeFoodGame.strategy;

import LLD.Problems.SnakeFoodGame.models.Cell;

public interface IMovementStrategy {
  public Cell nextPosition(Cell head, String direction);
}
