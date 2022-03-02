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
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDaoClass_grpB memberdao = new MemberDaoClass_grpB();
    /**
     * Default constructor. 
     */
    public MemberServlet() {
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
		if (request.getParameter("action") != null) //if action is not null
		{
		String action = request.getParameter("action");
		if (action.equals("Register Member")) //add button clicked
		{
			registerMember(request,response);
		}
		else if (action.equals("Update Member")) //delete button clicked
		{
			updateMember(request,response);
		}
		else {
			deleteMember(request,response);
		}
		}
	}
	public void registerMember(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String memberId = request.getParameter("id");
		String name = request.getParameter("name");
        String address = request.getParameter("address");
        String type = request.getParameter("type");
        String memberdate =request.getParameter("memberdate");
        String expirydate =request.getParameter("expirydate");

        MemberPojo mp = new MemberPojo();
        
        mp.setMemb_id(memberId);
        mp.setMemb_name(name);
        mp.setAddress(address);
        mp.setMemb_type(type);
        mp.setMemb_date(memberdate);
        mp.setExpiry_date(expirydate);
        try {
            mdao.membereg(mp);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("MemberResponse.jsp"); //response goes to view!!
	}
	public void updateMember(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
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
            mdao.membupdate(mm);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("MemberUpdateResponse.jsp"); //response goes to view!!
	}
	public void deleteMember(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String memberId = request.getParameter("id");
		MemberPojo mm = new MemberPojo();
		mm.setMemb_id(memberId);
		
		try {
            mdao.membdelete(mm);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("MemberDeleteResponse.jsp"); //response goes to view!!
	}
}
