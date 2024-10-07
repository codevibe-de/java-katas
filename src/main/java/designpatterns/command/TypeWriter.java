package designpatterns.command;

public class TypeWriter {

    private final StringBuffer stringBuffer = new StringBuffer();

    public String getContent() {
        return this.stringBuffer.toString();
    }

    public TypeWriter type(char letter) {
        this.stringBuffer.append(letter);
        return this;
    }

    public TypeWriter type(String word) {
        this.stringBuffer.append(word);
        return this;
    }

    public TypeWriter undo() {
        return this;
    }

}


