package com.club.controller;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;


public class MemberWrapper {

	@Digits(message="page number is not valid",integer=10, fraction = 0)
	@NotNull(message="page number is required")
	private Integer pageNo;

	@Digits(message="page size is not valid",integer=10, fraction = 0)
	@NotNull(message="page size is required")
	private Integer pageSize;
	
	private Integer memberId;

	private Double loanAmnt;
	
	private Double fundedAmntInv;
	
	private String term;
	
	private Float intRate;
	
	private Float installment;
	
	private String grade;
	
	private String empTitle;
	
	private String empLength;
	
	private String homeOwnership;
	
	private Double annualInc;
	
	private String verificationStatus;
	
	private String issueD;
	
	private String loanStatus;
	
	private String desc;

	private String purpose;

	private String title;

	private String addrState;

	private String lastPymntD;

	private String lastPymntAmnt;

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Double getLoanAmnt() {
		return loanAmnt;
	}

	public void setLoanAmnt(Double loanAmnt) {
		this.loanAmnt = loanAmnt;
	}

	public Double getFundedAmntInv() {
		return fundedAmntInv;
	}

	public void setFundedAmntInv(Double fundedAmntInv) {
		this.fundedAmntInv = fundedAmntInv;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Float getIntRate() {
		return intRate;
	}

	public void setIntRate(Float intRate) {
		this.intRate = intRate;
	}

	public Float getInstallment() {
		return installment;
	}

	public void setInstallment(Float installment) {
		this.installment = installment;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getEmpTitle() {
		return empTitle;
	}

	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}

	public String getEmpLength() {
		return empLength;
	}

	public void setEmpLength(String empLength) {
		this.empLength = empLength;
	}

	public String getHomeOwnership() {
		return homeOwnership;
	}

	public void setHomeOwnership(String homeOwnership) {
		this.homeOwnership = homeOwnership;
	}

	public Double getAnnualInc() {
		return annualInc;
	}

	public void setAnnualInc(Double annualInc) {
		this.annualInc = annualInc;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getIssueD() {
		return issueD;
	}

	public void setIssueD(String issueD) {
		this.issueD = issueD;
	}

	public String getLoanStatus() {
		return loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddrState() {
		return addrState;
	}

	public void setAddrState(String addrState) {
		this.addrState = addrState;
	}

	public String getLastPymntD() {
		return lastPymntD;
	}

	public void setLastPymntD(String lastPymntD) {
		this.lastPymntD = lastPymntD;
	}

	public String getLastPymntAmnt() {
		return lastPymntAmnt;
	}

	public void setLastPymntAmnt(String lastPymntAmnt) {
		this.lastPymntAmnt = lastPymntAmnt;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	
}
