public class Point {
    //fields
    private double _x;
    private double _y;

    //Constructor
    public Point(double x, double y) {
        _x = x;
        _y = y;
    }

    //Print
    public void print() {
        System.out.printf("(%.2f, %.2f)%n", _x, _y);
    }

    //Midpoint
    public Point midpoint(Point other) {
        double midX = (_x + other._x) / 2.0;
        double midY = (_y + other._y) / 2.0;
        return new Point(midX, midY);
    }

    //Quadrant
    public int quadrant() {
        if (_x >= 0 && _y >= 0) {
            return 1; 
        } else if (_x < 0 && _y >= 0) {
            return 2; 
        } else if (_x < 0 && _y < 0) {
            return 3; 
        } else {
            return 4; 
        }
    }
}
