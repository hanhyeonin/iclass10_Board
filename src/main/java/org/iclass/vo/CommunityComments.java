package org.iclass.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CommunityComments {
	private int idx;
	private long mref;
	private String writer;
	private String content;
	private Timestamp createdAt;
	private String ip;
	private int heart;
}
