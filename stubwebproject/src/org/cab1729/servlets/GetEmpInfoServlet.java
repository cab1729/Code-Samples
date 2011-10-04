package org.cab1729.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cab1729.beans.session.GetEmpInfoLocal;

/**
 * Servlet implementation class GetEmpInfoServlet
 */
public class GetEmpInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(beanName="GetEmpInfo")
	private GetEmpInfoLocal getEmpInfoBean;
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmpInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
                 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		try {
			
			Long empId = Long.valueOf(request.getParameter("empId"));
			out.print("email: ");
			out.print(getEmpInfoBean.getEmpEmail(empId));
			
		} finally {
			out.close();
		}
		
	}

}
