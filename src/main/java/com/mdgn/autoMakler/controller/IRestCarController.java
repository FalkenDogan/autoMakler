package com.mdgn.autoMakler.controller;

import com.mdgn.autoMakler.dto.DtoCar;
import com.mdgn.autoMakler.dto.DtoCarIU;

public interface IRestCarController {

	public RootEntity<DtoCar> saveCar (DtoCarIU dtoCarIU);
	
}
