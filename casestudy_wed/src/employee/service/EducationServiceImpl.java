package employee.service;

import employee.model.EducationDegree;
import employee.repository.EducationDegreeRepository;
import employee.repository.EducationDegreeRepositoryImpl;

import java.util.List;

public class EducationServiceImpl implements EducationService {
    EducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();
    @Override
    public List<EducationDegree> getAllEducation() {
        return educationDegreeRepository.getAllEducation();
    }
}
