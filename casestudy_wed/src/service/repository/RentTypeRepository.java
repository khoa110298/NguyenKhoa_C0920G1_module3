package service.repository;

import employee.model.Employee;
import service.model.RentType;
import service.model.Service;

import java.sql.SQLException;
import java.util.List;

public interface RentTypeRepository {
    List<RentType> getAll();

}
