package com.abms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abms.dao.PublisherDaoClass_grpB;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("action") != null) // if action is not null
		{
			String action = request.getParameter("action");
			if (action.equals("Add Publisher"))      // add publisher button clicked
			{
				addPublisher(request, response);
			} else {
				updatePublisher(request, response);
			}
		}

	}

	protected void addPublisher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pubId = request.getParameter("pub_id");
		String address = request.getParameter("pub_address");
		String name = request.getParameter("pub_name");

		PublisherPojo pp = new PublisherPojo();

		pp.setPub_id(pubId);
		pp.setAddress(address);
		pp.setPub_Name(name);
		try {
			pdao.addPublisher(pp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("AddPublisherResponse.jsp"); // response goes to AddPublisher view!!
	}

	protected void updatePublisher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pubId = request.getParameter("pub_id");
		String address = request.getParameter("pub_address");
		String name = request.getParameter("pub_name");

		PublisherPojo pp = new PublisherPojo();

		pp.setPub_id(pubId);
		pp.setAddress(address);
		pp.setPub_Name(name);
		try {
			pdao.updatePublisher(pp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("UpdatePublisherResponse.jsp"); // response goes to UpdatePublisher view!!
	}
}