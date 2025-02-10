package com.mdgn.autoMakler.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdgn.autoMakler.dto.DtoAddress;
import com.mdgn.autoMakler.dto.DtoAutoMakler;
import com.mdgn.autoMakler.dto.DtoAutoMaklerIU;
import com.mdgn.autoMakler.exception.BaseException;
import com.mdgn.autoMakler.exception.ErrorMessage;
import com.mdgn.autoMakler.exception.MessageType;
import com.mdgn.autoMakler.model.Address;
import com.mdgn.autoMakler.model.AutoMakler;
import com.mdgn.autoMakler.repository.AddressRepository;
import com.mdgn.autoMakler.repository.AutoMaklerRepository;
import com.mdgn.autoMakler.service.IAutoMaklerService;

@Service
public class AutoMaklerServiceImpl implements IAutoMaklerService{
	@Autowired
	private AutoMaklerRepository autoMaklerRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	private AutoMakler createAutoMakler(DtoAutoMaklerIU dtoAutoMaklerIU) {
		
		Optional<Address> optAddress=addressRepository.findById(dtoAutoMaklerIU.getAddressId());
		if(optAddress.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoAutoMaklerIU.getAddressId().toString()));
		}
		AutoMakler autoMakler = new AutoMakler();
		autoMakler.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoAutoMaklerIU, autoMakler);
		autoMakler.setAddress(optAddress.get());
		
		return autoMakler;
		
	}
	
	@Override
	public DtoAutoMakler saveAutoMakler(DtoAutoMaklerIU dtoAutoMaklerIU) {
		DtoAutoMakler dtoAutoMakler =new DtoAutoMakler();
		DtoAddress dtoAddress = new DtoAddress();
		
		AutoMakler savedAutoMakler =autoMaklerRepository.save(createAutoMakler(dtoAutoMaklerIU));
		
		BeanUtils.copyProperties(savedAutoMakler, dtoAutoMakler);
		BeanUtils.copyProperties(savedAutoMakler.getAddress(), dtoAddress);
		
		dtoAutoMakler.setAddress(dtoAddress);
		
		return dtoAutoMakler;
	}

}
