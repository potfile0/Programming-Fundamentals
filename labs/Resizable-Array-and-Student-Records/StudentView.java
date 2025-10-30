import java.util.*;

public class StudentView {
    private Scanner s;

    public StudentView() {
        s = new Scanner(System.in);
    }

    public void printStudents(ResizeableArray students, String header) {
        System.out.println(header);
        for (int i = 0; i < students.size(); i++) {
            Student s = (Student) students.get(i);
            System.out.println(s.toString());
        }
    }

    public Student getStudent() {
        System.out.print("Enter your name: ");
        String name = s.nextLine();

        System.out.print("Enter your major: ");
        String major = s.nextLine();

        double gpa = 0.0;
        int try_count=0;

        while(try_count<2) {
            try{
            System.out.print("Enter your GPA: ");
            gpa = s.nextDouble();
            s.nextLine();
            break;
            }
            catch (InputMismatchException e) {
            System.out.println("Error: Input must be a Double");
            try_count++;
        }
        }
        if (try_count >= 2) return null;
        

        return new Student(name, major, gpa);
    } 

    public String getMajor() {
        System.out.print("Enter a major: ");
        return s.nextLine();
    }

    public boolean goAgain() {
        System.out.print("Do you want to enter information about another student? (Y/N): ");
        char response = s.nextLine().toLowerCase().charAt(0);
        System.out.print(response);
        if(response == 'y') return true;
        return false;
    }

    
}
