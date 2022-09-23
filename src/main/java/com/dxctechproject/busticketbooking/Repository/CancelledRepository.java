package com.dxctechproject.busticketbooking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxctechproject.busticketbooking.Entity.Cancelled;

@Repository
public interface CancelledRepository extends JpaRepository<Cancelled, String> {
	
	List<Cancelled> findByUser(String user);
	
}
