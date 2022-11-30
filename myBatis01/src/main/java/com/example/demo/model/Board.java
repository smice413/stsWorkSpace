package com.example.demo.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Alias("board") //mybatis-config.xml에서 설정한 alias는 적용안됨. 어노테이션을 DTO에서 썼기 때문
public class Board {
	private int no;
	private String name;
	private String subject;
	private String content;
	private Date register;
	
//	public int getNo() {
//		return no;
//	}
//	public void setNo(int no) {
//		this.no = no;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getSubject() {
//		return subject;
//	}
//	public void setSubject(String subject) {
//		this.subject = subject;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public Date getRegister() {
//		return register;
//	}
//	public void setRegister(Date register) {
//		this.register = register;
//	}	
}
