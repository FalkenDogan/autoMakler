package com.mdgn.autoMakler.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdgn.autoMakler.controller.IRestAddressController;
import com.mdgn.autoMakler.controller.RestBaseController;
import com.mdgn.autoMakler.controller.RootEntity;
import com.mdgn.autoMakler.dto.DtoAddress;
import com.mdgn.autoMakler.dto.DtoAddressIU;
import com.mdgn.autoMakler.service.IAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("rest/api/address")
public class RestAddressControllerImpl extends RestBaseController implements IRestAddressController {

	@Autowired
	private IAddressService addressService;
	
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dtoAddressIU) {
		return ok(addressService.saveAddress(dtoAddressIU));
	}

}
