package com.mdgn.autoMakler.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdgn.autoMakler.dto.DtoAddress;
import com.mdgn.autoMakler.dto.DtoAutoMakler;
import com.mdgn.autoMakler.dto.DtoAutoMaklerCar;
import com.mdgn.autoMakler.dto.DtoAutoMaklerCarIU;
import com.mdgn.autoMakler.dto.DtoCar;
import com.mdgn.autoMakler.exception.BaseException;
import com.mdgn.autoMakler.exception.ErrorMessage;
import com.mdgn.autoMakler.exception.MessageType;
import com.mdgn.autoMakler.model.AutoMakler;
import com.mdgn.autoMakler.model.AutoMaklersCar;
import com.mdgn.autoMakler.model.Car;
import com.mdgn.autoMakler.repository.AutoMaklerCarRepository;
import com.mdgn.autoMakler.repository.AutoMaklerRepository;
import com.mdgn.autoMakler.repository.CarRepository;
import com.mdgn.autoMakler.service.IAutoMaklerCarService;

@Service
public class AutoMaklerCarImpl implements IAutoMaklerCarService {

	@Autowired
	private AutoMaklerCarRepository autoMaklerCarRepository;
	@Autowired
	private AutoMaklerRepository autoMaklerRepository;
	@Autowired
	private CarRepository carRepository;

	private AutoMaklersCar createAutoMaklerCar(DtoAutoMaklerCarIU dtoAutoMaklerCarIU) {
		Optional<AutoMakler> optAutoMakler = autoMaklerRepository.findById(dtoAutoMaklerCarIU.getAutoMaklerId());
		if (optAutoMakler.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoAutoMaklerCarIU.getAutoMaklerId().toString()));
		}
		Optional<Car> optCar = carRepository.findById(dtoAutoMaklerCarIU.getCarId());

		if (optCar.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoAutoMaklerCarIU.getCarId().toString()));
		}

		AutoMaklersCar autoMaklersCar = new AutoMaklersCar();
		autoMaklersCar.setCreateTime(new Date());
		autoMaklersCar.setAutoMakler(optAutoMakler.get());
		autoMaklersCar.setCar(optCar.get());

		return autoMaklersCar;

	}

	@Override
	public DtoAutoMaklerCar saveAutoMaklerCar(DtoAutoMaklerCarIU dtoAutoMaklerCarIU) {

		DtoAutoMaklerCar dtoAutoMaklerCar = new DtoAutoMaklerCar();
		DtoAutoMakler dtoAutoMakler = new DtoAutoMakler();
		DtoCar dtoCar = new DtoCar();

		DtoAddress dtoAddress = new DtoAddress();

		AutoMaklersCar savedAutoMaklersCar = autoMaklerCarRepository.save(createAutoMaklerCar(dtoAutoMaklerCarIU));

		BeanUtils.copyProperties(savedAutoMaklersCar, dtoAutoMaklerCar);
		BeanUtils.copyProperties(savedAutoMaklersCar.getAutoMakler(), dtoAutoMakler);
		BeanUtils.copyProperties(savedAutoMaklersCar.getAutoMakler().getAddress(), dtoAddress);
		BeanUtils.copyProperties(savedAutoMaklersCar.getCar(), dtoCar);

		dtoAutoMakler.setAddress(dtoAddress);
		dtoAutoMaklerCar.setAutoMakler(dtoAutoMakler);
		dtoAutoMaklerCar.setCar(dtoCar);

		return dtoAutoMaklerCar;
	}

}
