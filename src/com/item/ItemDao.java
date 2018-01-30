package com.item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.frame.Dao;
import com.frame.Sql;
import com.vo.Item;

public class ItemDao extends Dao<Item, Integer> {

	public Item selectGrade(Integer i, Connection conn) throws Exception {
		Item item = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectgradeitem);
			pstmt.setInt(1, i);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				int id = rset.getInt("id");
				String name = rset.getString("name");
				int grade = rset.getInt("grade");
				int price = rset.getInt("price");
				item = new Item(id, name, grade, price);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if(rset!=null) close(rset);
			if(pstmt!=null) close(pstmt);
		}
		return item;
	}

	@Override
	public void insert(Item o, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.insertitem);
			pstmt.setInt(1, o.getId());
			pstmt.setString(2, o.getName());
			pstmt.setInt(3, o.getGrade());
			pstmt.setInt(4, o.getPrice());
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
	}

	@Override
	public void delete(Integer i, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(Sql.deleteitem);
			pstmt.setInt(1, i);
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}

	}

	@Override
	public void update(Item o, Connection conn) throws Exception {

	}

	@Override
	public Item select(Integer i, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		Item item = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectitem);
			pstmt.setInt(1, i);
			rset = pstmt.executeQuery();
			rset.next();
			int id = rset.getInt("id");
			String name = rset.getString("name");
			int grade = rset.getInt("grade");
			int price = rset.getInt("price");
			item = new Item(id, name, grade, price);
		} catch (Exception e) {
			throw e;
		} finally {
			close(pstmt);
		}
		return item;
	}

	@Override
	public ArrayList<Item> select(Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		ArrayList<Item> list = new ArrayList<>();
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(Sql.selectAllitem);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Item item = null;
				int id = rset.getInt("id");
				String name = rset.getString("name");
				int grade = rset.getInt("grade");
				int price = rset.getInt("price");
				item = new Item(id, name, grade, price);
				list.add(item);
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
