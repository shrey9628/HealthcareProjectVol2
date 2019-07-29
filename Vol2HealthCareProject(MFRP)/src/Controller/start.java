package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class start
 */
public class start extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public start() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		System.out.println(session);
		System.out.println(session.getAttribute("uname"));
		if(session.getAttribute("uname")==null)
		{
			response.sendRedirect("Login.jsp");
		}
		
		else 
		{
			if(session.getAttribute("uname").equals("admin"))
			{
			response.sendRedirect("Admin.jsp");
			}
			
			else if(session.getAttribute("uname").equals("operator"))
			{
				response.sendRedirect("operator.jsp");	
			}
			else if(session.getAttribute("uname").equals("doctor"))
			{
				response.sendRedirect("Doctor.jsp");
			}
			else if(session.getAttribute("uname").equals("nurse"))
			{
				response.sendRedirect("Nurse.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
