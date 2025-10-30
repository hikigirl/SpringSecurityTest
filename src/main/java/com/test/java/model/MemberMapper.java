package com.test.java.model;

public interface MemberMapper {

	void add(MemberDTO dto);

	void addAuth(AuthDTO adto);

	MemberDTO get(String username);

}
