package com.mdgn.autoMakler.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdgn.autoMakler.controller.IRestCarController;
import com.mdgn.autoMakler.controller.RestBaseController;
import com.mdgn.autoMakler.controller.RootEntity;
import com.mdgn.autoMakler.dto.DtoCar;
import com.mdgn.autoMakler.dto.DtoCarIU;
import com.mdgn.autoMakler.service.ICarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/car")
public class RestCarControllerImpl extends RestBaseController implements IRestCarController{

	@Autowired
	private ICarService carService;
	
		
	@PostMapping ("/save")	
	@Override
	public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU dtoCarIU) {

					return ok(carService.saveCar(dtoCarIU));
	}

	
}
