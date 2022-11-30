 package sample03;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Ex01 {
	public static void main(String[] args) {
		 BeanFactory bf = new XmlBeanFactory(new FileSystemResource("beans01.xml")); //xml파일을 읽어노는 방식 1
//		ApplicationContext bf = new FileSystemXmlApplicationContext("beans01.xml"); //xml파일을 읽어노는 방식 2
		 //resuources폴더에 beans01.xml파일이 있으면 "classpath:beans01.xml"로 작성해야함
		 
		// MessageBean mb = bf.getBean("mb", MessageBean.class);
		MessageBean mb = (MessageBean) bf.getBean("mb"); // 다운케스팅 (xml에서 가져온 mb가 object형임)
		// MessageBean mb = bf.getBean(MessageBean.class);
		// MessageBean mb = (MessageBean)bf.getBean("a");
		mb.sayHello("Spring");
	}
}