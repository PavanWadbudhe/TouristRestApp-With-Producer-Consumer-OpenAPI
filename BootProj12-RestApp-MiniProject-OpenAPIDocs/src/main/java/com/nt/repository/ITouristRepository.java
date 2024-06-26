package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.Tourist;

import jakarta.transaction.Transactional;

public interface ITouristRepository extends JpaRepository<Tourist, Integer> {
	
	@Query("from Tourist where city in (:city1, :city2, :city3) order by name asc")
	public List<Tourist> findTouristByCities(String city1,String city2,String city3);
	
	@Query("from Tourist where name =:name order by tid asc")
	public List<Tourist> findToursitByName(String name);
	
	@Query("delete from Tourist where budget>=:start and budget <=:end")
	@Modifying
	@Transactional
	public int removeTouristByBudgetRange(double start, double end);

}
