package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginAdmin;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
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
		PrintWriter out=  response.getWriter();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("IDForOTP");
		String result = "OTP you entered is not correct";
		if( LoginAdmin.ChangePassword(id, request.getParameter("otp"), request.getParameter("pass1"), request.getParameter("pass2")))
		{
			System.out.println("You are in if block");
			result="Password change successfully";
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('"+result+"');");
			   out.println("location='Login.jsp';");
			   out.println("</script>");
			
		}
		else
		{
		out.println("<script type=\"text/javascript\">");
		   out.println("alert('"+result+"');");
		   out.println("location='Otp.jsp';");
		   out.println("</script>");
		
		}
	}

}
