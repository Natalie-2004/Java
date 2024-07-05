package absFactory;

public class VeggiePizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza() {
        return new VeggiePizza();
    }
}
