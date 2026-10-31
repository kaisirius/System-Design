public class App {
    public static void main(String[] args) throws Exception {
        boolean dark = true;
        UIFactory factory = dark ? new DarkThemeFactory() : new LightThemeFactory();
        factory.createButton().render();
        factory.createCheckbox().render();
    }
}
