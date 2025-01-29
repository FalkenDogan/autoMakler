package com.mdgn.autoMakler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "saled_car",
uniqueConstraints = {@UniqueConstraint(columnNames = { "autoMakler_id", "car_id", "customer_id" }, name= "uq_auto_makler_car_customer") })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaledCar extends BaseEntity {
	@ManyToOne
	private AutoMakler autoMakler;
	@ManyToOne
	private Car car;
	@ManyToOne
	private Customer customer;
}
