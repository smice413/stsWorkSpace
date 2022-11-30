package sample13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/sample13/beans13.xml");
		ProductService ps = ac.getBean(ProductService.class); //bean이 따로 없기 때문에 서비스객체를 써줘야한다.
		Product product = ps.getProduct();
		System.out.println(product);
	}
}