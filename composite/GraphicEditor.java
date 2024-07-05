// package composite;

// import java.util.List;

// import javax.sound.sampled.Line;

// public class GraphicEditor {
//     public void drawShapes(List<Object> shapes) {
//         for (Object shape : shapes) {
//             if (shape instanceof Line) {
//                 ((Line) shape).draw();
//             } else if (shape instanceof Rectangle) {
//                 ((Rectangle) shape).draw();
//             }
//         }
//     }
// }

// Suppose you have a Graphic interface and two concrete classes, 
// Line and Rectangle, to represent different graphical elements. 
// Without the Composite Pattern, you have separate handling logic for each type of graphical element

// such code structure have a bad code smell:
    // violates the open close principle by adding new shape requires modifying the GraphicEditor
    // use instanceOf to check differentiate between shapes, making the code less maintainable 

// at first, we identify the 'Component' interface -> Graphic
// then the 'Leaf' object -> Line && Rectangle
// modify the 'Composite' object -> CompositeGraphic

// by doing so, 
// the Graphic interface that declares the common operations for both individual objects and compositions of objects
// The Line and Rectangle classes that represent individual graphical elements and implement the Graphic interface.
// The CompositeGraphic class that represents composite objects and contains child components. 
// It implements the Graphic interface and delegates the draw operation to its child components.