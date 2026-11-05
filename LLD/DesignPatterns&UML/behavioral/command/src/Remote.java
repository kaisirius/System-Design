public class Remote {
  private Command command;

  public Remote() {
    command = new LightOnCommand();
  }

  public void setCommand(Command command) {
    this.command = command;
  }

  public void pressLightButton() {
    command.execute();
  }
}
