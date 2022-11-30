package com.example.demo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;


// root-configuration 역할함.
@Configuration 
@PropertySource("classpath:/application.properties")          
public class DataAccessConfig {
	
	@ConfigurationProperties(prefix = "spring.datasource")   //prefix는  application.properties 안에 있는 oracle 연결 이름값으로 똑같이 맞춘것
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
		
		factoryBean.setDataSource(dataSource); //db연동하는 코드
		factoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml")
				);
		factoryBean.setTypeAliasesPackage("com.example.demo.model"); // DTO Alias 설정. DTO클래스 페키지까지만 경로를 넣어야한다. 그래야 어노테이션으로 적용가능함.
		return factoryBean.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory); //매개변수로 받은 것을 생성자의 매개변수로 값을 주입
	}
}
