package visitor.shape;

// Demonstration of the Visitor pattern in use.
public class UsageDemo {
    public void visit(Shape s) {
        System.out.println("Visiting shape");
    }

    public void visit(Dot d) {
        System.out.println("Visiting dot");
    }
}
