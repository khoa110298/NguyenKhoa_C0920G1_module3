package service.service;

import service.model.Service;
import service.repository.ServiceRepository;
import service.repository.ServiceRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ServiceImpl implements ServiceSe {
    ServiceRepository serviceRepository = new ServiceRepositoryImpl();
    @Override
    public List<Service> getAll() {
        return serviceRepository.getAll();
    }

    @Override
    public void insertService(Service service) throws SQLException {
        serviceRepository.insertService(service);
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException {
        return serviceRepository.deleteEmployee(id);
    }
}
