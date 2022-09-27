package be.abis.courseadmin.repository;

import be.abis.courseadmin.exceptions.CourseNotFoundException;
import be.abis.courseadmin.model.Course;

import java.util.List;

public interface CourseRepository {
    Course findCourse(String name) throws CourseNotFoundException;
    void addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Course course);
    List<Course> getCourses();
}
