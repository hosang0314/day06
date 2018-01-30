package com.vo;

public class UserItem {
	private String userid;
	private int itemid;
	private int count;
	
	public UserItem() {
		// TODO Auto-generated constructor stub
	}

	public UserItem(String userid, int itemid, int count) {
		this.userid = userid;
		this.itemid = itemid;
		this.count = count;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserItem [userid=").append(userid).append(", itemid=").append(itemid).append(", count=")
				.append(count).append("]");
		return builder.toString();
	}
	
	
}
