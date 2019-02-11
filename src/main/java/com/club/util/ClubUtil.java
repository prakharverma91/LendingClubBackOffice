package com.club.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.club.bootstrap.BootstrapConfig;

public class ClubUtil {

	private static final Logger log = LoggerFactory.getLogger(ClubUtil.class);

	public static Double parseIntoDouble(String input){

		try{
			return Double.parseDouble(input);

		}catch(Exception e){
			log.error("Exception occur while parse the value into double : {}",e);
			return null;
		}
	}
	
	public static Integer parseIntoInteger(String input){

		try{
			return Integer.parseInt(input);

		}catch(Exception e){
			log.error("Exception occur while parse the value into Integer : {}",e);
			return null;
		}
	}
	
	public static Float parseIntoFloat(String input){

		try{
			return Float.parseFloat(input);

		}catch(Exception e){
			log.error("Exception occur while parse the value into Float : {}",e);
			return null;
		}
	}
	
}
