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
 * Servlet implementation class MemberDelete
 */
@WebServlet("/MemberDelete")
public class MemberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDelete() {
        super();
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
