package com.mdgn.autoMakler.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseEntity {

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "tckn")
	private String tckn;
	@Column(name = "birth_of_date")
	private String birthOfDate;
	@OneToOne//bir müşterinin bir adresi olabilir
	private Address address;
	@OneToOne//bir müşterinin bir hesabı olabilir ilk One bu classı ikinci one ise account classını temsil eder
	private Account account;

	
}
