package designpatterns.structural;

interface Coffee{
    void make();
}

class SimpleCoffee implements Coffee{
    @Override
    public void make() {
        System.out.println("Simple Coffee is ready");
    }
}

abstract class CoffeeDecorator implements Coffee{
    protected Coffee decoratedCoffee;
    CoffeeDecorator(Coffee coffee){
        this.decoratedCoffee=coffee;
    }

    public void make(){
        decoratedCoffee.make();
    }
}

class MilkCoffee extends CoffeeDecorator{

    MilkCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void make() {
        super.make();
        System.out.print( " with Milk");
    }
}

class ColdCoffee extends CoffeeDecorator{

    ColdCoffee(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void make() {
        super.make();
        System.out.print(" with ice");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        simpleCoffee.make();
        Coffee milkCoffee = new MilkCoffee(simpleCoffee);
        milkCoffee.make();
        Coffee coldMilkCoffee= new ColdCoffee(milkCoffee);
        coldMilkCoffee.make();
    }
}
