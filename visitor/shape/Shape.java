package visitor.shape;

public interface Shape {
    // public void move(int x, int y);
    // public void draw();
    public void accept(Visitor v);
}
