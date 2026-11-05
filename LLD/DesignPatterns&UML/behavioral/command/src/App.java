public class App {
    public static void main(String[] args) throws Exception {
        Remote remote = new Remote();
        remote.setCommand(new LightOnCommand());
        remote.pressLightButton();

        remote.setCommand(new LightOffCommand());
        remote.pressLightButton();
    }
}
