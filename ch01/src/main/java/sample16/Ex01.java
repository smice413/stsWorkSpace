package sample16;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01 {
	static MemberService ms = null;

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/sample16/beans16.xml");
		ms = (MemberService) ac.getBean("ms");
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("명령어를 입력하세요?");
			String command = sc.nextLine(); // 사용자가 입력한 한줄 값이 command에 저장
			if (command.equals("x")) {
				System.out.println("프로그램 종료");
				break;
			//startsWith() 메소드는 캐릭터 라인이, 지정된 접두사로 시작 여부를 감지하는 데 사용
			// public boolean startsWith(String prefix)
			} else if (command.startsWith("new")) {  // 입력한 문자가 new로 시작하면 true 리턴함
				insert(command.split(" ")); //split 함수로 공백으로 파싱하여 1차원 배열로 값을 리턴함.
				continue;
			} else if (command.startsWith("select")) {
				select(command.split(" "));
				continue;
			} else if (command.equals("list")) {
				list();
				continue;
			} else if (command.startsWith("delete")) {
				delete(command.split(" "));
				continue;
			} else if (command.startsWith("update")) {
				update(command.split(" "));
				continue;
			}
			help();
		}
		sc.close();
	}
	
	// 회원 가입
	public static void insert(String[] str) {
		if (str.length != 5) {
			help();
			return;
		}
		RegisterMember rm = new RegisterMember();
		rm.setEmail(str[1]);
		rm.setName(str[2]);
		rm.setPass(str[3]);
		rm.setConfirmPass(str[4]);
		
		if (!rm.passCheck()) {
			System.out.println("똑바로 암호 입력해");
		} else {
			int result = ms.insert(rm); //1을 돌려받음
			if (result > 0)
				System.out.println("입력 성공");
		}
	}
	
	// 1명의 회원 검색
	public static void select(String[] str) {
		if (str.length != 2) {
			help();
			return;
		}
		Member member = ms.select(str[1]);
		if (member != null)
			System.out.println(member);
		else
			System.out.println("없는 데이터 입니다");
	}
	
	// 전체 회원 목록 검색
	public static void list() {
		Collection<Member> list = ms.list();
		if (list != null) {
			for (Member member : list) {
				System.out.println(member);
			}
		}
	}
	// 회원 정보 삭제
	public static void delete(String[] str) {
		if (str.length != 2) {
			help();
			return;
		}
		int result = ms.delete(str[1]);		//회원 정보 삭제
		if (result > 0)
			System.out.println("삭제 성공");
	}
	
	// 회원 정보 수정
	public static void update(String[] str) {
		if (str.length != 5) {
			help();
			return;
		}
		RegisterMember rm = new RegisterMember();
		rm.setPass(str[3]);
		rm.setConfirmPass(str[4]);
		rm.setEmail(str[1]);
		rm.setName(str[2]);
		if (!rm.passCheck()) {
			System.out.println("똑바로 암호 입력해");
		} else {
			int result = ms.update(rm);
			if (result > 0)
				System.out.println("수정 성공");
		}
	}

	public static void help() {
		System.out.println("잘못 입력했습니다");
		System.out.println("명령어 사용법:");
		System.out.println("new 이메일 이름 암호 암호확인");
		System.out.println("update 이메일 이름 암호 암호확인");
		System.out.println("delete 이메일");
		System.out.println("select 이메일");
		System.out.println();
	}
}