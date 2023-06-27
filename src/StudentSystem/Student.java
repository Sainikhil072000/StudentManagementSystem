package StudentSystem;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String ID;
    private String email;
    private List<Enrollment> enrolledCourses;

    // Constructor
    public Student(String name, String ID, String email) {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.enrolledCourses = new ArrayList<>();
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public List<Enrollment> getEnrolledCourses() {
        return enrolledCourses;
    }
}

class Course {
    private String courseCode;
    private String title;
    private String instructor;
    private List<Enrollment> enrollments;

    public Course(String courseCode, String title, String instructor) {
        this.courseCode = courseCode;
        this.title = title;
        this.instructor = instructor;
        this.enrollments = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
}


class Enrollment {
    private Student student;
    private Course course;
    private String enrollmentDate;
    private String grade;

    // Constructor
    public Enrollment(Student student, Course course, String enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.grade = "";
    }

    // Getters and setters

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class StudentManager {
    private List<Student> students;

    // Constructor
    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // Methods

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student searchStudentByID(String ID) {
    	for (int i = 0; i < students.size(); i++) {
    	    Student student = students.get(i);
            if (student.getID().equals(ID)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> searchStudentByName(String name) {
        List<Student> matchingStudents = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getName().equalsIgnoreCase(name)) {
                matchingStudents.add(student);
            }
        }
        return matchingStudents;
    }

    public void enrollStudentInCourse(Student student, Course course, String enrollmentDate) {
        Enrollment enrollment = new Enrollment(student, course, enrollmentDate);
        student.getEnrolledCourses().add(enrollment);
        course.getEnrollments().add(enrollment);
        System.out.println("Student enrolled in course successfully.");
    }

    public void generateAllStudentsReport() {
        System.out.println("All Students:");
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getID());
            System.out.println("Email: " + student.getEmail());
            System.out.println("----------------------");
        }
    }
    public void generateStudentCoursesReport(Student student) {
        System.out.println("Courses Enrolled by Student - " + student.getName() + ":");
        for (Enrollment enrollment : student.getEnrolledCourses()) {
            Course course = enrollment.getCourse();
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Instructor: " + course.getInstructor());
            System.out.println("----------------------");
        }
    }

}

class CourseManager {
  private List<Course> courses;
  //Constructor
  public CourseManager() {
   this.courses = new ArrayList<>();
}

//Methods

  public void createCourse(Course course) {
    courses.add(course);
  }

  public Course searchCourseByCode(String courseCode) {
	for (int i = 0; i < courses.size(); i++) {
		 Course course = courses.get(i);
     if (course.getCourseCode().equals(courseCode)) {
         return course;
     }
   }
   return null;
  }

   public List<Course> searchCourseByTitle(String title) {
     List<Course> matchingCourses = new ArrayList<>();
     for (int i = 0; i < courses.size(); i++) {
	    Course course = courses.get(i);
        if (course.getTitle().equalsIgnoreCase(title)) {
           matchingCourses.add(course);
       }
     }
     return matchingCourses;
   }

   public void enrollStudentInCourse(Student student, Course course, String enrollmentDate) {
     Enrollment enrollment = new Enrollment(student, course, enrollmentDate);
     student.getEnrolledCourses().add(enrollment);
     course.getEnrollments().add(enrollment);
     System.out.println("Student enrolled in course successfully.");
   }

   public void generateAllCoursesReport() {
     System.out.println("All Courses:");
     for (int i = 0; i < courses.size(); i++) {
	   Course course = courses.get(i);
       System.out.println("Course Code: " + course.getCourseCode());
       System.out.println("Title: " + course.getTitle());
       System.out.println("Instructor: " + course.getInstructor());
       System.out.println("----------------------");
     }
   }

}


