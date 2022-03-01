package com.abms.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abms.dao.MemberDaoClass_grpB;
import com.abms.model.MemberPojo;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/MemberServ")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDaoClass_grpB memberdao = new MemberDaoClass_grpB();
    /**
     * Default constructor. 
     */
    public MemberInsert() {
        // TODO Auto-generated constructor stub
    }
    private MemberDaoClass_grpB mdao;

	public void init() {
		mdao = new MemberDaoClass_grpB();
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
		String memberId = request.getParameter("id");
		String name = request.getParameter("name");
        String address = request.getParameter("address");
        String type = request.getParameter("type");
        String memberdate =request.getParameter("memberdate");
        String expirydate =request.getParameter("expirydate");

        MemberPojo mm = new MemberPojo();
        
        mm.setMemb_id(memberId);
        mm.setMemb_name(name);
        mm.setAddress(address);
        mm.setMemb_type(type);
        mm.setMemb_date(memberdate);
        mm.setExpiry_date(expirydate);
        try {
            mdao.membereg(mm);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("MemberResponse.jsp"); //response goes to view!!
	}

}
