package employee.service;

import employee.model.Division;
import employee.repository.DivisionRepository;
import employee.repository.DivisionRepositoryImpl;

import java.util.List;

public class DivisionServiceImpl implements DivisionService {
    DivisionRepository divisionRepository = new DivisionRepositoryImpl();
    @Override
    public List<Division> getAllDivision() {
        return divisionRepository.getAllDivision();
    }
}
