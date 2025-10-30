package com.test.java.model;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

//회원정보 객체 - 기존의 User 대신 사용
@Getter
public class CustomUser extends User{
	
	private MemberDTO mdto;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUser(MemberDTO dto) {
		//List<AuthDTO> -> 매핑 -> List<String>
		
		super(
			dto.getMemberid(),
			dto.getMemberpw(), 
			dto.getAuthList().stream().map(adto -> 
			new SimpleGrantedAuthority(adto.getAuth())).collect(Collectors.toList())
		);
		
		this.mdto = dto;
	}
}
