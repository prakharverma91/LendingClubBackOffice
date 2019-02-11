package com.club.bootstrap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.club.constant.ClubConstant;
import com.club.domain.Member;
import com.club.service.MemberService;
import com.club.util.ClubUtil;



@Service
public class BootstrapConfig {


	@Autowired
	ResourceLoader resourceLoader;
	private static final Logger log = LoggerFactory.getLogger(BootstrapConfig.class);


	@Autowired
	private MemberService memberService;
	

	public BootstrapConfig(){

	}

	@PostConstruct
	void loadAndCreateMemberFromFile() {

		log.info("inside the loadAndCreateMemberFromFile");
		try{
			Resource banner = resourceLoader.getResource("classpath:"+ClubConstant.LOAN_PART_FILE_PATH);
			log.info("file path : {}",banner.getURI());

			BufferedReader fileReader = null;
			List<Member> members = new ArrayList<Member>();
			String line = "";
			fileReader = new BufferedReader(new FileReader(banner.getFile()));
			// Read CSV header
			fileReader.readLine();

			boolean isHeader = true;
			int lineNumber=0;
			// Read customer data line by line
			while ((line = fileReader.readLine()) != null) {
				log.info("Row number is : {}",lineNumber);
			lineNumber++;
				if(isHeader){
					isHeader=false;
					continue;
				}
				String[] tokens = line.split(",");
				if (tokens.length > 0) {
					members.add(getMemberObject(tokens));
				}
			}
			log.info("redead mlist is : {}",members.size());
		//	this.printListData(members);

			memberService.saveMemebers(members);
		}catch(Exception e){
			log.error("Exception occur while load csv : {}",e);
		}
	}


	Member getMemberObject(String[] tokens){
		log.info("member Id is : {}",tokens[ClubConstant.MEMBER_ID]);
		return new Member(ClubUtil.parseIntoInteger(tokens[ClubConstant.MEMBER_ID]),
				ClubUtil.parseIntoDouble(tokens[ClubConstant.MEMBER_LOAN_AMNT]),
				ClubUtil.parseIntoDouble(tokens[ClubConstant.MEMBER_FUNDED_AMNT_INV]),
				tokens[ClubConstant.MEMBER_TERM],
				ClubUtil.parseIntoFloat(tokens[ClubConstant.MEMBER_INT_RATE]),
				ClubUtil.parseIntoFloat(tokens[ClubConstant.MEMBER_INSTALLMENT]),
				tokens[ClubConstant.MEMBER_GRADE],
				tokens[ClubConstant.MEMBER_EMP_TITLE],tokens[ClubConstant.MEMBER_EMP_LENGTH],
				tokens[ClubConstant.MEMBER_HOME_OWNERSHIP],
				ClubUtil.parseIntoDouble(tokens[ClubConstant.MEMBER_ANNUAL_INC]),
				tokens[ClubConstant.MEMBER_VERIFICATION_STATUS],
				tokens[ClubConstant.MEMBER_ISSUE_D],
				tokens[ClubConstant.MEMBER_LOAD_STATUS],
				tokens[ClubConstant.MEMBER_DESC]);
	}

	void printListData(List<Member> members){
	
		members.stream().forEach(st -> log.info(""+st));
	
	}
}
