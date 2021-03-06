package com.abms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abms.model.MemberPojo;

public class MemberDaoClass_grpB {
	public int membeReg(MemberPojo mp) throws ClassNotFoundException, SQLException {
		// Method membereg() - Database logic is to add a member to the database.
		{
			String INSERT_MEMBER_SQL ="INSERT INTO Member" +
					"(Memb_id, Memb_name, Address, Memb_type, Memb_date, Expiry_date) VALUES " +
					"(?,?,?,?,?,?);";
			int result = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");	
			try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "happiness");
			PreparedStatement ps = connection.prepareStatement(INSERT_MEMBER_SQL))
			{
				ps.setString(1, mp.getMemb_id());
				ps.setString(2, mp.getMemb_name());
				ps.setString(3, mp.getAddress());
				ps.setString(4, mp.getMemb_type());
				ps.setString(5,mp.getMemb_date());
				ps.setString(6,mp.getExpiry_date());
				result = ps.executeUpdate();
			}
			
			return result;
			
		}		
			
	}
	public int membUpdate(MemberPojo mm) throws ClassNotFoundException, SQLException {
		// Method membupdate() - Database logic is to update a member to the database.
		{
			String UPDATE_MEMBER_SQL ="UPDATE Member "
					+ "SET Memb_name=?, Address=?, Memb_type=?, Memb_date=?, Expiry_date=? "
					+ "WHERE Memb_id=?";
			int result = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");	
			try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "happiness");
			PreparedStatement ps = connection.prepareStatement(UPDATE_MEMBER_SQL))
			{
				ps.setString(1, mm.getMemb_name());
				ps.setString(2, mm.getAddress());
				ps.setString(3, mm.getMemb_type());
				ps.setString(4,mm.getMemb_date());
				ps.setString(5,mm.getExpiry_date());
				ps.setString(6, mm.getMemb_id());
				result = ps.executeUpdate();
			}			
			return result;			
		}		
			
	}
	public int membDelete(MemberPojo mm) throws ClassNotFoundException, SQLException {
		// Method membdelete() - Database logic is to delete a member from the database.
		{
			String DELETE_MEMBER_SQL ="DELETE FROM Member WHERE Memb_id=?";
			int result = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");	
			try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "happiness");
			PreparedStatement ps = connection.prepareStatement(DELETE_MEMBER_SQL))
			{
				ps.setString(1, mm.getMemb_id());
				result = ps.executeUpdate();
				System.out.println(result);
			}
			
			return result;
			
		}		
			
	}	
	

}
