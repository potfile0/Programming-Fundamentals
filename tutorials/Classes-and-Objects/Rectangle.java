//represent a rectangle
public class Rectangle {
    //fields
    private int length;
    private int width;

    //constructor
    public Rectangle(int l, int w) {
        length = l;
        width = w;

    }
    //method (operations) 
    public int area() {
        return length*width;
    }

    public int perimeter() {
        return 2*length+2*width;
    }
}
