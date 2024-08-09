package decorator.pizza;

public class ThinCrustPizza extends Pizza {

    public ThinCrustPizza() {
        setDescription("Thin Crust Pizza");
    }

    @Override
    public double getCost() {
        return 10;
    }
    
}
