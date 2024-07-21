package visitor.shape;

// The Visitor interface declares a set of visit methods corresponding to the element classes. The signatures of these methods allow the visitor to correctly identify the class of the element it is interacting with.
public interface  Visitor {
    public void visitDot(Dot d);
    public void visitCircle(Circle c);
    public void visitRectangle(Rectangle r);
    public void visitCompoundShape(CompoundShape cs);
}
