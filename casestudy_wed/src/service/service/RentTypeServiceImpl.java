package service.service;

import service.model.RentType;
import service.repository.RentTypeRepository;
import service.repository.RentTypeRepositoryImpl;

import java.util.List;

public class RentTypeServiceImpl implements RentTypeService {
    RentTypeRepository rentTypeRepository = new RentTypeRepositoryImpl();
    @Override
    public List<RentType> getAll() {
        return rentTypeRepository.getAll();
    }
}
