package controller;

import java.util.Random;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailTest {

	@RequestMapping("/send.do")
	public String send(Model model) {

		Random random = new Random();
		int a = random.nextInt(100); //0~99까지 난수 발생. 난수값을 비번(인증번호)으로 보냄

		// Mail Server 설정
		String charSet = "utf-8";
		String hostSMTP = "smtp.gmail.com";
		String hostSMTPid = "gcmarket99@gmail.com";
		String hostSMTPpwd = "rhkcoakzpt99"; 	// 네이버 Email 비밀번호 입력해야함

		// 보내는 사람 EMail, 제목, 내용
		String fromEmail = "gcmarket99@gmail.com";
		String fromName = "친절한 홍길동씨";
		String subject = "Overflow인증메일입니다.";

		// 받는 사람 E-Mail 주소
		String mail = "sung-ho413@hanmail.net";

		try {
			HtmlEmail email = new HtmlEmail(); //HtmlEmail: Email 라이브러리 import
			email.setDebug(true);
			email.setCharset(charSet);
			email.setSSL(true); //보안프로토콜로 true면 프로토콜 사용하겠다는 의미
			email.setHostName(hostSMTP);
			email.setSmtpPort(465); //네이버의 SMTOPORT번호를 알아야함

			email.setAuthentication(hostSMTPid, hostSMTPpwd); //id와 비번이 일치해야 인증받아서 메일이 보내짐
			email.setTLS(true);
			email.addTo(mail, charSet); //addTo는 받는 사람으로 받는 사람 email를 설정해야함
			email.setFrom(fromEmail, fromName, charSet); //setForm 보내는 사람 정보설정
			email.setSubject(subject); // setSubject는 subject변수에 저장된 내용을 보내줌
			email.setHtmlMsg("<p align = 'center'>Overflow에 오신것을 환영합니다.</p><br>" 
							 + "<div align='center'> 인증번호 : " + a + "</div>");
			email.send(); //.send()를 쓰면 메일이 전송됨
		} catch (Exception e) {
			System.out.println(e);
		}		
		model.addAttribute("result", "good~!!\n 등록된 E-Mail 확인");

		return "result";
	}
}
