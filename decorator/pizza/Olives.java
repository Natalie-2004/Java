package decorator.pizza;

public class Olives extends Topping {
    private Pizza pizza;

    public Olives(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    public double getCost() {
        return 2;
    }
    
}
