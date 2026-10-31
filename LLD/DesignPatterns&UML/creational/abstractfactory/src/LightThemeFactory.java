public class LightThemeFactory implements UIFactory {
  @Override 
  public IButton createButton() {
    return new LightButton();
  }
  @Override 
  public ICheckbox createCheckbox() {
    return new LightCheckbox();
  }
}
