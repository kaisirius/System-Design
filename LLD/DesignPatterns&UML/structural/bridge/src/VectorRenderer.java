public class VectorRenderer implements Renderer {
  @Override 
  public void renderCircle(int radius) {
    System.out.println("Rendering vector cirle with radius-" + radius);
  }

  @Override 
  public void renderRectangle(int length, int breadth) {
    System.out.println("Redering vector rectangle with length-" + length + " breadth-" + breadth);
  }
}
