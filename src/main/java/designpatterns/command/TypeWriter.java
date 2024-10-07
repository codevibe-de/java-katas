package designpatterns.command;

import java.util.Stack;

public class TypeWriter {

    private final StringBuffer stringBuffer = new StringBuffer();

    private final Stack<Runnable> undoCommands = new Stack<>();

    public String getContent() {
        return this.stringBuffer.toString();
    }


    public TypeWriter type(char letter) {
        this.stringBuffer.append(letter);
        this.undoCommands.push(new UndoCommand(1));
        return this;
    }

    public TypeWriter type(String word) {
        this.stringBuffer.append(word);
        this.undoCommands.push(new UndoCommand(word.length()));
        return this;
    }


    public TypeWriter undo() {
        if (!this.undoCommands.empty()) {
            this.undoCommands.pop().run();
        }
        return this;
    }

    class UndoCommand implements Runnable {
        private final int numChars;

        public UndoCommand(int numChars) {
            this.numChars = numChars;
        }

        @Override
        public void run() {
            stringBuffer.replace(stringBuffer.length() - this.numChars, stringBuffer.length(), "");
        }
    }
}


