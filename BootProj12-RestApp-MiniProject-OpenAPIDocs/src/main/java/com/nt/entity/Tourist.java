package com.nt.entity;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="REST_TOURIST")
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Tourist {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "TOURIST_SEQ", initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer tid;
	
	@Column(length = 20)
	@NonNull
	private String name;
	
	@Column(length=20)
	@NonNull
	private String city;
	
	@Column(length=20)
	@NonNull
	private String packageType;
	
	@NonNull
	private Double budget;
	
	@NonNull
	private LocalDate startsFrom;
	
	@NonNull
	private LocalDate endsOn;

}
