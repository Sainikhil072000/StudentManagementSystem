package StudentSystem;

public class Main {
public static void main(String[] args) {
StudentManager studentManager = new StudentManager();
CourseManager courseManager = new CourseManager();

// Adding students
Student student1 = new Student("Sai Koushik", "S001", "koushy.sai@gmail.com");
Student student2 = new Student("Nikhil Kumar", "S002", "nikhil.kumar@yahoo.com");
studentManager.addStudent(student1);
studentManager.addStudent(student2);

// Creating courses
Course course1 = new Course("C001", "Mathematics", "Prof. Johnson");
Course course2 = new Course("C002", "Physics", "Prof. Thompson");
courseManager.createCourse(course1);
courseManager.createCourse(course2);

// Enrolling students in courses
studentManager.enrollStudentInCourse(student1, course1, "2023-06-16");
studentManager.enrollStudentInCourse(student1, course2, "2023-06-16");
studentManager.enrollStudentInCourse(student2, course1, "2023-06-16");

// Generating reports
studentManager.generateAllStudentsReport();
courseManager.generateAllCoursesReport();
studentManager.generateStudentCoursesReport(student1);
}
}