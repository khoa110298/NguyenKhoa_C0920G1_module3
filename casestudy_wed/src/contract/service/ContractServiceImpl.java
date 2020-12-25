package contract.service;

import contract.model.Contract;
import contract.repository.ContractRepository;
import contract.repository.ContractRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ContractServiceImpl implements ContractService {
    ContractRepository contractRepository = new ContractRepositoryImpl();
    @Override
    public List<Contract> getAll() {
        return contractRepository.getAll();
    }

    @Override
    public void insert(Contract contract) throws SQLException {
        contractRepository.insert(contract);
    }
}
