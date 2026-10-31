public class RasterRenderer implements Renderer {
  @Override 
  public void renderCircle(int radius) {
    System.out.println("Rendering raster cirle with radius-" + radius);
  }

  @Override 
  public void renderRectangle(int length, int breadth) {
    System.out.println("Redering raster rectangle with length-" + length + " breadth-" + breadth);
  }
}
