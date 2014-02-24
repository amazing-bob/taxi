package com.taxi.services.comment;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.taxi.util.mail.MailHandler;
import com.taxi.util.mail.impl.SecureMailHandler;



@Service
public class CommentServiceImpl implements CommentService {

	@Transactional(
			propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public int commentSend(int mbrNo, String comment) throws Exception {
		try {
			MailHandler mail = new SecureMailHandler("eger.eventmanager@gmail.com", "qlxmwkqk41rl"); // 보내는 이메일 계정 ID, PWD
			mail.setMailServer("smtp.gmail.com"); // 메일서버 설정
			mail.setSender("userMail"); // 보내는 사람 이메일(안적어도 되는듯)
			mail.setSenderName("" + mbrNo); // 보내는 회원 번호
			mail.setReceiver("buru1020@gmail.com"); // 운영자 이메일
			mail.setSubject("userEmail" + "회원님의 문의사항입니다."); // 메일제목
			mail.setContent(comment); // 내용
			mail.SendMail(); // 보내기
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			throw e;
		}
		return 1;
	}
	
}
