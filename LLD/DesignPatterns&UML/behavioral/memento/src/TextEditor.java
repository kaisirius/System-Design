public class TextEditor {
  private String text = "";

  public TextMemento save() {
    return new TextMemento(text);
  }
  
  public void restore(TextMemento memento) {
    text = memento.getSavedText();
  }

  public void addText(String edit) {
    text = edit;
  }

  public String getText() {
    return text;
  }
}
