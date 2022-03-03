package com.abms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abms.model.PublisherPojo;

public class PublisherDaoClass_grpB {
	public int addPublisher(PublisherPojo pp) throws ClassNotFoundException, SQLException {
		// Method addPublisher() - Database logic is to add a Publisher to the database.
		{
			String INSERT_PUBLISHER_SQL ="INSERT INTO Publisher" +
					"(Pub_id, Address, Pub_Name) VALUES " +
					"(?,?,?);";
			int result = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");	
			try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "happiness");
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
	
	public int updatePublisher(PublisherPojo pp) throws ClassNotFoundException, SQLException {
		// Method updatePublisher() - Database logic is to update a member to the database.
		{
			String UPDATE_PUBLISHER_SQL = "UPDATE Publisher "
					+ "SET Address=?, Pub_Name=? "
					+ "WHERE Pub_id=?";
			int result = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");	
			try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "happiness");
			PreparedStatement ps = connection.prepareStatement(UPDATE_PUBLISHER_SQL))
			{
				ps.setString(1, pp.getAddress());
				ps.setString(2, pp.getPub_Name());
				ps.setString(3, pp.getPub_id());
				result = ps.executeUpdate();
			}
			return result;
		}		
			
	}
}