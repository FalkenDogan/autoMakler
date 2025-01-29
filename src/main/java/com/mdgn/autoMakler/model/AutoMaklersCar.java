package com.mdgn.autoMakler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auto_maklers_car",
		uniqueConstraints = {@UniqueConstraint(columnNames = { "autoMakler_id", "car_id" }, name= "uq_auto_makler_car") })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoMaklersCar extends BaseEntity {

	@ManyToOne
	private AutoMakler autoMakler;
	@ManyToOne
	private Car car;

}
