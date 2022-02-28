package com.abms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abms.dao.MemberDaoClass_grpB;
import com.abms.dao.PublisherDaoClass_grpB;
import com.abms.model.MemberPojo;
import com.abms.model.PublisherPojo;

/**
 * Servlet implementation class PublisherServlet
 */
@WebServlet("/PublisherServ")
public class PublisherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PublisherDaoClass_grpB publisherdao = new PublisherDaoClass_grpB();
    /**
     * Default constructor. 
     */
    private PublisherDaoClass_grpB pdao;

	public void init() {
		pdao = new PublisherDaoClass_grpB();
	}

    /**
     * Default constructor. 
     */
    public PublisherServlet() {
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		String pubId = request.getParameter("pub_id");
		String address = request.getParameter("pub_address");
		String name = request.getParameter("pub_name");

        PublisherPojo pp = new PublisherPojo();
        
        pp.setPub_id(pubId);
        pp.setAddress(address);
        pp.setPub_Name(name);
        try {
            pdao.pubreg(pp);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("Publisher.jsp"); //response goes to view!!
	}

}
