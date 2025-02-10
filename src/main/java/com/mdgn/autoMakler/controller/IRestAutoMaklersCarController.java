package com.mdgn.autoMakler.controller;

import com.mdgn.autoMakler.dto.DtoAutoMaklerCar;
import com.mdgn.autoMakler.dto.DtoAutoMaklerCarIU;

public interface IRestAutoMaklersCarController {

	public RootEntity<DtoAutoMaklerCar> saveAutoMaklersCar(DtoAutoMaklerCarIU dtoAutoMaklerCarIU);
}
