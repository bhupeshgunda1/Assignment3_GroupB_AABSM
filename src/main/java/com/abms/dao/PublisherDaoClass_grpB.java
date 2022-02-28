package com.abms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abms.model.PublisherPojo;

public class PublisherDaoClass_grpB {
	public int pubreg(PublisherPojo pp) throws ClassNotFoundException, SQLException {
		{
			String INSERT_PUBLISHER_SQL ="INSERT INTO Publisher" +
					"(Pub_id, Address, Pub_Name) VALUES " +
					"(?,?,?);";
			int result = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");	
			try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "sathish@1234");
			PreparedStatement ps = connection.prepareStatement(INSERT_PUBLISHER_SQL))
			{
				ps.setString(1, pp.getPub_id());
				ps.setString(2, pp.getAddress());
				ps.setString(3, pp.getPub_Name());
				result = ps.executeUpdate();
			}
			
			return result;
			
		}		
			
	}

}
