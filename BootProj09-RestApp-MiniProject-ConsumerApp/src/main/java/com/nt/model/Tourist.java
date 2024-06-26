package com.nt.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Tourist {
	
	private Integer tid;
	
	@NonNull
	private String name;
	
	@NonNull
	private String city;
	
	@NonNull
	private String packageType;
	
	@NonNull
	private Double budget;
	
	@NonNull
	private Date startsFrom;
	
	@NonNull
	private Date endsOn;

}
