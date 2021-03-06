package service.repository;

import service.model.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceRepository {
    List<Service> getAll();
    void insertService(Service service) throws SQLException;
    boolean deleteEmployee(String id) throws SQLException;
}
