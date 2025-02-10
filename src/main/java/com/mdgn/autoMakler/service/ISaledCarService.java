package com.mdgn.autoMakler.service;

import com.mdgn.autoMakler.dto.DtoSaledCar;
import com.mdgn.autoMakler.dto.DtoSaledCarIU;

public interface ISaledCarService {
	public DtoSaledCar buyCar(DtoSaledCarIU dtoSaledCarIU);

}
