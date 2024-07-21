package visitor.shape;

public class Circle implements Shape {
    @Override
    public void accept(Visitor v) {
        v.visitCircle(this);
    }
}
