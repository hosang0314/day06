package com.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.Item;
import com.vo.User;
import com.vo.UserItem;

public class UserDao extends Dao<User, String> {

	public User setItem(User o, Connection conn) throws Exception {
		// User(o) 객체에
		// ITEMID와 COUNT를 Setting한다.
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;;
		
		Item item = new Item();
		try {
			pstmt = conn.prepareStatement(Sql.selectUseritem);
			pstmt.setString(1, o.getId());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				int itemid = rset.getInt("ITEMID");
				int count = rset.getInt("Count");
				
				item.setId(itemid);
				o.setItemCount(count);
				o.setItem(item);
			} 				

		} catch (Exception e) {
			throw e;
		} finally {
			if (rset != null)
				close(rset);
			if (pstmt != null)
				close(pstmt);
		}
		return o;
	}

	public void insertUserItem(User o, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertUseritem);
			pstmt.setString(1, o.getId());
			pstmt.setInt(2, o.getItem().getId());
			pstmt.setInt(3, o.getItemCount());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}

	public void deleteUserItem(String id, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteUseritem);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}

	@Override
	public void insert(User o, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertUser);
			pstmt.setString(1, o.getId());
			pstmt.setString(2, o.getPwd());
			pstmt.setString(3, o.getName());
			pstmt.setInt(4, o.getGrade());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public void delete(String i, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteUser);
			pstmt.setString(1, i);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public void update(User o, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.updateUser);
			pstmt.setString(1, o.getPwd());
			pstmt.setString(2, o.getName());
			pstmt.setInt(3, o.getGrade());
			pstmt.setString(4, o.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public User select(String i, Connection conn) throws Exception {
		User user = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectUser);
			pstmt.setString(1, i);
			rset = pstmt.executeQuery();
			rset.next();
			String id = rset.getString("id");
			String pwd = rset.getString("pwd");
			String name = rset.getString("name");
			int grade = rset.getInt("grade");
			user = new User(id, pwd, name, grade);
		} catch (Exception e) {
			throw e;
		} finally {
			if (rset != null)
				close(rset);
			if (pstmt != null)
				close(pstmt);
		}
		return user;
	}

	@Override
	public ArrayList<User> select(Connection conn) throws Exception {
		ArrayList<User> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectAllUser);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				User user = null;
				String id = rset.getString("id");
				String pwd = rset.getString("pwd");
				String name = rset.getString("name");
				int grade = rset.getInt("grade");
				user = new User(id, pwd, name, grade);
				list.add(user);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (rset != null)
				close(rset);
			if (pstmt != null)
				close(pstmt);
		}
		return list;
	}

}
