package com.mdgn.autoMakler.service;

import com.mdgn.autoMakler.dto.DtoAutoMakler;
import com.mdgn.autoMakler.dto.DtoAutoMaklerIU;

public interface IAutoMaklerService {

	public DtoAutoMakler saveAutoMakler (DtoAutoMaklerIU autoMaklerIU);
}
