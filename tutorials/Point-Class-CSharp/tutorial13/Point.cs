public class Point {

    //somewhere, have a Point object:
    //Point p = new Point(3,4);
    //p.X = 10; (use set accessor). The "10" is stored in the special "value" keyword

    //a hidden _x field is automatically created that corresponds to this property
    public double X
    {
        get;
        set;
    }

    public double Y
    {
        get;
        set;
    }

    //bool instead of boolean
    //string instead of String
    //Constructor
    public Point(double x, double y) {
        X = x;
        Y = y;
    }

    public Point()
    {
        X = 0;
        Y = 0;
    }

    //how to access fields in Java (can do in C#, but prefer to use properties)
    /*

    public int getX()
    {
        return _x;
    }

    public int getY()
    {
        return _y;
    }

    public void setX(double newX)
    {
        _x = newX;
    }

    public void setY(double newY)
    {
        _y = newY;
    }
    */

    //Print
    public void Print() {
        Console.WriteLine($"({X:0.00}, {Y:0.00})");
    }

    public override string ToString()
    {
        return $"({X:0.00}, {Y:0.00})";
    }

    //Midpoint
    public Point Midpoint(Point other) {
        double midX = (X + other.X) / 2.0;
        double midY = (Y + other.Y) / 2.0;
        return new Point(midX, midY);
    }

    //Quadrant
    public int Quadrant() {
        if (X >= 0 && Y >= 0) {
            return 1; 
        } else if (X < 0 && Y >= 0) {
            return 2; 
        } else if (X < 0 && Y < 0) {
            return 3; 
        } else {
            return 4; 
        }
    }
}