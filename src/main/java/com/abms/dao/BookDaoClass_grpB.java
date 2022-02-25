package com.abms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abms.model.BookPojo;

public class BookDaoClass_grpB {
	//method issueBook
	public int issueBook(BookPojo bp) throws ClassNotFoundException, SQLException {
		{
			String INSERT_BOOK_SQL ="INSERT INTO Book" +
					"(Book_id, Title, Author,Price, Available) VALUES " +
					"(?,?,?,?,?);";
			int result = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");	
			try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "1234");
			PreparedStatement ps = connection.prepareStatement(INSERT_BOOK_SQL))
			{
				ps.setString(1, bp.getBookId());
				ps.setString(2, bp.getTitle());
				ps.setString(3, bp.getAuthor());
				ps.setFloat(4, bp.getPrice());
				ps.setString(5,bp.getAvailable());
				result = ps.executeUpdate();
			}
			return result;
		}
		
		//method 
	}
}