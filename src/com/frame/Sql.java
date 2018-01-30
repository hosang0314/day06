package com.frame;

public class Sql {
	// static : 변경이 되지 않고 동시에 여러클래스에서 사용할수 있는 변수일때 사용
	public static String insertUser = "INSERT INTO T_USER VALUES (?,?,?,?)";
	public static String updateUser = "UPDATE T_USER SET PWD =? , NAME = ?, GRADE = ? WHERE ID = ?";
	public static String deleteUser = "DELETE FROM T_USER WHERE ID = ?";
	public static String selectAllUser = "SELECT * FROM T_USER";
	public static String selectUser = selectAllUser+" WHERE ID = ?";
	
	public static String insertitem = "INSERT INTO T_ITEM VALUES (?,?,?,?)";
	public static String updateitem = "UPDATE T_ITEM "
	         + " SET NAME = ?, GRADE = ?, PRICE = ? "
	         + " WHERE ID = ?";
	public static String deleteitem = "DELETE FROM T_ITEM WHERE ID = ?";
    public static String selectAllitem = "SELECT * FROM T_ITEM"
	         + " ORDER BY ID";
    public static String selectitem = "SELECT * FROM T_ITEM"
	         + " WHERE id = ?";
    public static String selectgradeitem = "SELECT * FROM T_ITEM"
	         + " WHERE grade = ?";
	
	public static String insertUseritem = "INSERT INTO T_USERITEM VALUES (?,?,?)";
	public static String updateUseritem = "UPDATE T_USERITEM "
	         + " SET ITEMID = ?, COUNT = ? "
	         + " WHERE USERID = ?";
	public static String deleteUseritem = "DELETE FROM T_USERITEM WHERE USERID = ?";
    public static String selectAllUseritem = "SELECT * FROM T_USERITEM"
	         + " ORDER BY USERID";
    public static String selectUseritem = "SELECT * FROM T_USERITEM"
	         + " WHERE USERID = ?";
	
}
