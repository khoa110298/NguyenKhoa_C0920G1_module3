package contract.repository;

import contract.model.Contract;
import employee.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface ContractRepository {
    List<Contract> getAll();
    void insert(Contract contract) throws SQLException;
}
