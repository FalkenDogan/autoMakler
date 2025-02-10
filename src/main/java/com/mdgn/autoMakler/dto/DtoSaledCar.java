package com.mdgn.autoMakler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSaledCar extends DtoBase {

	private DtoCustomer customer;

	private DtoAutoMakler autoMakler;

	private DtoCar car;
}
