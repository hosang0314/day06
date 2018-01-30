package com.useritem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.User;
import com.vo.UserItem;

public class UserItemDao extends Dao<User, String> {

	@Override
	public void insert(User o, Connection conn) throws Exception {
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

	@Override
	public void delete(String i, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteUseritem);
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
		// TODO Auto-generated method stub

	}

	@Override
	public User select(String i, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		UserItem useritem = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectUseritem);
			pstmt.setString(1, i);
			rset = pstmt.executeQuery();
			rset.next();
			String userid = rset.getString("userid");
			int itemid = rset.getInt("itemid");
			int count = rset.getInt("count");
			useritem = new UserItem(userid, itemid, count);
		} catch (Exception e) {
			throw e;
		} finally {
			if(rset!=null) close(rset);
			if(pstmt!=null) close(pstmt);
		}
		return null;
	}

	@Override
	public ArrayList<User> select(Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		ArrayList<User> list = new ArrayList<>();
		ArrayList<UserItem> list2 = new ArrayList<>();
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectAllUseritem);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				UserItem useritem = null;
				String userid = useritem.getUserid();
				int itemid = useritem.getItemid();
				int count = useritem.getCount();
				useritem = new UserItem(userid, itemid, count);
				list2.add(useritem);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if(rset!=null) close(rset);
			if(pstmt!=null) close(pstmt);
		}
		return list;
	}

}
