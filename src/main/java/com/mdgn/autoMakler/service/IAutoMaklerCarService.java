package com.mdgn.autoMakler.service;

import com.mdgn.autoMakler.dto.DtoAutoMaklerCar;
import com.mdgn.autoMakler.dto.DtoAutoMaklerCarIU;

public interface IAutoMaklerCarService {

	public DtoAutoMaklerCar saveAutoMaklerCar(DtoAutoMaklerCarIU dtoAutoMaklerCarIU);
	
}
