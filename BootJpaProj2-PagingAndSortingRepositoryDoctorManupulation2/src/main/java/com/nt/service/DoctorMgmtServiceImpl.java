package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {
	
	@Autowired
	private IDoctorRepository dRepo;
	
	public List<Doctor> showDoctorBySorting(boolean asc, String...props){
	    	Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, props);
	    	List<Doctor> list = (List<Doctor>)dRepo.findAll(sort);
	    	return list;	    	
	    }

	@Override
	public Page<Doctor> showDoctorInfoByPageNo(int pageNo, int pageSize, boolean asc, String... props) {
		Sort sort = Sort.by(asc?Direction.ASC:Direction.DESC, props);
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		Page<Doctor> page = dRepo.findAll(pageable);
		return page;
	}

	@Override
	public void showDoctorPageByPage(int pageSize) {
		
		int count = (int)dRepo.count();
		int pageNo=count/pageSize;
		if(count%pageSize!=0) {
			pageNo+=1;
		}
		
		for(int i=0;i<pageNo;i++) {
			Pageable pageable = PageRequest.of(i, pageSize);
			System.out.println("Page -> "+(i+1));
			Page<Doctor> page = dRepo.findAll(pageable);
			List<Doctor> list = page.getContent();
			list.forEach(System.out::println);
		}
		
	}
	

}
