package com.mdgn.autoMakler.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoAutoMaklerIU {
	
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private Long addressId;
}
