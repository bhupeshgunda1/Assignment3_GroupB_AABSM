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
            bdao.issueBook(bb);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("BookResponse.jsp"); //response goes to view!!
	}

}
