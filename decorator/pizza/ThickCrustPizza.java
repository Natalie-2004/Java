package decorator.pizza;

public class ThickCrustPizza extends Pizza {

    public ThickCrustPizza() {
        setDescription("Thick Crust Pizza");
    }

    @Override
    public double getCost() {
        return 10;
    }
}
