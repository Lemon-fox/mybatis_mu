package com.mybatis.po;

import java.util.List;

public class UserQueryVo {
	
	//用戶查詢條件，這裡一般假設一個User就已經夠了
	private User user;
	private List<Integer> ids;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	
	
	

}
