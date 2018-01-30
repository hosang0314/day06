package com.user.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.user.UserBiz;
import com.vo.User;

class UserSelectAllBizTest {

	@Test
	void testGet() {
		UserBiz biz = new UserBiz();
		ArrayList<User> list = new ArrayList<>();
		try {
			list = biz.get();
			for(User u : list) {
				System.out.println(u);
				System.out.println(u.getItem());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
