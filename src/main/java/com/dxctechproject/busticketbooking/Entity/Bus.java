package com.dxctechproject.busticketbooking.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	@ManyToOne()
	@JoinColumn(name = "route_id", referencedColumnName = "id")
	private Route route;
	private String busName;
	private String busRegNo;
	private String busType;
	private String no_of_seats;
	@Column(updatable = false)
	private String createdAt;
	@Column(updatable = true)
	private String updatedAt;
}