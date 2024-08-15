package designpatterns.behavioral;

interface Expression{
    public boolean interpret(String context);
}

class TerminalExpression implements Expression{

    String data;
    TerminalExpression(String data){
        this.data=data;
    }
    @Override
    public boolean interpret(String context) {
        if(context.contains(data)){
            System.out.println(" Expression present");
            return true;
        }
        return false;
    }
}

class AddExpression implements Expression{

    Expression expr1;
    Expression expr2;

    AddExpression(Expression expr1,Expression expr2){
        this.expr1=expr1;
        this.expr2=expr2;
    }
    @Override
    public boolean interpret(String context) {
        if(expr1.interpret(context) && expr2.interpret(context)){
            System.out.println(" Combined Expression Present");
            return true;
        }
        return false;
    }
}
public class InterpreterPattern {
    public static void main(String[] args) {
        Expression male = new TerminalExpression("male");
        Expression bumbum = new TerminalExpression("bumbum");
        bumbum.interpret("bumbum");

        Expression isPresent = new AddExpression(male,bumbum);

        isPresent.interpret("bumbum is male");
    }
}
