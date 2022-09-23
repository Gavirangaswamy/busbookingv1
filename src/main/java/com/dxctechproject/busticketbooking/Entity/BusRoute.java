package com.dxctechproject.busticketbooking.Entity;


import lombok.Data;

@Data
public class BusRoute {
	
	private Long id;
	private String origin;
	private String destination;
	private String travelDate;
	private String travelTime;
	private double tktFare;
	private Long busid;
	private String busName;
	private String busType;
	private String no_of_seatss;
}