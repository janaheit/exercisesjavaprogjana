package be.abis.courseadmin.model;

import be.abis.courseadmin.observer.SessionFullListener;

public interface Instructor extends SessionFullListener {
    void teachCourse(Course course);

}
