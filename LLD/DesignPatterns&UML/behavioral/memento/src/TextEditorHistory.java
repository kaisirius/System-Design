import java.util.Stack;

public class TextEditorHistory {
  private Stack<TextMemento> history = new Stack<>();
    private Stack<TextMemento> undoStack = new Stack<>();
    private Stack<TextMemento> redoStack = new Stack<>();
    public void push(TextMemento TextMemento) {
        history.push(TextMemento);
    }

    public TextMemento pop() {
        if (!history.isEmpty()) return history.pop();
        return null;
    }

    // Save new state; clear redo stack when a new state is saved
    public void saveState(TextMemento TextMemento) {
        undoStack.push(TextMemento);
        redoStack.clear();
    }

    // Undo operation: push current state to redo stack and return last state from
    // undo stack
    public TextMemento undo(TextMemento currentState) {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentState);
            return undoStack.pop();
        }
        return null;
    }

    // Redo operation: push current state to undo stack and return last state from
    // redo stack
    public TextMemento redo(TextMemento currentState) {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentState);
            return redoStack.pop();
        }
        return null;
    }
}
