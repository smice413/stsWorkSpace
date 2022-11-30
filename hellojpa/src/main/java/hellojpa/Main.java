package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import hellojpa.entity.Member;

public class Main {
	
	public static void main(String args[]) {
		
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("hello"); // 여기서 hello는 persistence.xml 파일의 persistence-unit name="hello"을 말함
		//웹앱 개발 할때 서버띄울 때  EntityManagerFactory를 딱 한번 꺼내야함.
		//여기서 EntityManager도 꺼내 쓸 수 있음
		
		
		//고객의 요청이 들어올때마다 createEntityManager()로 생성해서 쓰면됨.
		//그리고 쓰레드간에 공유는 하면 안되기 때문에 한번 쓰고 버리고 또 다시 factory에서 얻어야함.
		EntityManager em =emf.createEntityManager();
		EntityTransaction tx =em.getTransaction(); // 트렌젝션을 먼저 얻고 JPA시작해야함
		tx.begin(); // 트렌젝션 시작
		
		try {
			 Member member = new Member();
			 member.setId(100L);
			 member.setName("안녕하세요");
			 em.persist(member);//영구저장
			 tx.commit();// 커밋까지 해주면 됨.
			} catch (Exception e) {
			 tx.rollback(); //에러 났을 때 롤백해줌.
			} finally {
			 em.close(); //EntityManager 꼭 닫아야함
			}
			emf.close();//EntityManagerFactory까지 닫음

	}
}
