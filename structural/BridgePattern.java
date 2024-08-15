package designpatterns.structural;

interface Pizza{
    void makePizza();
    void makeToppings();
}

//make a Veg Pizza
class VegPizza implements Pizza{

    @Override
    public void makePizza() {
        System.out.println("Veg Pizza");
    }

    @Override
    public void makeToppings() {
        System.out.println("Veg Toppings");
    }
}

//make a Non Veg Pizza
class NonVegPizza implements Pizza{

    @Override
    public void makePizza() {
        System.out.println("Non Veg Pizza");
    }

    @Override
    public void makeToppings() {
        System.out.println("Non Veg Toppings");
    }
}

abstract class Restaurant{
    protected Pizza pizza;

    public Restaurant(Pizza pizza) {
        this.pizza = pizza;
    }

    public abstract void makePizza();
    public abstract void makeToppings();
    public abstract void deliver();
}

//make an american restaurant
class AmericanRestaurant extends Restaurant{

    public AmericanRestaurant(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void makePizza() {
        System.out.println("American Pizza");
        pizza.makePizza();
    }

    @Override
    public void makeToppings() {
        System.out.println("American Toppings");
        pizza.makeToppings();
    }

    @Override
    public void deliver() {
        System.out.println("American Pizza delivered");
    }
}

//make an Italian restaurant
class ItalianRestaurant extends Restaurant{

    public ItalianRestaurant(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void makePizza() {
        System.out.println("Italian Pizza");
        pizza.makePizza();
    }

    @Override
    public void makeToppings() {
        System.out.println("Italian Toppings");
        pizza.makeToppings();
    }

    @Override
    public void deliver() {
        System.out.println("Italian Pizza delivered");
    }
}
public class BridgePattern {

    public static void main(String[] args) {
        Restaurant italianRestaurant = new ItalianRestaurant(new VegPizza());
        Restaurant americanRestaurant = new AmericanRestaurant(new NonVegPizza());
        italianRestaurant.makePizza();
        italianRestaurant.makeToppings();
        italianRestaurant.deliver();
        americanRestaurant.makePizza();
        americanRestaurant.makeToppings();
        americanRestaurant.deliver();
    }

}
