package absFactory;

public interface Pizza {
    public void prepare();
}

// bad code design:
    // Every time a new pizza type is added, 
    // we need to modify the PizzaFactory class.

    // The factory method contains conditional logic to determine which concrete class to instantiate, 
    // making the code harder to maintain and extend
    
    // PizzaFactory is tightly coupled with each pizza type

// first, change Pizza to interface
// modify each pizza type
// then create abstract factory interface: PizzaFactory
// create correspondingly pizzafactory classes
// implement the main