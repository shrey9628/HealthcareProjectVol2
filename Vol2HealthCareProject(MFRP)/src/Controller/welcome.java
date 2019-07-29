package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginAdmin;

/**
 * Servlet implementation class welcome
 */
public class welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public welcome() {
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
		
		String id = request.getParameter("id");
		System.out.println(id);
		String password = request.getParameter("password");
	//	System.out.println(id+"   "+password);

		
		
		
		if(LoginAdmin.login(id, password ))
		{

			LoginAdmin.updatekey(id);
			 HttpSession session = request.getSession();session.setAttribute("uname", id); 
			
			System.out.println("Session Done");
			if(id.equalsIgnoreCase("admin"))
			{
			response.sendRedirect("Admin.jsp");
			}
			else if(id.equalsIgnoreCase("operator"))
			{
				response.sendRedirect("operator.jsp");
			}
			else if(id.equalsIgnoreCase("doctor"))
			{
				response.sendRedirect("Doctor.jsp");
			}
			else if(id.equalsIgnoreCase("nurse"))
			{
				response.sendRedirect("Nurse.jsp");
			}
			
		}
		
		
		else 
		{
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('User or password incorrect');");
			   out.println("location='Login.jsp';");
			   out.println("</script>");
		}
		
	}

}
