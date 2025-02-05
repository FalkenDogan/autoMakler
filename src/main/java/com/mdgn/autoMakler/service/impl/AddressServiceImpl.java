package com.mdgn.autoMakler.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdgn.autoMakler.dto.DtoAddress;
import com.mdgn.autoMakler.dto.DtoAddressIU;
import com.mdgn.autoMakler.model.Address;
import com.mdgn.autoMakler.repository.AddressRepository;
import com.mdgn.autoMakler.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	
	private Address createAddress(DtoAddressIU dtoAddressIU) {
		Address address =new Address();
		address.setCreateTime(new Date());
		
		BeanUtils.copyProperties(dtoAddressIU, address);
		return address;
	}
	@Override
	public DtoAddress saveAddress(DtoAddressIU dtoAddressIU) {

		DtoAddress dtoAddress = new DtoAddress();
		
		Address savedAddress = addressRepository.save(createAddress(dtoAddressIU));
		BeanUtils.copyProperties(savedAddress, dtoAddress);
		
		return dtoAddress;
	}

	
}
