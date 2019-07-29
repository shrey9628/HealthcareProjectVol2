package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ha.backend.Sender;

import DAO.LoginAdmin;

/**
 * Servlet implementation class forgotPassword
 */
public class forgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotPassword() {
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
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String result = "Entered ID is incorrent";
		if(LoginAdmin.forgotpassword(id))
		{
			HttpSession session = request.getSession();
			session.setAttribute("IDForOTP", id);
			System.out.println("OTP is sent");
			result = "OTP is sent to your Email id";
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('"+result+"');");
			   out.println("location='Otp.jsp';");
			   out.println("</script>");
		}

		else
		{
			

			out.println("<script type=\"text/javascript\">");
			   out.println("alert('"+result+"');");
			   out.println("location='Login.jsp';");
			   out.println("</script>");
			
		}
	}

}
