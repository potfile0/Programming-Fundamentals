public class Vector3 {
   public static final int SIZE = 3;

   public static double magnitude(double[] vector) {
      double sum = 0;
      for (int i = 0; i < SIZE; i++) {
         sum += vector[i]*vector[i];
      }
      return Math.sqrt(sum);
   }

   //addVectors
   public static double[] addVectors(double[] v1, double[] v2) {
   double added_vectors[] = new double [SIZE];

   for(int i = 0; i < SIZE; i++) {
        added_vectors[i] = v1[i] + v2[i];
   }
   return added_vectors;

   }

   //printVector
   public static void printVector(double[] vector) {
    System.out.printf("(%.2f, %.2f, %.2f)", vector[0], vector[1], vector[2]);
   }

   //normalize
   public static void normalize(double[] vector) {
        double mag = magnitude(vector);
        if (mag != 0) {
            for (int i = 0; i < SIZE; i++) {
                vector[i] /= mag;
            }
        }
   }
}