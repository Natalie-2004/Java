package visitor.shape;

public class Dot implements Shape {
    @Override
    public void accept(Visitor v) {
        v.visitDot(this);
    }
}
