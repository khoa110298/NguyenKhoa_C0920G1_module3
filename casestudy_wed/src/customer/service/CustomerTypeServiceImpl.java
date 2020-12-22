package customer.service;

import customer.model.CustomerType;
import customer.repository.CustomerTypeRepository;
import customer.repository.CustomerTypeRepositoryImpl;
import customer.service.CustomerTypeService;

import java.util.List;

public class CustomerTypeServiceImpl implements CustomerTypeService {
    CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();
    @Override
    public List<CustomerType> getAllCustomerType() {
        return customerTypeRepository.getAllCustomerType();
    }
}
