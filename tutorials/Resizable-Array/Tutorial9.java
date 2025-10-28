import java.io.*;
import java.util.*;

public class Tutorial9{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        /*
        ResizeableArray people = new ResizeableArray();

        Person p = new Person("Bob", 20);
        people.add(p);
        people.add(new Person("Alice", 30));
        people.add(new Person("Adam", 35));
        people.add(new Person("Ralph", 10));
        people.add(new Person("Mary", 5));
        people.add(new Person("Zeke", 37));
        people.add(new Person("Fred", 16));
        people.add(new Person("Thomas", 15));
        people.add(new Person("Karen", 50));
        people.add(new Person("Heather", 70));
        people.add(new Person("Brayden", 20));
        people.add(new Person("Steve", 45));

        //print name of all people
        for (int i = 0; i < people.size(); i++) {
            Person lookup = (Person)people.get(i);
            System.out.println(lookup.getName());
        }
        */

        ResizeableArray shapes = new ResizeableArray();
        shapes.add(new Rectangle(4, 5));
        shapes.add(new Rectangle(3, 2));
        shapes.add(null);

        //print all my rectangles
        for (int i = 0; i < shapes.size(); i++) {
            Rectangle r = (Rectangle)shapes.get(i);
            System.out.println(r);
        }
        

        /*
        //try the code that might cause problems
        //catch the problem and handle it some way
        try {
        System.out.print("Enter an integer: ");
        int val = s.nextInt();
        System.out.printf("One bigger than %d is %d%n", val, val+1);
        }
        catch (InputMismatchException e) {
            System.out.println("Error: Input must be an integer");
        }
        //continue on
        */

        /*
        //conect to nums.txt, add up all numbers
        try{
            Scanner inFile = new Scanner(new File("nums.txt"));
            int sum = 0;
            while(inFile.hasNext()) {
                sum += inFile.nextInt();
            }
            System.out.printf("Sum is: %d%n", sum);
            inFile.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
        catch (InputMismatchException mis) {
            System.out.println("All lines must be integers");
        }
        */

    }
}