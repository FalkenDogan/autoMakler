package com.mdgn.autoMakler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoAutoMakler extends DtoBase{
	private String firstName;
	private String lastName;
	private DtoAddress address;
}
