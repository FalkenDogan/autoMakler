package com.mdgn.autoMakler.controller;

import com.mdgn.autoMakler.dto.DtoCustomer;
import com.mdgn.autoMakler.dto.DtoCustomerIU;

public interface IRestCustomerController {
	public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
	
}
