public class Particle {
  public ParticleType type;
  public float velocity;
  public float x;
  public float y;

  public Particle(ParticleType type, float x, float y, float vel) {
    this.type = type;
    velocity = vel;
    this.x = x;
    this.y = y;
  }

  public void update() {
        y += velocity;
        type.render(x, y, velocity);
  }


}
