package be.abis.courseadmin.observer;

import be.abis.courseadmin.event.SessionFullEvent;

public interface SessionFullListener {

    void confirm(SessionFullEvent event);
}
