package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class DoctorRunner implements CommandLineRunner {
    
	@Autowired
	private IDoctorMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		//service.showDoctorBySorting(true, "spec").forEach(System.out::println);
		
		/*Page<Doctor>page = service.showDoctorInfoByPageNo(0, 4, true, "spec");
		List<Doctor> list = page.getContent();
		list.forEach(System.out::println);*/
		service.showDoctorPageByPage(3);
	}

}
