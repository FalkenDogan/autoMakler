package com.mdgn.autoMakler.service;

import com.mdgn.autoMakler.dto.DtoCar;
import com.mdgn.autoMakler.dto.DtoCarIU;

public interface ICarService {

	public DtoCar saveCar(DtoCarIU dtoCarIU);
}
