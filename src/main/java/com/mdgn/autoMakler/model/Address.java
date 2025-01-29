package com.mdgn.autoMakler.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {//id ve zamanı base entityden alacak
	//başka bir yerle ilişkisi olmadığı için ve tablolar oluşurken manytoone onetomany gibi ilişkilerde hata alınmaması için önce bununla başlandı.

	@Column(name = "city")
	private String city;
	@Column(name = "district")
	private String district;
	@Column(name = "neighborhood")
	private String neighborhood;
	@Column(name = "street")
	private String street;

	
}
