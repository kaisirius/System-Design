public class Rectangle extends Shape {
  protected int length;
  protected int breadth;
  public Rectangle(Renderer renderer, int length, int breadth) {
    super(renderer);
    this.length = length;
    this.breadth = breadth;
  }

  @Override 
  public void draw() {
    renderer.renderRectangle(length, breadth);
  }
}
