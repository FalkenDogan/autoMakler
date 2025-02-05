package com.mdgn.autoMakler.controller;

import com.mdgn.autoMakler.dto.DtoAddress;
import com.mdgn.autoMakler.dto.DtoAddressIU;

public interface IRestAddressController {

	public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);
}
