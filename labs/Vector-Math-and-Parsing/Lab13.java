import java.util.*;

public class Lab13{
    public static void main(String[] args) {
        if(args.length == 2) {
            double[] vector1 = Parser.stringToArray(args[0]);
            double[] vector2 = Parser.stringToArray(args[1]);

            double[] vector_sum = Vector3.addVectors(vector1, vector2);
            System.out.print("\nVector sum: ");
            Vector3.printVector(vector_sum);

            System.out.println();
            Vector3.normalize(vector1);
            System.out.print("\nNormalization of first vector: ");
            Vector3.printVector(vector1);

            System.out.println();
            Vector3.normalize(vector2);
            System.out.print("\nNormalization of second vector: ");
            Vector3.printVector(vector2);

        }
        else {
            System.out.println("Error: run as java Lab13 \"(x1,y1,z1)\" \"(x2,y2,z2)\"");
        }
    }
}