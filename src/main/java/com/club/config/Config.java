package com.club.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;


@Configuration
public class Config {

	public static Logger logger = LoggerFactory.getLogger(Config.class);

	public Config(){
		logger.info("config bean created");
	}
	/**
	 * Bean for getting the handle of SessionFactory for
	 * Manually Creating Hibernate Session if needed.
	 * @return
	 */
	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		logger.info("Creating hibernate Session factoy");

		HibernateJpaSessionFactoryBean hibernateJpaSessionFactoryBean = null;
		try{
			hibernateJpaSessionFactoryBean = new HibernateJpaSessionFactoryBean();
		}catch(Exception e){
			logger.info("Exception occure while create HibernateJpaSessionFactoryBean : "+e);
		}
		logger.info("HibernateJpaSessionFactoryBean created succesfully.");
		return hibernateJpaSessionFactoryBean;
	}
}
