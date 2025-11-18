import java.util.*;
import java.io.*;

public class Lab22 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        HashMap<String, Student> students = new HashMap<>();

        try {
            Scanner inFile = new Scanner(new File("studentInfo.txt"));
            while (inFile.hasNext()) {
                String line = inFile.nextLine();
                String[] tokens = line.split(": ");

                String name = tokens[0];
                double score = Double.parseDouble(tokens[1]);

                if (!students.containsKey(name)) {
                    students.put(name, new Student(name));
                }
                students.get(name).addScore(score);
            }
            inFile.close();

        }
        catch(IOException ioe) {
            System.out.println("Error reading input file");
        }

        System.out.print("Enter a name: ");
        String query = s.nextLine();

        if (students.containsKey(query)) {
            System.out.println(students.get(query));
        } else {
            System.out.println("No information found for student \"" + query + "\".");
        }

        Student best = null;
        double highestAvg = 0.0;

        for (Student st : students.values()) {
            double avg = st.getAverage();
            if (avg > highestAvg) {
                highestAvg = avg;
                best = st;
            }
        }

        System.out.println();
        System.out.println("Highest scoring student: " + best);
    }
}
