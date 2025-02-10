package com.mdgn.autoMakler.controller;

import com.mdgn.autoMakler.dto.DtoAutoMakler;
import com.mdgn.autoMakler.dto.DtoAutoMaklerIU;

public interface IRestAutoMaklerController {

	public RootEntity<DtoAutoMakler> saveAutoMakler(DtoAutoMaklerIU dtoAutoMaklerIU);
}
