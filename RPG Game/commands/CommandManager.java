package commands;

import java.util.Stack;

public class CommandManager {

    private Stack<Command> redoStack = new Stack<>();
    private Stack<Command> undoStack = new Stack<>();


    public void executeCommand(Command c) {
        c.execute();
        undoStack.push(c);
        while (!redoStack.empty()) {
            redoStack.pop();
        }
    }

    public void undo() {
        if (!undoStack.empty()) {
            Command undoCommand = undoStack.pop();
            redoStack.push(undoCommand);
            undoCommand.undo();
        }
    }

    public void redo() {
        if (!redoStack.empty()) {
            redoStack.pop().execute();
        }
    }

    public boolean isUndoAvailable() {
        return !undoStack.empty();
    }

    public boolean isRedoAvailable() {
        return !redoStack.empty();
    }


}
