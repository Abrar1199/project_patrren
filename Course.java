package project_patrren;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing a course
abstract class Course {
    private final String title;
    private final String description;
    private final List<Video> videos;
    private final List<Quiz> quizzes;
    private final List<Assignment> assignments;

    public Course(String title, String description) {
        this.title = title;
        this.description = description;
        this.videos = new ArrayList<>();
        this.quizzes = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    // Methods for managing videos, quizzes, and assignments within the course
    // ...
}

// Concrete implementation of a Java programming course
class JavaProgrammingCourse extends Course {
    public JavaProgrammingCourse(String title, String description) {
        super(title, description);
    }
}

// Concrete implementation of a web development course
class WebDevelopmentCourse extends Course {
    public WebDevelopmentCourse(String title, String description) {
        super(title, description);
    }
}

// Abstract factory interface for creating courses
interface CourseFactory {
    Course createCourse(String title, String description);
}

// Concrete factory class for creating Java programming courses
class JavaCourseFactory implements CourseFactory {
    public Course createCourse(String title, String description) {
        return new JavaProgrammingCourse(title, description);
    }
}

// Concrete factory class for creating web development courses
class WebCourseFactory implements CourseFactory {
    public Course createCourse(String title, String description) {
        return new WebDevelopmentCourse(title, description);
    }
}

// User class represents a user (student or instructor) of the platform
class User {
    private final String username;
    private final String email;
    private final boolean isInstructor;

    public User(String username, String email, boolean isInstructor) {
        this.username = username;
        this.email = email;
        this.isInstructor = isInstructor;
    }

    // Methods for managing user profile and authentication
    // ...
}

// Video class represents a video lesson within a course
class Video {
    private final String title;
    private final String url;
    private final int duration; // in minutes

    public Video(String title, String url, int duration) {
        this.title = title;
        this.url = url;
        this.duration = duration;
    }

    // Methods for managing video playback and information
    // ...
}

// Quiz class represents a quiz associated with a course
class Quiz {
    private final String title;
    private final List<Question> questions;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    // Methods for managing quiz questions and answers
    // ...
}

// Assignment class represents an assignment associated with a course
class Assignment {
    private final String title;
    private final String description;
    private final String submissionUrl;

    public Assignment(String title, String description, String submissionUrl) {
        this.title = title;
        this.description = description;
        this.submissionUrl = submissionUrl;
    }

    // Methods for managing assignment details and submissions
    // ...
}

// Enrollment class represents a user's enrollment in a course
class Enrollment {
    private final Course course;
    private final User user;

    public Enrollment(Course course, User user) {
        this.course = course;
        this.user = user;
    }

    // Methods for managing course enrollment and access
    // ...
}

// Platform class represents the online learning platform itself, managing courses, users, and enrollments
class Platform {
    private final List<Course> courses;
    private final List<User> users;
    private final List<Enrollment> enrollments;

    public Platform() {
        this.courses = new ArrayList<>();
        this.users = new ArrayList<>();
        this.enrollments = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    // Methods for managing courses, users, and enrollments on the platform
    // ...

}