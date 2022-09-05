package com.home.controller;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.home.model.MailInfo;
import com.home.service.MailerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("home")

public class HomeController {
 @Autowired
 JavaMailSender sender;
 @Autowired
 MailerService mailerService;
	
	@GetMapping("")
	public String home() {
		return "index";
	}
	@ResponseBody
	@RequestMapping("/mail/send")
	public String send(Model model, 
			@RequestParam String txtTo,
			@RequestParam String txtSubject,
			@RequestParam String txtContent) {
			
		try {
			MailInfo mail = new MailInfo();
			mail.setTo(txtTo);
			mail.setSubject(txtSubject);
			mail.setBody(txtContent);
			mailerService.send(mail);
			return "<h1>Gửi mail thành công</h1>";
		} catch (Exception e) {
			return "<h1>Gửi mail thất bại</h1>" + e;
		}
		
	}
}

