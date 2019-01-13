package com.linxiaomi.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTaskApplicationTests {

	@Autowired
	JavaMailSenderImpl javaMailSender;

	@Test
	public void contextLoads() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setSubject("通知-今晚开会");
		simpleMailMessage.setText("今晚七点开会");
		simpleMailMessage.setTo("zh71963129@sina.com");
		simpleMailMessage.setFrom("zhlinxiaomi@qq.com");
		javaMailSender.send(simpleMailMessage);
	}

	@Test
	public void test01() throws MessagingException {
		// 创建一个复杂的消息附件
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		// 邮件设置
		mimeMessageHelper.setSubject("通知-今晚开会");
		mimeMessageHelper.setText("<b style='color:red'>今晚七点半开会</b>");
		mimeMessageHelper.setTo("zh71963129@sina.com");
		mimeMessageHelper.setFrom("zhlinxiaomi@qq.com");
		// 上传文件
		mimeMessageHelper.addAttachment("1.jpg", new File("C:\\Users\\Administrator\\Pictures\\QQ浏览器截图\\QQ浏览器截图20180930212416.png"));
		mimeMessageHelper.addAttachment("2.jpg", new File("C:\\Users\\Administrator\\Pictures\\QQ浏览器截图\\QQ浏览器截图20180930212416.png"));
		javaMailSender.send(mimeMessage);
	}

}

