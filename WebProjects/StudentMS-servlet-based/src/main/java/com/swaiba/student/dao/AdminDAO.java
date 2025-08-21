package com.swaiba.student.dao;
import java.sql.*;
import com.swaiba.student.db.DBConnection;
import com.swaiba.student.model.Admin;

public class AdminDAO {
public Admin validateAdmin(String username,String password) {
	Admin admin=null;
	String sql="Select * fROM admins WHERE username=? AND password=?";
	try (
		Connection con=DBConnection.getConnection();
		PreparedStatement pst= con.prepareStatement(sql)){
		pst.setString(1,username);
		pst.setString(1, password);
		try 
			(ResultSet rs=pst.executeQuery()){
			if(rs.next()) {
				admin=new Admin();
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				
			}
		}
	}
	catch(SQLException e) {
		e.printStackTrace();
	}
	return admin;
}
}
