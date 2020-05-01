package study.spring.myapp.member.controller;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import study.spring.myapp.member.Member;
import study.spring.myapp.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);
		
		return dateFormat.format(date);
	}
	
	
	@RequestMapping(value="/member/memJoin",method=RequestMethod.POST)
	public String memJoin(Member member) {
		service.insert(member);
		return "memJoinOk";
	}
	
	@RequestMapping(value="/member/memLogin",method=RequestMethod.POST)
	public String memLogin(Model model,Member member) {
		Member user = service.search(member);
		try {
			model.addAttribute("memId", user.getId());
			model.addAttribute("memPw", user.getPw());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "memLoginOk";
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
