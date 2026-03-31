package LLD.Problems.SnakeFoodGame.strategy.ConcreteMovementStrategy;

import LLD.Problems.SnakeFoodGame.models.Cell;
import LLD.Problems.SnakeFoodGame.strategy.IMovementStrategy;

public class HumanMovementStrategy implements IMovementStrategy {
  @Override
  public Cell nextPosition(Cell head, String direction) {
    int currentHeadRow = head.getRow();
    int currentHeadCol = head.getCol();
    switch (direction) {
      case "UP":
        return new Cell(currentHeadRow - 1, currentHeadCol);
      case "DOWN":
        return new Cell(currentHeadRow + 1, currentHeadCol);
      case "LEFT": 
        return new Cell(currentHeadRow, currentHeadCol - 1);
      case "RIGHT":
        return new Cell(currentHeadRow, currentHeadCol + 1);
      default:
        return head;
    }
  }
}
