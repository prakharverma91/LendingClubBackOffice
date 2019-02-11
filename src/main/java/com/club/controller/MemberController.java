package com.club.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.club.service.MemberService;
import com.club.util.ResponseUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="MemberController",description="Operation related to member")
@RestController
public class MemberController {

	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;

	@ApiOperation(value = "Activity for fetch members, pass 0 in pageNo and pageSize if you want to fetch all records, other wise pass greater than zero value in pageNo and pageSize")
	@GetMapping(value="/members",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getMembersBySearchParameter(@Valid @ModelAttribute MemberWrapper memberWrapper,BindingResult bindingResult){

		log.info("inside the get members by serch paramter API");

		if(bindingResult.hasErrors())
			return ResponseUtil.fieldErrorResponse("Query params value is not valid",ResponseUtil.getFieldErrorResponse(bindingResult));   


		if(memberWrapper.getPageNo().equals(0) || memberWrapper.getPageSize().equals(0)){
			return ResponseUtil.response(null, "pageNo and PageSize should be greater than zero");
		}
		
		boolean isPagination = true;

		if(memberWrapper.getPageNo().equals(0) && memberWrapper.getPageSize().equals(0)){
			log.info("Inside the case of get all members of without pagination");
			isPagination = false;
		}

		Map<String,Object> response = null;
	
		try{
			response = memberService.getMembersByDynamicSearchQuery(memberWrapper,isPagination ? true : false,memberWrapper.getPageNo() <= 0 ? 0 : memberWrapper.getPageNo()-1,memberWrapper.getPageSize());
			response.put("pageNo", memberWrapper.getPageNo());
			response.put("pageSize",memberWrapper.getPageSize());

		}catch(Exception e){
			log.error("Exception occur while fetch filtered members : {}",e);
			return ResponseUtil.errorResponse("Members not fetched", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseUtil.response(response, "Members fetched successfully");

	}

}
