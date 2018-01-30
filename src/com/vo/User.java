package com.vo;

public class User {
	private String id;
	private String pwd;
	private String name;
	private int grade;
	private Item item;
	private int itemCount;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String pwd, String name, int grade) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.grade = grade;
	}

	public User(String id, String pwd, String name, int grade, Item item) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.grade = grade;
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", pwd=").append(pwd).append(", name=").append(name)
				.append(", grade=").append(grade).append("]");
		return builder.toString();
	}
		
}
