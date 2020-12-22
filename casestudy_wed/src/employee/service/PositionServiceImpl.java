package employee.service;

import employee.model.Position;
import employee.repository.PositionRepository;
import employee.repository.PositionRepositoryImpl;

import java.util.List;

public class PositionServiceImpl implements PositionService {
    PositionRepository positionRepository = new PositionRepositoryImpl();
    @Override
    public List<Position> getAllPosition() {
        return positionRepository.getAllPosition();
    }
}
