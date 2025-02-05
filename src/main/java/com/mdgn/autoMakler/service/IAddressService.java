package com.mdgn.autoMakler.service;

import com.mdgn.autoMakler.dto.DtoAddress;
import com.mdgn.autoMakler.dto.DtoAddressIU;

public interface IAddressService {

	public DtoAddress saveAddress(DtoAddressIU dtoAddressIu);
}
