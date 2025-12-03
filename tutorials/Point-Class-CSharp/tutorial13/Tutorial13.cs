using System;
using System.Collections.Generic;
public class Tutorial13
{
    public static void Main()
    {
        //make array for 5 points


        //In java, ArrayList: ArrayList<Point> list = new ArrayList<Point>();

        /*
        Point[] points = new Point[5];

        points[0] = new Point(-2, 7);

        Console.Write("Enter x-coordinate: ");

        //in Java:
        //double x = Double.parseDouble(s.nextLine());


        double x2 = Convert.ToDouble(Console.ReadLine());

        Console.Write("Enter y-coordinate: ");
        double y2 = Convert.ToDouble(Console.ReadLine());

        points[1] = new Point(x2, y2);
        points[2] = points[0].Midpoint(points[1]);
        points[3] = new Point(-2.7, -9);
        points[4] = points[2].Midpoint(points[3]);

        //loop to print each point
        for (int i = 0; i < points.Length; i++)
        {
            Console.Write($"Point {i}: ");
            points[i].Print();
        }

        Console.WriteLine();

        //loop to print each quadrant
        foreach (Point p in points)
        {
            Console.WriteLine($"Quadrant: {p.Quadrant()}");
        }
        */


        //use C# List (same idea as ArrayList in Java)
        /*
        List<Point> points = new List<Point>();

        points.Add(new Point(-2, 7));

        Console.Write("Enter x-coordinate: ");

        //in Java:
        //double x = Double.parseDouble(s.nextLine());


        double x2 = Convert.ToDouble(Console.ReadLine());

        Console.Write("Enter y-coordinate: ");
        double y2 = Convert.ToDouble(Console.ReadLine());

        points.Add(new Point(x2, y2));
        points.Add(points[0].Midpoint(points[1]));
        points.Add(new Point(-2.7, -9));
        points.Add(points[2].Midpoint(points[3]));

        //loop to print each point
        for (int i = 0; i < points.Count; i++)
        {
            Console.Write($"Point {i}: ");

            //in Java: points.get(i)
            points[i].Print();
            Console.WriteLine(points[i]);
        }

        Console.WriteLine();

        //loop to print each quadrant
        //same syntax to foreach loop over a List compared to an array 
        foreach (Point p in points)
        {
            Console.WriteLine($"Quadrant: {p.Quadrant()}");
        }
        */

        Point test = new Point(){X = 10, Y = 11};
        Console.WriteLine(test);
    }
}