package decorator.pizza;

public class Peppers extends Topping {
    private Pizza pizza;

    public Peppers(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription() + ", Peppers";
    }

    public double getCost() {
        return 2.5;
    }    
}
