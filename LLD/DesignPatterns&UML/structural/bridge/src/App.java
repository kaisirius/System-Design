public class App {
    public static void main(String[] args) throws Exception {
        Renderer rasterRenderer = new RasterRenderer();
        Renderer vectorRenderer = new VectorRenderer();
        Shape rasterCircle = new Circle(rasterRenderer, 5);
        Shape vectorCircle = new Circle(vectorRenderer, 5);
        Shape rasterRectangle = new Rectangle(rasterRenderer, 10, 5);
        Shape vectorRectangle = new Rectangle(vectorRenderer, 10, 5);
        rasterCircle.draw();
        vectorCircle.draw();
        rasterRectangle.draw();
        vectorRectangle.draw();
    }
}
