package clv.cos.odc.customized_dietary.car.mapper;

import clv.cos.odc.customized_dietary.car.dto.CarDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
    List<CarDto> findAllCars();
    CarDto findCarById(Integer id);
    Integer addCar(CarDto carDto);
    Integer updateCar(CarDto dto);
    Integer deleteCarById(Integer id);
}
