package com.dxctechproject.busticketbooking.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dxctechproject.busticketbooking.Entity.Route;

public interface RouteRepository extends JpaRepository<Route, Long> {

	@Query("from Route WHERE origin = :from and destination= :to and travelDate=:date")
    ArrayList<Route> getByOriginAndDestinationAndDate(@Param(value = "from") String from, @Param("to") String to,@Param("date") String date);
}