import java.util.*;

public class Tutorial8 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //create people, call methods
        Person p1 = new Person("Bob", 20);
        p1.print();

        Person p2 = new Person("Alice", 30);
        p2.print();

        p2 = p1;
        p2.birthday();
        p1.print();

        //create array of Rectangles
        //print area and perimeter of each

        Rectangle r = new Rectangle(3, 4);
        System.out.printf("Area: %d%n", r.area());

        Rectangle[] shapes = new Rectangle[10];

        for (int i = 0; i < 4; i++) {
            //rectangle: (i+1) and (i+2)
                //1x2
                //2x3
                //3x4
                //4x5

            shapes[i]  = new Rectangle(i+1, i+2) ;
        }

        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] != null ) {
                System.out.printf("Area: %d, perimeter: %d%n", shapes[i].area(), shapes[i].perimeter());
            }
            

        }
    }
}
