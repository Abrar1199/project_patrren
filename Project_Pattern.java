package project_patrren;

import java.util.List;

public class Project_Pattern {
    public static void main(String[] args) {
        // Create an instance of the online learning platform
        Platform platform = new Platform();

        // Create the Java programming course
        Course javaCourse = new JavaProgrammingCourse("Java Programming", "Learn Java from scratch");

        // Decorate the Java course with additional functionality
        CourseDecorator decoratedJavaCourse = new AdditionalFunctionalityDecorator(javaCourse);

        // Create the web development course
        Course webDevCourse = new WebDevelopmentCourse("Web Development", "Learn web development");

        // Create a composite course and add the Java and web development courses as sub-courses
        CompositeCourse compositeCourse = new CompositeCourse("Composite Course", "A composite course");
        compositeCourse.addSubCourse(decoratedJavaCourse);
        compositeCourse.addSubCourse(webDevCourse);

        // Add the composite course to the platform
        platform.addCourse(compositeCourse);
        Command addCourseCommand = new AddCourseCommand(platform, javaCourse);
        Command removeCourseCommand = new RemoveCourseCommand(platform, javaCourse);
        
        // Execute the addCourseCommand
        platform.executeCommand(addCourseCommand);
        
        // ... Perform other operations on the platform, such as enrolling users, etc.
        
        // Execute the removeCourseCommand
        platform.executeCommand(removeCourseCommand);
        
        // Undo the last executed command (if supported)
      
    
        // Create users
        User user1 = new User("John", "john@example.com", false);
        User user2 = new User("Jane", "jane@example.com", false);
        User instructor = new User("Instructor", "instructor@example.com", true);

        // Add users to the platform
        platform.addUser(user1);
        platform.addUser(user2);
        platform.addUser(instructor);

        // Enroll users in the composite course
        Enrollment enrollment1 = new Enrollment(compositeCourse, user1);
        Enrollment enrollment2 = new Enrollment(compositeCourse, user2);
        platform.addEnrollment(enrollment1);
        platform.addEnrollment(enrollment2);

        // Get all courses from the platform
        List<Course> allCourses = platform.getAllCourses();

        // Print the titles and descriptions of all courses
        for (Course course : allCourses) {
            System.out.println("Course Title: " + course.getTitle());
            System.out.println("Course Description: " + course.getDescription());
            if (course instanceof CourseDecorator) {
                ((CourseDecorator) course).additionalMethod();
            }
        }

        // Simulate a course update
        compositeCourse.removeSubCourse(webDevCourse);
        compositeCourse.addSubCourse(new JavaProgrammingCourse("Advanced Java Programming", "Learn advanced Java concepts"));

        // Notify users about the course update
        compositeCourse.notifyObservers();
    }
    
}