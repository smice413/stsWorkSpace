package sample16;

import java.util.*;

public class MemberDaoImpl implements MemberDao {
	private Map<String, Member> map = new HashMap<String, Member>();
	private static int nextId = 0;
	
	
	// 회원가입
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member); // map에 저장할 때 .put(key값, value값)메소드로 저장
	}
	// Email 주소 중복 검사
	public Member selectByEmail(String email) {
		return map.get(email); // get함수에 키캆을 넣어 member(value)값을 구해옴
	}
	// 전체 회원 목록
	public Collection<Member> list() {
		return (Collection<Member>) map.values();
	}
	// 회원 삭제
	public void delete(String email) {
		map.remove(email);
	}
	// 회원 정보 수정
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
}