package designpatterns.command;

public class TypeWriterApp {

    public static void main(String[] args) {
        TypeWriter typeWriter = new TypeWriter();
        typeWriter.type('H').type('ä').undo().type('e').type('l').type('l').type('o');
        typeWriter.type(" John!").undo();
        System.out.println(typeWriter.getContent());    // should print "Hello"
    }
}
