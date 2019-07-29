package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.InOutPatientDAO;
import DAO.OutPatientDAO;
import DAO.RegistrationDAO;
import Model.In_Patient_Employee;
import Model.OperatorEntry;
import Model.RegisterUserModel;

/**
 * Servlet implementation class FindOutPatientMed
 */
public class FindOutPatientMed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindOutPatientMed() {
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
//	PrintWriter out = response.getWriter();
//		
//		try {
//			AOperatorEntry oe = OutPatientDAO.FindOutPatientMed(request.getParameter("opno"));
//			
//			if(oe!=null)
//			{
//				HttpSession session = request.getSession();
//				  
//	            session.setAttribute("FindOutPatientMed", oe); 
//	            response.sendRedirect("DisplayFindOutPatientMed.jsp");
//			}
//			else
//			{
//			
//          
//				out.println("<script type=\"text/javascript\">");
//				   out.println("alert('No Out Patient is Present with this Opno');");
//				   out.println("location='SearchOutPatientMed.jsp';");
//				   out.println("</script>");
//			}
//			
//			
//			
//		} catch (NumberFormatException | ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		ArrayList<OperatorEntry> ali=null;
		try {
			ali = OutPatientDAO.FindOutPatientMed(request.getParameter("opno"));
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		if(ali.isEmpty())
		{
		
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('No Out Patient is Present with this Opno');");
			   out.println("location='SearchOutPatientMed.jsp';");
			   out.println("</script>");
			
		}
		else
		{
			
			 HttpSession session = request.getSession();
			  
			 session.setAttribute("FindOutPatientMed", ali); 
	            response.sendRedirect("DisplayFindOutPatientMed.jsp");
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
