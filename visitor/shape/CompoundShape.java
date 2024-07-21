package visitor.shape;

public class CompoundShape implements Shape{
    @Override
    public void accept(Visitor v) {
        v.visitCompoundShape(this);
    }
}
