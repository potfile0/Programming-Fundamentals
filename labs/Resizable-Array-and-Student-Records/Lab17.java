import java.util.*;

public class Lab17 {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Course course = new Course();
        StudentView view = new StudentView();

		
        boolean moreStudents = true;
        while (moreStudents) {
            Student student = view.getStudent();
            course.addStudent(student);
            moreStudents = view.goAgain();
        }

        String major = view.getMajor();
        ResizeableArray studentsWithMajor = course.getStudentsWithMajor(major);
        view.printStudents(studentsWithMajor, "Students with major: " + major);

        ResizeableArray honorRoll = course.getHonorRoll();
        view.printStudents(honorRoll, "Honor Roll Students:");
	}
}