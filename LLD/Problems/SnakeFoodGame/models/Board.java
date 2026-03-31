package LLD.Problems.SnakeFoodGame.models;

public class Board {
  private static volatile Board instance;
  private int width, height;

  private Board(int width, int height) {
    this.width = width;
    this.height = height;
  }

  public static Board getInstance(int width, int height) {
    if(instance == null) {
      synchronized(Board.class) {
        if(instance == null) {
          instance = new Board(width, height);
        }
      }
    }
    return instance;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }
}
