package org.iclass.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NewMember {			
	private String id;
	private String name;
	private String password;
	private String email;
	private int age;
	
}
