package com.dxctechproject.busticketbooking.Entity;

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
@Table()
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "route")
	private Long bus;
	private String routeName;
	private String origin;
	private String destination;
	private String pickUp;
	private String dropping;
	private String travelDate;
	private String travelTime;
	private double tktFare;
}