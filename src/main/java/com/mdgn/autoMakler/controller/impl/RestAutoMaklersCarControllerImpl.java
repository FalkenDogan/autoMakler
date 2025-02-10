package com.mdgn.autoMakler.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdgn.autoMakler.controller.IRestAutoMaklersCarController;
import com.mdgn.autoMakler.controller.RestBaseController;
import com.mdgn.autoMakler.controller.RootEntity;
import com.mdgn.autoMakler.dto.DtoAutoMaklerCar;
import com.mdgn.autoMakler.dto.DtoAutoMaklerCarIU;
import com.mdgn.autoMakler.service.IAutoMaklerCarService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/rest/api/gallerist-car")
public class RestAutoMaklersCarControllerImpl extends RestBaseController implements IRestAutoMaklersCarController{

	@Autowired
	private IAutoMaklerCarService autoMaklerCarService;
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoAutoMaklerCar> saveAutoMaklersCar(@Valid @RequestBody DtoAutoMaklerCarIU dtoAutoMaklerCarIU) {

		
		return ok(autoMaklerCarService.saveAutoMaklerCar(dtoAutoMaklerCarIU));
	}

	
	
	
	
	
	
	
	
}
