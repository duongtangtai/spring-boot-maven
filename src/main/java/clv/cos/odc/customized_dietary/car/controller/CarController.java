package clv.cos.odc.customized_dietary.car.controller;

import clv.cos.odc.customized_dietary.car.dto.CarDto;
import clv.cos.odc.customized_dietary.car.service.CarService;
import clv.cos.odc.customized_dietary.common.dto.ResponseDto;
import clv.cos.odc.customized_dietary.common.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
@Slf4j
public class CarController {
    private final CarService service;

    @GetMapping
    public ResponseEntity<ResponseDto> findAllCars() {
        return ResponseUtil.get(service.findAllCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto> findCarById(@PathVariable Integer id) {
        return ResponseUtil.get(service.findCarById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto> addCar(@RequestBody CarDto dto) {
        return ResponseUtil.get(service.addCar(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updateCar(@PathVariable Integer id, @RequestBody CarDto dto) {
        return ResponseUtil.get(service.updateCar(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deleteCarById(@PathVariable Integer id) {
        service.deleteCarById(id);
        return ResponseUtil.get(null, HttpStatus.NO_CONTENT);
    }
}
