package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Plots")
public class Plot {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long plotId;
	@Column(name = "agricultural_season")
	private String agriculturalSeason;
	@Column(name = "Area_in_acres")
	private int areaInAcres;
	@Column(name = "irrigation_status")
	private String irrigationStatus;
	@Column(name = "irrigation_times")
	private String irrigationTimes;
	@Column(name = "land_quality")
	private String landQuality;
	@Column(name = "irrigation_date")
	private String irrigationDate;
	@Column(name = "land_type")
	private String landType;
	@Column(name = "crop_name")
	private String cropName;
	
	@Column(name = "plot_owner")
	private String plotOwner;
}
