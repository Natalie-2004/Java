package visitor.shape;

// Client code can run visitor operations on a set of elements without knowing their concrete classes. 
// The 'accept' operation directs the call to the corresponding operation in the visitor object.
public class Application {
    private Shape[] allShapes;

    public Application(Shape[] shapes) {
        this.allShapes = shapes;
    }

    public void export() {
        XMLExportVisitor exportVisitor = new XMLExportVisitor();

        for (Shape shape : allShapes) {
            shape.accept(exportVisitor);
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = { new Dot(), new Circle(), new Rectangle(), new CompoundShape() };
        Application app = new Application(shapes);
        app.export();
    }
}
