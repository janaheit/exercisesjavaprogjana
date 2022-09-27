package be.abis.courseadmin.repository;

import be.abis.courseadmin.exceptions.CompanyNotFoundException;
import be.abis.courseadmin.exceptions.SessionNotFoundException;
import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.model.Session;

import java.util.List;

public interface SessionRepository {
    Session findSession(String name) throws SessionNotFoundException;
    void addSession(Session company);
    void updateSession(Session company);
    void deleteSession(Session session);
    List<Session> getCompanies();
}
