package com.club.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.transform.PassThroughResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Service;
import com.club.controller.MemberWrapper;
import com.club.domain.Member;
import com.club.repo.MemberRepo;
import com.club.util.ClubUtil;

@Service
public class MemberService {

	private static final Logger log = LoggerFactory.getLogger(MemberService.class);


	@Autowired
	private MemberRepo memberRepo;

	@Autowired
	private HibernateJpaSessionFactoryBean sessionFactory;


	public void saveMemebers(List<Member> members){

		try{

			memberRepo.save(members);

		}catch (Exception e) {
			log.error("Exceptoin while save list of members : {}",e);
		}
	}

	/*public Map<String,Object> getMembersBySearchParameter(MemberWrapper memberWrapper){

		log.info("Session factpry is : {}",sessionFactory);

		boolean isPagination = true;

		if(memberWrapper.getPageNo().equals(0) && memberWrapper.getPageSize().equals(0)){
			log.info("Inside the case of get all members of without pagination");
			isPagination = false;
		}

		Map<String,Object> response = new HashMap<>();

		response = getMembersByDynamicSearchQuery(memberWrapper,isPagination ? true : false,memberWrapper.getPageNo() <= 0 ? 0 : memberWrapper.getPageNo()-1,memberWrapper.getPageSize());

		return null;
	}*/

	
	public Map<String,Object> getMembersByDynamicSearchQuery (
			MemberWrapper memberWrapper, boolean isPagination, int pageNo, int pageSize) throws Exception {

		EntityManagerFactory emf = sessionFactory.getEntityManagerFactory();
		EntityManager en = emf.createEntityManager();

		Session session = en.unwrap(Session.class);

		Criteria criteria = session.createCriteria(Member.class);

		if (memberWrapper.getMemberId() != null) {
			criteria.add(Restrictions.eq("memberId",memberWrapper.getMemberId()));
		}
		if (memberWrapper.getLoanAmnt() != null) {
			criteria.add(Restrictions.eq("loanAmnt", memberWrapper.getLoanAmnt()));
		}
		if (memberWrapper.getFundedAmntInv() != null) {
			criteria.add(Restrictions.eq("fundedAmntInv", memberWrapper.getFundedAmntInv()));
			//		criteria.add(Restrictions.between("createdAt", new Date(req_TempTransactionHistory.getStartDate()),
			//					new Date(req_TempTransactionHistory.getEndDate())));
		}
		if (memberWrapper.getTerm() != null) {
			criteria.add(Restrictions.eq("term", memberWrapper.getTerm()));
		}
		if (memberWrapper.getIntRate() != null) {
			criteria.add(Restrictions.eq("intRate", memberWrapper.getIntRate()));
		}
		if (memberWrapper.getInstallment() != null) {
			criteria.add(Restrictions.eq("installment", memberWrapper.getInstallment()));
		}
		if (memberWrapper.getGrade() != null) {
			criteria.add(Restrictions.eq("grade", memberWrapper.getGrade()));
		}
		if (memberWrapper.getEmpTitle() != null) {
			criteria.add(Restrictions.eq("empTitle", memberWrapper.getEmpTitle()));
		}
		if (memberWrapper.getEmpLength() != null) {
			criteria.add(Restrictions.eq("empLength", memberWrapper.getEmpLength()));
		}
		if (memberWrapper.getHomeOwnership() != null) {
			criteria.add(Restrictions.eq("homeOwnership", memberWrapper.getHomeOwnership()));
		}
		if (memberWrapper.getAnnualInc() != null) {
			criteria.add(Restrictions.eq("annualInc", memberWrapper.getAnnualInc()));
		}
		if (memberWrapper.getVerificationStatus() != null) {
			criteria.add(Restrictions.eq("verificationStatus", memberWrapper.getVerificationStatus()));
		}
		if (memberWrapper.getIssueD() != null) {
			criteria.add(Restrictions.eq("issueD", memberWrapper.getIssueD()));
		}
		if (memberWrapper.getLoanStatus() != null) {
			criteria.add(Restrictions.eq("loanStatus", memberWrapper.getLoanStatus()));
		}
		if (memberWrapper.getPurpose() != null) {
			criteria.add(Restrictions.eq("purpose", memberWrapper.getPurpose()));
		}
		if (memberWrapper.getTitle() != null) {
			criteria.add(Restrictions.eq("title", memberWrapper.getTitle()));
		}
		if (memberWrapper.getAddrState() != null) {
			criteria.add(Restrictions.eq("addrState", memberWrapper.getAddrState()));
		}
		if (memberWrapper.getLastPymntD() != null) {
			criteria.add(Restrictions.eq("lastPymntD", memberWrapper.getLastPymntD()));
		}
		if (memberWrapper.getLastPymntAmnt() != null) {
			criteria.add(Restrictions.eq("lastPymntAmnt", memberWrapper.getLastPymntAmnt()));
		}

		//		if (req_TempTransactionHistory.getEmail() != null) {
		//			Criteria userCriteria = criteria.createCriteria("user");
		//			userCriteria.add(Restrictions.like("email", req_TempTransactionHistory.getEmail() + "%"));
		//		}

		Map<String,Object> response = new HashMap<String,Object>();
		criteria.setProjection(Projections.rowCount());

		List countList =criteria.list();
		log.info("DB Member count result is : {}",countList);

		response.put("totalCount", countList.isEmpty() ? 0 : countList.get(0));

		//Remove the row count
		criteria.setProjection(null);

		if (isPagination) {
			criteria.setFirstResult(pageNo*pageSize);
			criteria.setMaxResults(pageSize);
		}

		log.info("page number : {} , page Size : {}",pageNo,pageSize);
		response.put("members",criteria.list());
		//log.info("Db query result is : {}",response);
		session.close();
		return response;
	}

}
