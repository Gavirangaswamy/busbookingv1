package com.dxctechproject.busticketbooking.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cancelled {
	
	@Id
	@Column(unique = true, updatable = false)
    private String ticketId;
	private String busName;
	private String busNumber;
	private String RouteName;
    private String count;
    private String amount;
    private String seats;
    private String origin;
    private String destination;
    private String travelDate;
    private String travelTime;
    private String user;
    
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime cancelledAt;
    
}
