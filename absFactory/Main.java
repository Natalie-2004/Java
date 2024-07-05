package absFactory;

// public class Main {
//     public static void main(String[] args) {
//         Pizza pizza = PizzaFactory.createPizza("cheese");
//         pizza.prepare();

//         pizza = PizzaFactory.createPizza("pepperoni");
//         pizza.prepare();

//         pizza = PizzaFactory.createPizza("veggie");
//         pizza.prepare();
//     }
// }

public class Main {
    public static void main(String[] args) {
        PizzaFactory factory = new CheesePizzaFactory();
        Pizza pizza = factory.createPizza();
        pizza.prepare();

        factory = new PepperoniPizzaFactory();
        pizza = factory.createPizza();
        pizza.prepare();

        factory = new VeggiePizzaFactory();
        pizza = factory.createPizza();
        pizza.prepare();
    }
}
