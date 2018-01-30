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
			// 1. ����� ������ ���´�.
			int grade = o.getGrade();
			// 2. ���������� ��ȸ
			Item item = itemDao.selectGrade(grade,conn);
			// 3. ����� ������ �Է�
			userDao.insert(o, conn);
			// 4. ����� �������� �Է�
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
			// ����� ID �Է� �޴´�.
			// ����� ������ ����
			userDao.deleteUserItem(i, conn);
			// ����� ����
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
//			- ������� ID�� �Է� �޴´�.
//			- �ش��ϴ� ����� ������ ��ȸ�Ѵ�
			user = userDao.select(i, conn);
//			- ����� ID�� User(ITEM ID, COUNT)�� ��ȸ�Ѵ�.
//			- ������� COUNT�� Setting �Ѵ�.		
			user = userDao.setItem(user, conn);			
//			- ����� ITEM�� ITEM ���̺��� ��ȸ�Ѵ�.
			Item item = itemDao.select(user.getItem().getId(), conn);
//			- ����ڿ� ITEM�� Setting �Ѵ�.
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
