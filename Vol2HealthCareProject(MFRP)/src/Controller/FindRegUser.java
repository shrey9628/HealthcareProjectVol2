package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DrugDAO;
import DAO.RegistrationDAO;
import Model.RegisterUserModel;

/**
 * Servlet implementation class FindRegUser
 */
public class FindRegUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindRegUser() {
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
		
		try {
			RegisterUserModel rum = RegistrationDAO.FindRegUsr(request.getParameter("opno"));
			
			if(rum!=null)
			{
				HttpSession session = request.getSession();
				  
	            session.setAttribute("FindUserData", rum); 
	            response.sendRedirect("FindUserDetails.jsp");
			}
			else
			{
			
          
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('No Registered User Present');");
				   out.println("location='FindRegUser.jsp';");
				   out.println("</script>");
			}
			
			
			
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
