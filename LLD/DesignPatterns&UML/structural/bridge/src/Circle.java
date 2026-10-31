public class Circle extends Shape {
  protected int radius;
  public Circle(Renderer renderer, int radius) {
    super(renderer);
    this.radius = radius;
  }

  @Override 
  public void draw() {
    renderer.renderCircle(radius);
  }
}
