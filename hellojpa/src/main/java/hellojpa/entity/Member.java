package hellojpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Member {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.AUTO) 방언에 따라서 알아서 설정해줌
	private Long id;
	
	@Column(name = "USERNAME", nullable=false, length= 20) //필드가 name이지만 DB칼럼은 username일때.
	// nullable=false DB랑 맵핑할때 not null 제약조건이면 쓰면됨.
	// length = 20  글자 길이 20글자까지 제한
	private String name;
	private int age;
	
	@Temporal(TemporalType.TIMESTAMP) // 시간관련
	private Date regDate;
	
	@Enumerated(EnumType.STRING)// 무조건 String으로 써라
	//private MemberType membertype //user, admin
	
	//@Lob : 컨텐츠길이가 길때 씀. String타입이면 CLOB, byte타입이면 BLOB
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
