package com.mdgn.autoMakler.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auto_makler")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoMakler extends BaseEntity{
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@OneToOne
	private Address address;
}
