package com.mdgn.autoMakler.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdgn.autoMakler.controller.IRestSaledCarController;
import com.mdgn.autoMakler.controller.RestBaseController;
import com.mdgn.autoMakler.controller.RootEntity;
import com.mdgn.autoMakler.dto.DtoSaledCar;
import com.mdgn.autoMakler.dto.DtoSaledCarIU;
import com.mdgn.autoMakler.service.ISaledCarService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/saled-car")
public class RestsaledCarControllerImpl extends RestBaseController implements IRestSaledCarController {

	@Autowired
	private ISaledCarService saledCarService;
	
	
	@PostMapping("/save")
	@Override
	public RootEntity<DtoSaledCar> buyCar(@Valid @RequestBody DtoSaledCarIU dtoSaledCarIU) {
		
		return ok(saledCarService.buyCar(dtoSaledCarIU));
	}

}
