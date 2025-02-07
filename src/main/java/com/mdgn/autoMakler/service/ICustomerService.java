package com.mdgn.autoMakler.service;

import com.mdgn.autoMakler.dto.DtoCustomer;
import com.mdgn.autoMakler.dto.DtoCustomerIU;

public interface ICustomerService {

	public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
