package com.Report.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Report.request.SearchRequest;
import com.Report.response.SearchResponse;

@Service
public interface ReportService {
	
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<SearchResponse> searchPlans(SearchRequest request);
	

}
