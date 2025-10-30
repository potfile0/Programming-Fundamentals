public class Course {
	private ResizeableArray roster;
	
	public Course() {
		roster = new ResizeableArray();
	}
	
	public void addStudent(Student s) {
        roster.add(s);
    }
    
    public ResizeableArray getStudentsWithMajor(String major) {
        ResizeableArray result = new ResizeableArray();
        
        for (int i = 0; i < roster.size(); i++) {
            Student student = (Student) roster.get(i); 
            if (student.getMajor().equalsIgnoreCase(major)) {
                result.add(student); 
            }
        }
        
        return result; 
    }
    
    public ResizeableArray getHonorRoll() {
        ResizeableArray result = new ResizeableArray();
        
        for (int i = 0; i < roster.size(); i++) {
            Student student = (Student) roster.get(i);
            if (student.getGpa() >= 3.5) {
                result.add(student);
            }
        }
        
        return result;
    }
}
