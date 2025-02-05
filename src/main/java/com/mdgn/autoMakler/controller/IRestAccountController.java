package com.mdgn.autoMakler.controller;

import com.mdgn.autoMakler.dto.DtoAccount;
import com.mdgn.autoMakler.dto.DtoAccountIU;

public interface IRestAccountController {
	
	public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);

}
