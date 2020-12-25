package service.repository;

import service.model.ServiceType;

import java.util.List;

public interface ServiceTypeRepository {
    List<ServiceType> getAll();
}
