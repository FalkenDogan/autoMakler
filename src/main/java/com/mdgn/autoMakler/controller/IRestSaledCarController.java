package com.mdgn.autoMakler.controller;

import com.mdgn.autoMakler.dto.DtoSaledCar;
import com.mdgn.autoMakler.dto.DtoSaledCarIU;

public interface IRestSaledCarController {

	public RootEntity<DtoSaledCar> buyCar(DtoSaledCarIU dtoSaledCarIU);
}
