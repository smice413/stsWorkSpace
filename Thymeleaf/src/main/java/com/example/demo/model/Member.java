package com.example.demo.model;

import java.sql.Timestamp;

public class Member {
	private int no;
	private String id;
	private String pw;
	private String name;
	private Timestamp regdate;
	
	public Member(int no, String id, String pw, String name, Timestamp regdate) {
		this.no = no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.regdate = regdate;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}	
}
