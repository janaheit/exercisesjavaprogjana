package be.abis.courseadmin.repository;

import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.exceptions.CourseNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MemoryListCourseRepository implements CourseRepository {

    private static final MemoryListCourseRepository repository = new MemoryListCourseRepository();
    private List<Course> courses = new ArrayList<>();

    private MemoryListCourseRepository() {
        this.courses.add(new Course("Java", 30, 400));
        this.courses.add(new Course("UML", 2, 40));
        this.courses.add(new Course("Testing", 5, 30));
        this.courses.add(new Course("Python Programming", 10, 500));
        this.courses.add(new Course("Scrum", 1, 400));
        this.courses.add(new Course("Javascript intro", 30, 400));
        this.courses.add(new Course("Java", 30, 400));
    }

    @Override
    public Course findCourse(String name) throws CourseNotFoundException {
        for (Course c: this.courses){
            if (c.getTitle().equals(name)){
                return c;
            }
        }
        throw new CourseNotFoundException("This course does not exist.");

    }

    @Override
    public void addCourse(Course course) {
        this.courses.add(course);
    }

    @Override
    public void updateCourse(Course company) {

    }

    @Override
    public void deleteCourse(Course course) {
        this.courses.removeIf(c -> (c.equals(course)));
    }

    @Override
    public List<Course> getCourses() {
        return this.courses;
    }

    public static MemoryListCourseRepository getInstance(){
        return repository;
    }
}
