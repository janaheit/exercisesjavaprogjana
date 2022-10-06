package be.abis.courseadmin.event;

import be.abis.courseadmin.model.PublicSession;

public class SessionFullEvent {
    private PublicSession source;
    private String message;

    public SessionFullEvent(PublicSession source, String message) {
        this.source = source;
        this.message = message;
    }

    public PublicSession getSource() {
        return source;
    }

    public String getMessage() {
        return message;
    }
}
