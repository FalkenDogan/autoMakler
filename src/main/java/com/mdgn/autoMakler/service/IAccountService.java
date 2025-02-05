package com.mdgn.autoMakler.service;

import com.mdgn.autoMakler.dto.DtoAccount;
import com.mdgn.autoMakler.dto.DtoAccountIU;

public interface IAccountService {

	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
