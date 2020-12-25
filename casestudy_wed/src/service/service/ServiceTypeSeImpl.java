package service.service;

import service.model.ServiceType;
import service.repository.ServiceTypeRepository;
import service.repository.ServiceTypeRepositoryImpl;

import java.util.List;

public class ServiceTypeSeImpl implements ServiceTypeSe {
    ServiceTypeRepository serviceTypeRepository = new ServiceTypeRepositoryImpl();
    @Override
    public List<ServiceType> getAll() {
        return serviceTypeRepository.getAll();
    }
}
