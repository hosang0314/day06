package com.user.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.user.UserBiz;
import com.vo.User;

class UserSelectBizTest {

	@Test
	void testGetString() {
		UserBiz biz = new UserBiz();
		User user = null;
		try {
			user = biz.get("id01");
			System.out.println(user);
			System.out.println(user.getItem());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
