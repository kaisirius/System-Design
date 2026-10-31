public class DarkThemeFactory implements UIFactory {
  @Override 
  public IButton createButton() {
    return new DarkButton();
  }
  @Override 
  public ICheckbox createCheckbox() {
    return new DarkCheckbox();
  }
}
