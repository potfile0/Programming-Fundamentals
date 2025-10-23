import java.util.*;

public class Lab15 {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
		//YOU DO THIS
		//Create a Course object that can hold 10 students
        Course course = new Course(10);
		
		//Loop to ask the user for information for 6 students
			//for each one, get the name, major, and gpa
			//add each student to the Course object
            for (int i = 0; i < 6; i++) {
            System.out.print("Enter name: ");
            String name = s.nextLine();

            System.out.print("Enter major: ");
            String major = s.nextLine();

            System.out.print("Enter GPA: ");
            double gpa = s.nextDouble();
            s.nextLine();

            course.addStudent(name, major, gpa);
            System.out.println();
        }

			
		//Ask the user to enter a major
		//Print all students with that major (use your Course object)
        System.out.print("Enter a major to search for: ");
        String searchMajor = s.nextLine();
        course.printStudentsWithMajor(searchMajor);

		
		//Print all students on the honor roll (use your Course object)
        System.out.println();
        System.out.println("Honor roll:");
        course.printHonorRoll();
	}
}