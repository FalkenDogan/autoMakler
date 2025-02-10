package com.mdgn.autoMakler.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdgn.autoMakler.controller.IRestAutoMaklerController;
import com.mdgn.autoMakler.controller.RestBaseController;
import com.mdgn.autoMakler.controller.RootEntity;
import com.mdgn.autoMakler.dto.DtoAutoMakler;
import com.mdgn.autoMakler.dto.DtoAutoMaklerIU;
import com.mdgn.autoMakler.service.IAutoMaklerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/autoMakler")
public class RestAutoMaklerControllerImpl extends RestBaseController implements IRestAutoMaklerController{
	
	@Autowired
	private IAutoMaklerService autoMaklerService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoAutoMakler> saveAutoMakler(@Valid @RequestBody DtoAutoMaklerIU dtoAutoMaklerIU) {
		// TODO Auto-generated method stub
		return ok(autoMaklerService.saveAutoMakler(dtoAutoMaklerIU));
	}

}
