package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.error.TouristNotFoundException;
import com.nt.repository.ITouristRepository;

@Service("touristService")
public class TouristMgmtServiceImpl implements ITouristMgmtService {
	@Autowired
    private ITouristRepository touristRepo;
	
	@Override
	public String registerTourist(Tourist tourist) {
		int tidVal=touristRepo.save(tourist).getTid();
		return "Tourist is registered having id value :: "+tidVal;
	}
	
	@Override
	public List<Tourist> fetchAllTourist() {
		List<Tourist> list=touristRepo.findAll();
		list.sort((t1,t2)-> t1.getName().compareToIgnoreCase(t2.getName()));
		return list;
	}

	@Override
	public List<Tourist> showAllTourist(String city1, String city2, String city3) {
		
		return touristRepo.findTouristByCities(city1, city2, city3);
	}

	@Override
	public Tourist findTouristById(Integer id) throws TouristNotFoundException {
		
		return touristRepo.findById(id).orElseThrow(()-> new TouristNotFoundException(id+" tourist not found"));
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> opt=touristRepo.findById(tourist.getTid());
		if(opt.isPresent()) {
			touristRepo.save(tourist);
			return tourist.getTid()+" Tourist is updated";
		}else {
			throw new TouristNotFoundException(tourist.getTid()+" tourist not found");
		}
		
	}

	@Override
	public List<Tourist> getAllTouristByName(String tname) {
		//use repo
		List<Tourist> list=touristRepo.findToursitByName(tname);
		if(list.isEmpty())
		   throw new TouristNotFoundException(tname+" tourist not found");
		else 
			return list;
	}

	@Override
	public String updateTouristBudgetById(int tid, double descountPercent) throws TouristNotFoundException {
		Optional<Tourist> opt=touristRepo.findById(tid);
		if(opt.isPresent()) {
			Tourist tu=opt.get();
			double budget=tu.getBudget();
			double newBudget=budget-(budget*descountPercent/100.0);
			tu.setBudget(newBudget);
			//use repo
			touristRepo.save(tu);
			return "Tourist's get discount on budget . The discount is :: "+descountPercent+" on budget :: "+budget+" new budget is :: "+newBudget;
		}
		else {
			throw new TouristNotFoundException(tid+" tourist not found");
		}
	}

	@Override
	public String removeTouristById(int tid) throws TouristNotFoundException {
		//use repo
		Optional<Tourist> opt=touristRepo.findById(tid);
		if(opt.isPresent()) {
			touristRepo.deleteById(tid);
			return tid +" Tourist found and deleted";
		}else {
			throw new TouristNotFoundException(tid+" Tourist not found for deletion");
		}
		
	}

	@Override
	public String removeTouristByBudgetRange(double start, double end) throws TouristNotFoundException {
		//use repo
		int count=touristRepo.removeTouristByBudgetRange(start, end);
		return count==0? "Tourist not found for deletion": count+" no. of tourist found and deleted";
	}
	
	

}
