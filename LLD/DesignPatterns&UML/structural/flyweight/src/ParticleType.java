public class ParticleType {
  public String color;
  public String sprite;

  public ParticleType(String color, String sprite) {
    this.color = color;
    this.sprite = sprite;
  }

  public void render(float x, float y, float velocity) {
        System.out.println("Rendering " + color + " particle at (" + x + "," + y +
                ") with sprite " + sprite);
    }
}
