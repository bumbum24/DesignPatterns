package designpatterns.behavioral;

import java.util.Stack;

class TextData{
    String text;
    public void setText(String text){
        this.text=text;
    }

    public Memento takeSnapshot(){
        return new Memento(text);
    }

    public void restoreText(Memento memento){
        this.text= memento.getPreviousText();
    }

    static class Memento{

        public final String text;
        Memento(String text){
            this.text=text;
        }

        String getPreviousText(){
            return text;
        }

    }
}

//Caretaker class(Editor)
class Editor{
    Stack<TextData.Memento> mementos;
    TextData textData;

    Editor(){
        mementos = new Stack<>();
        textData = new TextData();
    }

    public void write(String text){
        textData.setText(text);
        mementos.push(textData.takeSnapshot());
        System.out.println(" Text Entered : " + textData.text);
    }

    public void undo(){
        textData.restoreText(mementos.pop());
        System.out.println("Previous Text : " +textData.text);
    }

}
public class MementoPattern {
    public static void main(String[] args) {
        Editor editor= new Editor();
        editor.write("Bum");
        editor.write("Bum bum");
        editor.write("Bum bum bole");
        System.out.println(editor.textData.text);
        editor.undo();
        System.out.println(editor.textData.text);
        editor.undo();
        editor.write("bole");
        System.out.println(editor.textData.text);
    }
}
