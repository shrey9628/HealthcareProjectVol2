package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.InOutPatientDAO;
import DAO.RegistrationDAO;
import Model.Out_Patient;
import Model.RegisterUserModel;

/**
 * Servlet implementation class DisplayOutPatient
 */
public class DisplayOutPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayOutPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		

		ArrayList<Out_Patient> ali = InOutPatientDAO.DisplayOutPatient();
		PrintWriter out = response.getWriter();
		if(ali.isEmpty())
		{
		
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('No Data is for Display');");
			   out.println("location='admin.jsp';");
			   out.println("</script>");
			
		}
		else
		{
			
			 HttpSession session = request.getSession();
			  
	            session.setAttribute("OutPatientData", ali); 
	            response.sendRedirect("DisplayOutPatientRecords.jsp");
			
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
