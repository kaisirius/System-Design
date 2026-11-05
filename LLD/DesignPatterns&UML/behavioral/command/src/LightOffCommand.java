public class LightOffCommand implements Command {
  private Light light;

  public LightOffCommand() {
    light = new Light();
  }

  @Override 
  public void execute() {
    light.off();
  }
}
