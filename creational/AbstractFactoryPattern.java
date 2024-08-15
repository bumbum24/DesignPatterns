package designpatterns.creational;

//Same example for Facade Design Pattern
interface Factory{
    void  button();
    void textBox();
}

class WinFactory implements Factory{

    @Override
    public void button() {
        System.out.println("Windows Button here");
    }

    @Override
    public void textBox() {
        System.out.println("Windows Text Box here");
    }
}

class MacFactory implements Factory{

    @Override
    public void button() {
        System.out.println("Mac Button here");
    }

    @Override
    public void textBox() {
        System.out.println("Mac Text Box here");
    }
}

//Also acts as Facade Helper class
class FactoryCreator{
    public static Factory getFactory(String osType){
        if(osType.equals("Windows"))
            return new WinFactory();
        else
            return new MacFactory();
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        Factory win = FactoryCreator.getFactory("Mac");
        win.button();
        win.textBox();
    }
}
