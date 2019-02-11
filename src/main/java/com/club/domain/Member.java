package com.club.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Member {
 
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE)
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
	
	@Column(name="description",length=9000)
	private String desc;

	private String purpose;

	private String title;

	private String addrState;

	private String lastPymntD;

	private String lastPymntAmnt;
	
	public Member(){}
	
	public Member(Integer memberId, Double loanAmnt, Double fundedAmntInv, String term, Float intRate,
			Float installment, String grade, String empTitle, String empLength, String homeOwnership, Double annualInc,
			String verificationStatus, String issueD, String loanStatus, String desc) {
		this.memberId = memberId;
		this.loanAmnt = loanAmnt;
		this.fundedAmntInv = fundedAmntInv;
		this.term = term;
		this.intRate = intRate;
		this.installment = installment;
		this.grade = grade;
		this.empTitle = empTitle;
		this.empLength = empLength;
		this.homeOwnership = homeOwnership;
		this.annualInc = annualInc;
		this.verificationStatus = verificationStatus;
		this.issueD = issueD;
		this.loanStatus = loanStatus;
		this.desc = desc;
	}

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

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", loanAmnt=" + loanAmnt + ", fundedAmntInv=" + fundedAmntInv
				+ ", term=" + term + ", intRate=" + intRate + ", installment=" + installment + ", grade=" + grade
				+ ", empTitle=" + empTitle + ", empLength=" + empLength + ", homeOwnership=" + homeOwnership
				+ ", annualInc=" + annualInc + ", verificationStatus=" + verificationStatus + ", issueD=" + issueD
				+ ", loanStatus=" + loanStatus + ", desc=" + desc + "]";
	}
	
}
