package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {

    public List<Doctor> showDoctorBySorting(boolean asc, String...props);
    public Page<Doctor> showDoctorInfoByPageNo(int pageNo,int pageSize,boolean asc,String...props);
    public void showDoctorPageByPage(int pageSize);
    	
}
