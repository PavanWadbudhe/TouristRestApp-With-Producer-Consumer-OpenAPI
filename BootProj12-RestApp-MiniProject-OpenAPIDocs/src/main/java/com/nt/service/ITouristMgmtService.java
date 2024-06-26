package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;
import com.nt.error.TouristNotFoundException;

public interface ITouristMgmtService {
	public String registerTourist(Tourist tourist);
	public List<Tourist> fetchAllTourist();
	public List<Tourist> showAllTourist(String city1, String city2, String city3);
	public Tourist findTouristById(Integer id) throws TouristNotFoundException;
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;
	public List<Tourist> getAllTouristByName(String tname);
	public String updateTouristBudgetById(int tid, double descountPercent) throws TouristNotFoundException;
	public String removeTouristById(int tid) throws TouristNotFoundException;
	public String removeTouristByBudgetRange(double start ,double end) throws TouristNotFoundException;

}
