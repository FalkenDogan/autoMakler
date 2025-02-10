package com.mdgn.autoMakler.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdgn.autoMakler.dto.CurrencyRatesResponse;
import com.mdgn.autoMakler.dto.DtoAutoMakler;
import com.mdgn.autoMakler.dto.DtoCar;
import com.mdgn.autoMakler.dto.DtoCustomer;
import com.mdgn.autoMakler.dto.DtoSaledCar;
import com.mdgn.autoMakler.dto.DtoSaledCarIU;
import com.mdgn.autoMakler.enums.CarStatusType;
import com.mdgn.autoMakler.exception.BaseException;
import com.mdgn.autoMakler.exception.ErrorMessage;
import com.mdgn.autoMakler.exception.MessageType;
import com.mdgn.autoMakler.model.Car;
import com.mdgn.autoMakler.model.Customer;
import com.mdgn.autoMakler.model.SaledCar;
import com.mdgn.autoMakler.repository.AutoMaklerRepository;
import com.mdgn.autoMakler.repository.CarRepository;
import com.mdgn.autoMakler.repository.CustomerRepository;
import com.mdgn.autoMakler.repository.SaledCarRepository;
import com.mdgn.autoMakler.service.ICurrencyRatesService;
import com.mdgn.autoMakler.service.ISaledCarService;
import com.mdgn.autoMakler.utils.DateUtils;

@Service
public class SaledCarServiceImpl implements ISaledCarService {

	@Autowired
	private SaledCarRepository saledCarRepository;
	@Autowired
	private AutoMaklerRepository autoMaklerRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private ICurrencyRatesService currencyRatesService;

	public BigDecimal convertCustomerAmountToUSD(Customer customer) {

		CurrencyRatesResponse currencyRatesResponse = currencyRatesService
				.getCurrencyRates(DateUtils.getCurrentDate(new Date()), DateUtils.getCurrentDate(new Date()));
		BigDecimal usd = new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd());

		BigDecimal customerUSDAmount = customer.getAccount().getAmount().divide(usd, 2, RoundingMode.HALF_UP);

		return customerUSDAmount;
	}

	public boolean checkCarStatus(Long carId) {

		Optional<Car> optCar = carRepository.findById(carId);
		if (optCar.isPresent() && optCar.get().getCarStatusType().name().equals(CarStatusType.SALED.name())) {
			return false;
		}
		return true;
	}

	public BigDecimal remainingCustomerAmount(Customer customer, Car car) {
		BigDecimal customerUSDAmount = convertCustomerAmountToUSD(customer);
		BigDecimal remainingCustomerUSDAmount = customerUSDAmount = customerUSDAmount.subtract(car.getPrice());

		CurrencyRatesResponse currencyRatesResonse = currencyRatesService
				.getCurrencyRates(DateUtils.getCurrentDate(new Date()), DateUtils.getCurrentDate(new Date()));

		return remainingCustomerUSDAmount.multiply(new BigDecimal(currencyRatesResonse.getItems().get(0).getUsd()));// hocanın
																													// satırından
																													// farklı

	}

	public boolean checkAmount(DtoSaledCarIU dtoSaledCarIU) {

		Optional<Customer> optCustomer = customerRepository.findById(dtoSaledCarIU.getCustomerId());
		if (!optCustomer.isPresent()) {// değişti hocanınki farklı
			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoSaledCarIU.getCustomerId().toString()));
		}

		Optional<Car> optCar = carRepository.findById(dtoSaledCarIU.getCarId());
		if (!optCar.isPresent()) {// değixti hocanınki farklı
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoSaledCarIU.getCarId().toString()));
		}

		BigDecimal customerUSDAmount = convertCustomerAmountToUSD(optCustomer.get());
		if (customerUSDAmount.compareTo(optCar.get().getPrice()) == 0
				|| customerUSDAmount.compareTo(optCar.get().getPrice()) > 0) {
			return true;
		}
		return false;
	}

	private SaledCar createSaledCar(DtoSaledCarIU dtoSaledCarIU) {
		SaledCar saledCar = new SaledCar();
		saledCar.setCreateTime(new Date());

		saledCar.setCustomer(customerRepository.findById(dtoSaledCarIU.getCustomerId()).orElse(null));
		saledCar.setAutoMakler(autoMaklerRepository.findById(dtoSaledCarIU.getAutoMaklerId()).orElse(null));
		saledCar.setCar(carRepository.findById(dtoSaledCarIU.getCarId()).orElse(null));
		return saledCar;
	}

	@Override
	public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU) {
		if (!checkCarStatus(dtoSaledCarIU.getCarId())) {
			throw new BaseException(
					new ErrorMessage(MessageType.CAR_STATUS_IS_SOLD, dtoSaledCarIU.getCarId().toString()));

		}
		if (!checkAmount(dtoSaledCarIU)) {
			throw new BaseException(new ErrorMessage(MessageType.CUSTOMER_AMOUNT_IS_NOT_ENOUGH, ""));
		}

		SaledCar savedSaledCar = saledCarRepository.save(createSaledCar(dtoSaledCarIU));
		Car car = savedSaledCar.getCar();
		car.setCarStatusType(CarStatusType.SALED);
		carRepository.save(car);// update işlemi yapıldı

		Customer customer = savedSaledCar.getCustomer();
		customer.getAccount().setAmount(customer.getAccount().getAmount().subtract(car.getPrice()));
		return toDTO(savedSaledCar);
	}

	public DtoSaledCar toDTO(SaledCar saledCar) {
		DtoSaledCar dtoSaledCar = new DtoSaledCar();
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAutoMakler dtoAutoMakler = new DtoAutoMakler();
		DtoCar dtoCar = new DtoCar();

		BeanUtils.copyProperties(saledCar, dtoSaledCar);
		BeanUtils.copyProperties(saledCar.getCustomer(), dtoCustomer);
		BeanUtils.copyProperties(saledCar.getAutoMakler(), dtoAutoMakler);
		BeanUtils.copyProperties(saledCar.getCar(), dtoCar);

		dtoSaledCar.setCustomer(dtoCustomer);
		dtoSaledCar.setAutoMakler(dtoAutoMakler);
		dtoSaledCar.setCar(dtoCar);
		return dtoSaledCar;
	}

}
