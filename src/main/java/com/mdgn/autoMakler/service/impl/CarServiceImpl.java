package com.mdgn.autoMakler.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdgn.autoMakler.dto.DtoCar;
import com.mdgn.autoMakler.dto.DtoCarIU;
import com.mdgn.autoMakler.model.Car;
import com.mdgn.autoMakler.repository.CarRepository;
import com.mdgn.autoMakler.service.ICarService;

@Service
public class CarServiceImpl implements ICarService{
	
	@Autowired
	private CarRepository carRepository;
	
	
	
	
	public Car createCar(DtoCarIU dtoCarIU) {
		
		Car car = new Car();
		car.setCreateTime(new Date());
		
		BeanUtils.copyProperties(dtoCarIU, car);
		
		
		return car;
		
		
	}
	
	
	
	@Override
	public DtoCar saveCar(DtoCarIU dtoCarIU) {
		DtoCar dtoCar = new DtoCar();
		
		Car savedCar =carRepository.save(createCar(dtoCarIU));
		
		BeanUtils.copyProperties(savedCar, dtoCar);
		
		return dtoCar;
	}

}
