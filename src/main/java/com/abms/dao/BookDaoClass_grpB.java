package com.abms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.abms.model.BookPojo;

public class BookDaoClass_grpB {
	// method issueBook
	public int addBook(BookPojo bp) throws ClassNotFoundException, SQLException {
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
	}
		
		public int updateBook(BookPojo bp) throws ClassNotFoundException, SQLException {
			{
				String UPDATE_BOOK_SQL ="UPDATE Book "
						+ "SET Title=?, Author=?, Price=?, Available=?"
						+ "WHERE Book_id=?";
				int result = 0;
				Class.forName("com.mysql.cj.jdbc.Driver");	
				try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "1234");
				PreparedStatement ps = connection.prepareStatement(UPDATE_BOOK_SQL))
				{
					
					ps.setString(1, bp.getTitle());
					ps.setString(2, bp.getAuthor());
					ps.setFloat(3, bp.getPrice());
					ps.setString(4, bp.getAvailable());
					ps.setString(5, bp.getBookId());
					result = ps.executeUpdate();
				}			
				return result;			
			}		
		
		}
		public int deleteBook(BookPojo bp) throws ClassNotFoundException, SQLException {
			{
				String DELETE_BOOK_SQL ="DELETE FROM Book WHERE Book_id=?";
				int result = 0;
				Class.forName("com.mysql.cj.jdbc.Driver");	
				try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "1234");
				PreparedStatement ps = connection.prepareStatement(DELETE_BOOK_SQL))
				{
					ps.setString(1, bp.getBookId());
					result = ps.executeUpdate();
					System.out.println(result);
				}
				return result;
			}		
		}	
}