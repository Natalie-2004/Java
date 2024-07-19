package factory.shape;

// step 3: create a factory, generatre instance objec based on given info
public class ShapeFactory {
    // obtain the type of object
    public Shape getShape(String shapeType) {
        if (shapeType == null) return null;

        if (shapeType.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        }

        return null;
    }

    // step 4: use this factory
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("Rectangle");
        shape2.draw();
    }
}

