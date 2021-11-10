package com.androidstore;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AppServicImpl implements AppService {
	@Autowired
	AppRepository apprepo;
	public List<Astore> getapp() {
		// TODO Auto-generated method stub
		
		return apprepo.findAll();
	}
	
	public List<Astore> findByKeyword(String keyword) {
		return apprepo.findByKeyword(keyword);
	}
	@Override
	public void saveApp(Astore astore) {
		// TODO Auto-generated method stub
		this.apprepo.save(astore);
	}
	@Override
	public Astore getAppById(long id) {
		Optional<Astore> optional = apprepo.findById(id);
		Astore astore = null;
		if (optional.isPresent()) {
			astore = optional.get();
		} else {
			throw new RuntimeException(" App not found for id :: " + id);
		}
		return astore;
	}
	@Override
	public void deleteAppById(long id) {
		this.apprepo.deleteById(id);
		
	}
	
	public Page<Astore> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
		
		Pageable Pageable = PageRequest.of(pageNo - 1,pageSize, sort);
		return this.apprepo.findAll(Pageable);
	}
	


}