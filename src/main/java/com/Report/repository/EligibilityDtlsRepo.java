package com.Report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Report.entity.EligibilityDtlsEntity;

public interface EligibilityDtlsRepo extends JpaRepository<EligibilityDtlsEntity, Integer> {

	@Query("select distinct(planName) from EligibilityDtlsEntity")
	public List<String> getPlanNames();
	
	@Query("select distinct(planStatus) from EligibilityDtlsEntity")
	public List<String> getPlanStatus();
	
	public List<EligibilityDtlsEntity> findByPlanName(String planName);
	
	public List<EligibilityDtlsEntity> findByPlanStatus(String planStatus);
	
	public List<EligibilityDtlsEntity> findByPlanNameAndPlanStatus(String planName, String planStatus);
	
	
}
 