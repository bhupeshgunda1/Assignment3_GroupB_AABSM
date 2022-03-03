package com.abms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.abms.model.BookPojo;

public class BookDaoClass_grpB {
	// Method addBook() - Database logic is to add a book to the database.
	public int addBook(BookPojo bp) throws ClassNotFoundException, SQLException {
		{
			String INSERT_BOOK_SQL ="INSERT INTO Book" +
					"(Book_id, Title, Author, Price, Available, Pub_id) VALUES " +
					"(?,?,?,?,?,?);";
			int result = 0;
			Class.forName("com.mysql.cj.jdbc.Driver");	
			try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "happiness");
			PreparedStatement ps = connection.prepareStatement(INSERT_BOOK_SQL))
			{
				ps.setString(1, bp.getBookId());
				ps.setString(2, bp.getTitle());
				ps.setString(3, bp.getAuthor());
				ps.setFloat(4, bp.getPrice());
				ps.setString(5, bp.getAvailable());
				ps.setString(6, bp.getPublisherId());
				result = ps.executeUpdate();
			}
			return result;
		}
	}
		
		public int updateBook(BookPojo bp) throws ClassNotFoundException, SQLException {
			// Method updateBook() - Database logic is to update a book to the database.
			{
				String UPDATE_BOOK_SQL ="UPDATE Book "
						+ "SET Title=?, Author=?, Price=?, Available=?, Pub_id=?"
						+ "WHERE Book_id=?";
				int result = 0;
				Class.forName("com.mysql.cj.jdbc.Driver");	
				try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "happiness");
				PreparedStatement ps = connection.prepareStatement(UPDATE_BOOK_SQL))
				{
					
					ps.setString(1, bp.getTitle());
					ps.setString(2, bp.getAuthor());
					ps.setFloat(3, bp.getPrice());
					ps.setString(4, bp.getAvailable());
					ps.setString(5, bp.getPublisherId());
					ps.setString(6, bp.getBookId());
					result = ps.executeUpdate();
				}			
				return result;			
			}		
		
		}
		public int deleteBook(BookPojo bp) throws ClassNotFoundException, SQLException {
			// Method deleteBook() - Database logic is to delete a book to the database.	
			{
				String DELETE_BOOK_SQL ="DELETE FROM Book WHERE Book_id=?";
				int result = 0;
				Class.forName("com.mysql.cj.jdbc.Driver");	
				try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "hapiness");
				PreparedStatement ps = connection.prepareStatement(DELETE_BOOK_SQL))
				{
					ps.setString(1, bp.getBookId());
					result = ps.executeUpdate();
					System.out.println(result);
				}
				return result;
			}		
		}
		public int issueBook(BookPojo bp) throws ClassNotFoundException, SQLException {
			// Method issueBook() - Database logic is to issue a book to member.
			{
				String INSERT_BOOK_SQL ="INSERT INTO IssueBook" +
						"(Book_id, Memb_id, Issue_date, Due_date, Returned_date) VALUES " +
						"(?,?,?,?,?);";
				int result = 0;
				Class.forName("com.mysql.cj.jdbc.Driver");	
				try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "happiness");
				PreparedStatement ps = connection.prepareStatement(INSERT_BOOK_SQL))
				{
					ps.setString(1, bp.getBookId());
					ps.setString(2, bp.getMemberId());
					ps.setString(3, bp.getIssueDate());
					ps.setString(4, bp.getDueDate());
					ps.setString(5,bp.getReturnedDate());
					result = ps.executeUpdate();
				}
				return result;
			}
		}
		public ArrayList<String> borrowList(BookPojo bp) throws ClassNotFoundException, SQLException {
			{
				String SELECT_BOOK_SQL ="select b1.Book_id,b3.Title,b1.Issue_date,b1.Due_date,b1.Returned_date,b2.Memb_id,b2.Memb_name,b2.Address,b3.Title,b3.Price"+
						" from(select b1.Book_id,b1.Memb_id,b1.Issue_date,b1.Due_date,b1.Returned_date"+
							     " from IssueBook b1) b1"+
								 " join Member b2 on b1.Memb_id=b2.Memb_id"+
								 " join Book b3 on b1.Book_id=b3.Book_id";
				ResultSet result;
				ArrayList<String> list;
				Class.forName("com.mysql.cj.jdbc.Driver");	
				try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/week5", "root", "happiness");
				PreparedStatement ps = connection.prepareStatement(SELECT_BOOK_SQL))
				{
					result = ps.executeQuery();
					list = new ArrayList<String>();
					while(result.next()) {
						list.add(result.getString("Book_id"));
						list.add(result.getString("Title"));
						list.add(result.getString("Issue_date"));
						list.add(result.getString("Due_date"));
						list.add(result.getString("Returned_date"));
						list.add(result.getString("Memb_id"));
						list.add(result.getString("Memb_name"));
					}
				}				
				return list;
			}
		}
}