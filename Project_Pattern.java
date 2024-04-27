package project_patrren;

import java.util.List;

public class Project_Pattern {
    public static void main(String[] args) {
        // Create an instance of the online learning platform
        Platform platform = new Platform();

        // Create the Java course factory
        CourseFactory javaCourseFactory = new JavaCourseFactory();

        // Create some courses using the factory
        Course course1 = javaCourseFactory.createCourse("Java Programming", "Learn Java from scratch");

        // Create the web development course factory
        CourseFactory webCourseFactory= new WebCourseFactory();

        // Create some courses using the factory
        Course course2 = webCourseFactory.createCourse("Web Development", "Build modern web applications");

        // Create some users
        User user1 = new User("Jomanah", "jomanah.doe@example.com", false);
        User user2 = new User("Jane", "jana.smith@example.com", true);

        // Enroll users in courses
        Enrollment enrollment1 = new Enrollment(course1, user1);
        Enrollment enrollment2 = new Enrollment(course2, user2);

        // Add courses, users, and enrollments to the platform
        platform.addCourse(course1);
        platform.addCourse(course2);
        platform.addUser(user1);
        platform.addUser(user2);
        platform.addEnrollment(enrollment1);
        platform.addEnrollment(enrollment2);

        // Get all courses from the platform
        List<Course> allCourses = platform.getAllCourses();

        // Display course titles
        for (Course course : allCourses) {
            System.out.println("Course Title: " + course.getTitle());
        }
    }
}