package com.mdgn.autoMakler.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoSaledCarIU {

	@NotNull
	private Long customerId;
	@NotNull
	private Long autoMaklerId;
	@NotNull
	private Long carId;
}
