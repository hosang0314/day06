package com.user.test;

import org.junit.jupiter.api.Test;

import com.user.UserBiz;
import com.vo.User;

class UserRegisterBizTest {

	@Test
	void testRegisterUser() {
		UserBiz biz =  new UserBiz();
		User user = new User("id50", "pwd30", "��浿", 2);
		
		try {
			biz.register(user);
			System.out.println("�Է� �Ϸ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
