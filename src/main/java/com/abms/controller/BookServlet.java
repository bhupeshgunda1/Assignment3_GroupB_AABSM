package com.abms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abms.dao.BookDaoClass_grpB;
import com.abms.model.BookPojo;


/**
 * Servlet implementation class BookServlet
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
		else {
			deleteBook(request,response);
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

        BookPojo bb=new BookPojo();
        
        bb.setBookId(bookId);
        bb.setAuthor(author);
        bb.setTitle(title);
        bb.setPrice(price);
        bb.setAvailable(available);
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

    BookPojo bb=new BookPojo();
    
    bb.setBookId(bookId);
    bb.setAuthor(author);
    bb.setTitle(title);
    bb.setPrice(price);
    bb.setAvailable(available);
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
}
