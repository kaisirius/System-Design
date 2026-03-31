package LLD.Problems.SnakeFoodGame.models.food;

public abstract class FoodItem {
  protected int row, col;
  protected int points;

  public FoodItem(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public int getRow() {
    return this.row;
  }

  public int getCol() { 
    return this.col;
  }

  public int getPoints() {
    return this.points;
  }
}
