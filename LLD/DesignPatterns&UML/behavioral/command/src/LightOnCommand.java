public class LightOnCommand implements Command {
  private Light light;
  public LightOnCommand() {
    light = new Light();
  }
  @Override
  public void execute() {
    light.on();
  }
}
