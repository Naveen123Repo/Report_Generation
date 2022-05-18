package com.Report.response;

import java.time.LocalDate;

public class SearchResponse {

	private Integer caseNum;

	private String planName;

	private String planStatus;

	private String holderName;

	private Long holderSsn;

	private Double benefitAmt;

	private LocalDate startDate;

	private LocalDate endDate;

	private String denielReason;

	public Integer getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Long getHolderSsn() {
		return holderSsn;
	}

	public void setHolderSsn(Long holderSsn) {
		this.holderSsn = holderSsn;
	}

	public Double getBenefitAmt() {
		return benefitAmt;
	}

	public void setBenefitAmt(Double benefitAmt) {
		this.benefitAmt = benefitAmt;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getDenielReason() {
		return denielReason;
	}

	public void setDenielReason(String denielReason) {
		this.denielReason = denielReason;
	}
	
	

}
