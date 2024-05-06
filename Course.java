package project_patrren;

import java.util.ArrayList;
import java.util.List;

// Course interface
interface Course {
    String getTitle();
    String getDescription();
}
interface CourseSubject {
    void registerObserver(UserObserver observer);
    void removeObserver(UserObserver observer);
    void notifyObservers();
}

interface Command {
    void execute();
}

class AddCourseCommand implements Command {
    private final Platform platform;
    private final Course course;

    public AddCourseCommand(Platform platform, Course course) {
        this.platform = platform;
        this.course = course;
    }

    @Override
    public void execute() {
        platform.addCourse(course);
    }
}

class RemoveCourseCommand implements Command {
    private final Platform platform;
    private final Course course;

    public RemoveCourseCommand(Platform platform, Course course) {
        this.platform = platform;
        this.course = course;
    }

    @Override
    public void execute() {
        platform.removeCourse(course);
    }
}

class CompositeCourse implements Course, CourseSubject {
    private final String title;
    private final String description;
    private final List<Course> subCourses;
    private final List<UserObserver> observers;

    public CompositeCourse(String title, String description) {
        this.title = title;
        this.description = description;
        this.subCourses = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addSubCourse(Course subCourse) {
        subCourses.add(subCourse);
    }

    public void removeSubCourse(Course subCourse) {
        subCourses.remove(subCourse);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void registerObserver(UserObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(UserObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (UserObserver observer : observers) {
            observer.updateCourse(this);
        }
    }
}

interface UserObserver {
    void updateCourse(CourseSubject subject);
}

// Concrete implementation of a Java programming course
class JavaProgrammingCourse implements Course {
    private final String title;
    private final String description;

    public JavaProgrammingCourse(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

// Concrete implementation of a web development course
class WebDevelopmentCourse implements Course {
    private final String title;
    private final String description;

    public WebDevelopmentCourse(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

// Decorator interface for courses
interface CourseDecorator extends Course {
    // Additional methods to enhance the course functionality
    void additionalMethod();
}

// Concrete decorator that adds additional functionality to a course
class AdditionalFunctionalityDecorator implements CourseDecorator {
    private final Course decoratedCourse;

    public AdditionalFunctionalityDecorator(Course decoratedCourse) {
        this.decoratedCourse = decoratedCourse;
    }

    @Override
    public String getTitle() {
        return decoratedCourse.getTitle();
    }

    @Override
    public String getDescription() {
        return decoratedCourse.getDescription();
    }

    @Override
    public void additionalMethod() {
        // Additional functionality implementation
    }
}

// User class represents a user (student or instructor) of the platform
class User  implements UserObserver {
    private final String username;
    private final String email;
    private final boolean isInstructor;

    public User(String username, String email, boolean isInstructor) {
        this.username = username;
        this.email = email;
        this.isInstructor = isInstructor;
    }
    @Override
    public void updateCourse(CourseSubject subject) {
        // Handle the course update notification
        // You can define the specific behavior here, such as sending an email or displaying a notification to the user.
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

    public Course getCourse() {
        return course;
    }

    public User getUser() {
        return user;
    }
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
        if (course instanceof CourseSubject) {
            List<UserObserver> allObservers = getAllObservers();
            for (UserObserver observer : allObservers) {
                ((CourseSubject) course).registerObserver(observer);
            }
        }
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        if (course instanceof CourseSubject) {
            List<UserObserver> allObservers = getAllObservers();
            for (UserObserver observer : allObservers) {
                ((CourseSubject) course).removeObserver(observer);
            }
        }
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public void removeEnrollment(Enrollment enrollment) {
        enrollments.remove(enrollment);
    }

    public List<Course> getAllCourses() {
        return courses;
    }
    public void executeCommand(Command command) {
        command.execute();
    }
    private List<UserObserver> getAllObservers() {
        List<UserObserver> observers = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            Course course = enrollment.getCourse();
            if (course instanceof UserObserver) {
                observers.add((UserObserver) course);
            }
        }
        return observers;
    }
}