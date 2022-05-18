package com.Report.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import com.Report.entity.EligibilityDtlsEntity;
import com.Report.repository.EligibilityDtlsRepo;
import com.Report.request.SearchRequest;
import com.Report.response.SearchResponse;

public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private EligibilityDtlsRepo eligibilityRepo;

	@Override
	public List<String> getPlanNames() {
		List<String> planNames = eligibilityRepo.getPlanNames();
		return planNames;
	}

	@Override
	public List<String> getPlanStatus() {
		List<String> planStatus = eligibilityRepo.getPlanStatus();
		return planStatus;
	}

	@Override
	public List<SearchResponse> searchPlans(SearchRequest request) {
		
		List<EligibilityDtlsEntity> eligbleRecords=null;
		
		if(request==null) {
			eligbleRecords = eligibilityRepo.findAll();
		}else {
			
			String planName=request.getPlanName();
			String planStatus=request.getPlanStatus();
			LocalDate startDate = request.getStartDate();
			LocalDate endDate = request.getEndDate();
			
			EligibilityDtlsEntity entity=new EligibilityDtlsEntity();
			
			if(planName!=null && !planName.equals("")) {
				entity.setPlanName(planName);
			}
			if(planStatus!=null && !planStatus.equals("")) {
				entity.setPlanStatus(planStatus);
			}
			if(startDate!=null && endDate!=null) {
				entity.setStartDate(startDate);
				entity.setEndDate(endDate);
			}
			
			Example<EligibilityDtlsEntity> of = Example.of(entity);
			eligbleRecords = eligibilityRepo.findAll(of);
		}
		List<SearchResponse> response=new ArrayList<>();
		
		for(EligibilityDtlsEntity records :eligbleRecords) {
			SearchResponse s=new SearchResponse();
			BeanUtils.copyProperties(records, s);
			response.add(s);	
		}
		
		return response;
	}

}
