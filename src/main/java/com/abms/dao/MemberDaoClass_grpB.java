package com.abms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abms.model.MemberPojo;

public class MemberDaoClass_grpB {
	public int membereg(MemberPojo mp) throws ClassNotFoundException, SQLException {
		{
			String INSERT_MEMBER_SQL ="INSERT INTO Member" +
					"(Memb_id, Memb_name, Address, Memb_type, Memb_date, Expiry_date) VALUES " +
					"(?,?,?,?,?,?);";
			int result = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");	
			try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "sathish@1234");
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

}
