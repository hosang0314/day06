package com.user;

import java.sql.Connection;
import java.util.ArrayList;

import com.frame.Biz;
import com.item.ItemDao;
import com.vo.Item;
import com.vo.User;

public class UserBiz extends Biz<User, String> {
	
	ItemDao itemDao;
	//UserItemDao userItemDao;
	UserDao userDao;
	
	public UserBiz() {
		dao = new UserDao();	
		itemDao = new ItemDao();
		//userItemDao = new UserItemDao();
		userDao = new UserDao();
	}
	
	@Override
	public void register(User o) throws Exception {
		Connection conn = getConnection();
		try {
			// 1. 사용자 정보가 들어온다.
			int grade = o.getGrade();
			// 2. 아이템정보 조회
			Item item = itemDao.selectGrade(grade,conn);
			// 3. 사용자 정보를 입력
			userDao.insert(o, conn);
			// 4. 사용자 아이템을 입력
			o.setItem(item);
			o.setItemCount(1);
			userDao.insertUserItem(o, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}
		
	}

	@Override
	public void remove(String i) throws Exception {
		Connection conn = getConnection();
		try {
			// 사용자 ID 입력 받는다.
			// 사용자 아이템 삭제
			userDao.deleteUserItem(i, conn);
			// 사용자 삭제
			userDao.delete(i, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}		
	}

	@Override
	public void modify(User o) throws Exception {
		Connection conn = getConnection();
		try {
			dao.update(o, conn);
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw e;
		} finally {
			close(conn);
		}	
		
	}

	@Override
	public User get(String i) throws Exception {
		Connection conn = getConnection();
		User user = null;
		try {
//			- 사용자의 ID를 입력 받는다.
//			- 해당하는 사용자 정보를 조회한다
			user = userDao.select(i, conn);
//			- 사용자 ID로 User(ITEM ID, COUNT)를 조회한다.
//			- 사용자의 COUNT를 Setting 한다.		
			user = userDao.setItem(user, conn);			
//			- 사용자 ITEM을 ITEM 테이블에서 조회한다.
			Item item = itemDao.select(user.getItem().getId(), conn);
//			- 사용자에 ITEM을 Setting 한다.
			user.setItem(item);
		} catch (Exception e) {
			throw e;
		} finally {
			close(conn);
		}
		
		return user;
	}

	@Override
	public ArrayList<User> get() throws Exception {
		Connection conn = getConnection();
		ArrayList<User> list = null;
		try {
			list = dao.select(conn);
			for(User u : list) {
				userDao.setItem(u, conn);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			close(conn);
		}
		return list;
	}

}
