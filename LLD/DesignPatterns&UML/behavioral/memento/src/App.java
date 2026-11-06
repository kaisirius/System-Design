public class App {
    public static void main(String[] args) throws Exception {
        TextEditor editor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();

        // Initial state
        editor.addText("Hello");
        history.saveState(editor.save());
        System.out.println("Initial text: " + editor.getText());

        // First change
        editor.addText("Hello, World!");
        history.saveState(editor.save());
        System.out.println("After first change: " + editor.getText());

        // Second change
        editor.addText("Hello, World! Welcome!");
        history.saveState(editor.save());
        System.out.println("After second change: " + editor.getText());

        // Undo last change
        TextMemento previousState = history.undo(editor.save());
        if (previousState != null) {
            editor.restore(previousState);
            System.out.println("After undo: " + editor.getText());
        }

        // Redo the undone change
        TextMemento redoState = history.redo(editor.save());
        if (redoState != null) {
            editor.restore(redoState);
            System.out.println("After redo: " + editor.getText());
        }
    }
}
