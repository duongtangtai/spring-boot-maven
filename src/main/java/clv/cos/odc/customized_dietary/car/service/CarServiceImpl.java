package clv.cos.odc.customized_dietary.car.service;

import clv.cos.odc.customized_dietary.car.dto.CarDto;
import clv.cos.odc.customized_dietary.car.mapper.CarMapper;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarMapper mapper;

    @Override
    public List<CarDto> findAllCars() {
        return mapper.findAllCars();
    }

    @Override
    public CarDto findCarById(Integer id) {
        return mapper.findCarById(id);
    }

    @Override
    public CarDto addCar(CarDto carDto) {
        if (mapper.addCar(carDto) < 1) {
            throw new ValidationException("Can't insert car");
        }
        return mapper.findCarById(carDto.getId());
    }

    @Override
    public CarDto updateCar(Integer id, CarDto carDto) {
        carDto.setId(id);
        if (mapper.updateCar(carDto) < 1) {
            throw new ValidationException("Can't update car");
        }
        return mapper.findCarById(carDto.getId());
    }

    @Override
    public void deleteCarById(Integer id) {
        if (mapper.deleteCarById(id) < 1) {
            throw new ValidationException("Can't delete car");
        }
    }
}
