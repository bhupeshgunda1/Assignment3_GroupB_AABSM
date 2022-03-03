package com.abms.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abms.dao.BookDaoClass_grpB;
import com.abms.model.BookPojo;


/**
 * Servlet implementation class BookServlet
  Date - 03/02/2022
  Author - Avinash Kour/Bhupesh Gunda
  Description - Implementing AddBook(),UpdateBook(),DeleteBook() and IssueBook()
                for addition, update, deletion and Issuance of a book.
*/ 
@WebServlet("/BookServ")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BookDaoClass_grpB bookdao = new BookDaoClass_grpB();

    /**
     * Default constructor. 
     */
    public BookServlet() {
        // TODO Auto-generated constructor stub
    }
    
    private BookDaoClass_grpB bdao;

	public void init() {
		bdao = new BookDaoClass_grpB();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("action") != null) //if action is not null
		{
		String action = request.getParameter("action");
		if (action.equals("Add Book")) //add button clicked
		{
			addBook(request,response);
		}
		else if (action.equals("Update Book")) //delete button clicked
		{
			updateBook(request,response);
		}
		else if (action.equals("Delete Book")){
			deleteBook(request,response);
		}
		else if (action.equals("Issue Book")){
			issueBook(request,response);
		}
		else {
			try {
				borrowList(request,response);
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
}

	private void addBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		String bookId = request.getParameter("bookid");
		String title = request.getParameter("title");
        String author = request.getParameter("author");
        Float price = Float.parseFloat(request.getParameter("price"));
        String available =request.getParameter("available");
        String publisherId =request.getParameter("publisherId");

        BookPojo bb=new BookPojo();
        
        bb.setBookId(bookId);
        bb.setAuthor(author);
        bb.setTitle(title);
        bb.setPrice(price);
        bb.setAvailable(available);
        bb.setPublisherId(publisherId);
        try {
            bdao.addBook(bb);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("BookResponse.jsp"); //response goes to view!!
}



private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
	// TODO Auto-generated method stub

	String bookId = request.getParameter("bookid");
	String title = request.getParameter("title");
    String author = request.getParameter("author");
    Float price = Float.parseFloat(request.getParameter("price"));
    String available =request.getParameter("available");
    String publisherId =request.getParameter("publisherId");

    BookPojo bb=new BookPojo();
    
    bb.setBookId(bookId);
    bb.setAuthor(author);
    bb.setTitle(title);
    bb.setPrice(price);
    bb.setAvailable(available);
    bb.setPublisherId(publisherId);
    try {
        bdao.updateBook(bb);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    response.sendRedirect("BookUpdateResponse.jsp"); //response goes to BookUpdateResponse view!!
}



private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
	// TODO Auto-generated method stub

	String bookId = request.getParameter("bookid");
    BookPojo bb=new BookPojo();
    bb.setBookId(bookId);
    try {
        bdao.deleteBook(bb);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    response.sendRedirect("BookDeleteResponse.jsp"); //response goes to  BookDeleteResponse view!!
}
private void issueBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
	// TODO Auto-generated method stub

	String bookId = request.getParameter("bookid");
	String memberId = request.getParameter("member_id");
    String issueDate = request.getParameter("issue_date");
    String dueDate = request.getParameter("due_date");
    String returnedDate =request.getParameter("returned_date");

    BookPojo bb=new BookPojo();
    
    bb.setBookId(bookId);
    bb.setMemberId(memberId);
    bb.setIssuedate(issueDate);
    bb.setDuedate(dueDate);
    bb.setReturneddate(returnedDate);
    try {
        bdao.issueBook(bb);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    response.sendRedirect("BookIssueResponse.jsp"); //response goes to view!!
}
    private void borrowList(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
    	// TODO Auto-generated method stub
        BookPojo bb=new BookPojo();
        ArrayList<String> result = null;
		try {
            result = bdao.borrowList(bb);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //ResultSet rs = result;
		int n = result.size()/7;
		for(int i=0;i<n;i++) {
			String bookId = result.get(0);
			result.remove(0);
			String bookTitle = result.get(0);
			result.remove(0);
			String issueId = result.get(0);
			result.remove(0);
			String dueDate = result.get(0);
			result.remove(0);
			String returnedDate = result.get(0);
			result.remove(0);
			String membId = result.get(0);
			result.remove(0);
			String membName = result.get(0);
			result.remove(0);
			request.setAttribute("bookId" + i, bookId);
			request.setAttribute("bookTitle" + i, bookTitle);
			request.setAttribute("issueId" + i, issueId);
			request.setAttribute("dueDate" + i, dueDate);
			request.setAttribute("returnedDate" + i, returnedDate);
			request.setAttribute("membId" + i, membId);
			request.setAttribute("membName" + i, membName);
			}
		RequestDispatcher rd = request.getRequestDispatcher("/BorrowListDisplay.jsp");
		rd.include(request, response);
		}
}
