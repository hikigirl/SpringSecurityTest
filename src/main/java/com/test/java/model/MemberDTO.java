package com.test.java.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class MemberDTO {
	private String memberid;
	private String memberpw;
	private String membername;
	private String email;
	private String gender;
	private String enabled;
	private String regdate;
}
