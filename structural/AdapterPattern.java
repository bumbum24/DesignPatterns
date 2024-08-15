package designpatterns.structural;

interface Printer{
    public void print();
}

class PrinterImpl implements Printer{

    @Override
    public void print() {
        System.out.println("Print from Old");
    }
}

class NewPrinter{
    public void print() {
        System.out.println("Print from New");
    }
}
class PrinterAdapter implements Printer{

    NewPrinter newPrinter ;
    PrinterAdapter(){
        newPrinter = new NewPrinter();
    }

    @Override
    public void print() {
        newPrinter.print();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        Printer printer= new PrinterAdapter();
        //Printer printer = new PrinterImpl();
        printer.print();
    }
}
