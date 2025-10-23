public class Course {
	private Student[] roster;
	private int size;
	
	public Course(int capacity) {
		roster = new Student[capacity];
		size = 0;
	}
	
	public void addStudent(String name, String major, double gpa) {
		//YOU DO THIS
		//Create a Student object representing the parameter information
		//Add the Student to your roster array
		
		//If the array is full, do nothing (don't add the student)
        if (size < roster.length) {
            Student s = new Student(name, major, gpa);
            roster[size] = s;
            size++;
        }
	}
	
	public void printStudentsWithMajor(String m) {
		//YOU DO THIS
		//Print the information (use toString()) for all students in the course whose
		//major matches the parameter
        for (int i = 0; i < size; i++) {
            if (roster[i].getMajor().equalsIgnoreCase(m)) {
                System.out.println(roster[i].toString());
            }
        }
	}
	
	public void printHonorRoll() {
		//YOU DO THIS
		//Print the information (use toString()) for all students in the course who are on the honor roll
		//(GPA at least 3.5)
        for (int i = 0; i < size; i++) {
            if (roster[i].getGpa() >= 3.5) {
                System.out.println(roster[i].toString());
            }
        }
	}
}