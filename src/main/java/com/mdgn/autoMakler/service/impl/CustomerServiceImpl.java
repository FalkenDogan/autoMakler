package com.mdgn.autoMakler.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdgn.autoMakler.dto.DtoAccount;
import com.mdgn.autoMakler.dto.DtoAddress;
import com.mdgn.autoMakler.dto.DtoCustomer;
import com.mdgn.autoMakler.dto.DtoCustomerIU;
import com.mdgn.autoMakler.exception.BaseException;
import com.mdgn.autoMakler.exception.ErrorMessage;
import com.mdgn.autoMakler.exception.MessageType;
import com.mdgn.autoMakler.model.Account;
import com.mdgn.autoMakler.model.Address;
import com.mdgn.autoMakler.model.Customer;
import com.mdgn.autoMakler.repository.AccountRepository;
import com.mdgn.autoMakler.repository.AddressRepository;
import com.mdgn.autoMakler.repository.CustomerRepository;
import com.mdgn.autoMakler.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private AccountRepository accountRepository;

	private Customer createCustomer(DtoCustomerIU dtoCustomerIU) {
		Optional<Address> optAddress = addressRepository.findById(dtoCustomerIU.getAddressId());
		if (optAddress.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAddressId().toString()));
		}

		Optional<Account> optAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
		if (optAccount.isEmpty()) {
			throw new BaseException(
					new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAccountId().toString()));
		}

		Customer customer = new Customer();
		customer.setCreateTime(new Date());
		BeanUtils.copyProperties(dtoCustomerIU, customer);

		customer.setAddress(optAddress.get());
		customer.setAccount(optAccount.get());

		return customer;

	}

	@Override
	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		DtoAccount dtoAccount = new DtoAccount();

		Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));

		BeanUtils.copyProperties(savedCustomer, dtoCustomer);
		BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
		BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);

		dtoCustomer.setAddress(dtoAddress);
		dtoCustomer.setAccount(dtoAccount);
		return null;
	}

}
