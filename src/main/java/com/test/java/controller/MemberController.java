package com.test.java.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.java.model.AuthDTO;
import com.test.java.model.MemberDTO;
import com.test.java.model.MemberMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberMapper mapper;
	private final BCryptPasswordEncoder encoder;
	
	@GetMapping("/register.do")
	public String register() {
		return "register";
	}
	
	@PostMapping("/registerok.do")
	public String registerok(MemberDTO dto, String auth) {
		//사용자 입력 암호 -> 암호화 필요
		dto.setMemberpw(encoder.encode(dto.getMemberpw()));
		
		//회원정보 insert
		mapper.add(dto);
		
		//권한 정보 insert(권한 + ID)
		if(auth.equals("1") || auth.equals("2")) {
			//일반회원
			AuthDTO adto = new AuthDTO();
			adto.setMemberid(dto.getMemberid());
			adto.setAuth("ROLE_MEMBER");
			mapper.addAuth(adto);
			
		}
		
		if(auth.equals("2")) {
			//관리자
			AuthDTO adto = new AuthDTO();
			adto.setMemberid(dto.getMemberid());
			adto.setAuth("ROLE_ADMIN");
			mapper.addAuth(adto);
		}
		
		return "registerok";
	}
}
