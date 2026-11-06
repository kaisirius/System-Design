public abstract class Game {
  public final void play() {
    init();
    while(!isGameOver()) {
      System.out.println("Making move!!");
      makeMove();
      System.out.println("Move made!!");
    }
    showResult();
  }

  protected abstract void init();
  protected abstract boolean isGameOver();
  protected abstract void makeMove();
  protected abstract void showResult();
}
