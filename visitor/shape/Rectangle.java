package visitor.shape;

public class Rectangle implements Shape {
    @Override
    public void accept(Visitor v) {
        v.visitRectangle(this);
    }
}
