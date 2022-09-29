package be.abis.courseadmin.model;

public interface CourseParticipant extends Comparable<CourseParticipant> {
    void attendCourse(Course course);
}
