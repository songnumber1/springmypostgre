package com.my.storage.vo;

import lombok.Builder;

@Builder
public class userVO {

	private String in_user_seq;
	
	private String return_data;

	public String getIn_user_seq() {
		return in_user_seq;
	}

	public void setIn_user_seq(String in_user_seq) {
		this.in_user_seq = in_user_seq;
	}

	public String getReturn_data() {
		return return_data;
	}

	public void setReturn_data(String return_data) {
		this.return_data = return_data;
	}	
}
