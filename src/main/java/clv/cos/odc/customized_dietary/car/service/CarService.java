package clv.cos.odc.customized_dietary.car.service;

import clv.cos.odc.customized_dietary.car.dto.CarDto;

import java.util.List;

public interface CarService {
    List<CarDto> findAllCars();
    CarDto findCarById(Integer id);
    CarDto addCar(CarDto carDto);
    CarDto updateCar(Integer id, CarDto dto);
    void deleteCarById(Integer id);
}
