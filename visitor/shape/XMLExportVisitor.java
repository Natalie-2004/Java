package visitor.shape;

// Concrete visitors implement several versions of the same algorithm, which can interact with all the concrete classes.
//
// The Visitor pattern works best when used with complex object structures (such as composite trees). In such cases, it can store some intermediate state of the algorithm and execute visitor methods on different objects in the structure simultaneously. This can be very helpful.
class XMLExportVisitor implements Visitor {

    @Override
    public void visitDot(Dot d) {
        // Export the ID and center coordinates of the dot.
    }

    @Override
    public void visitCircle(Circle c) {
        // Export the ID, center coordinates, and radius of the circle.
    }

    @Override
    public void visitRectangle(Rectangle r) {
        // Export the ID, top-left coordinates, width, and length of the rectangle.
    }

    @Override
    public void visitCompoundShape(CompoundShape cs) {
        // Export the ID of the shape and the list of IDs of its children.
    }
}
