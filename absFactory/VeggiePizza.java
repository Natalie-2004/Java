package absFactory;

public class VeggiePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("Preparing veggie pizza...");
    }
}
