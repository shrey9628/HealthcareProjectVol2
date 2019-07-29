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

import DAO.OutPatientDAO;
import Model.NurseEntry;
import Model.OperatorEntry;

/**
 * Servlet implementation class DisplayInPatientMed
 */
public class DisplayInPatientMed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayInPatientMed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<NurseEntry> ali = null;
		try {
			ali = OutPatientDAO.DisplayAllInPatientMed();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		if(ali.isEmpty())
		{
		
			out.println("<script type=\"text/javascript\">");
			   out.println("alert('No Data is for Display');");
			   out.println("location='Nurse.jsp';");
			   out.println("</script>");
			
		}
		else
		{
			
			 HttpSession session = request.getSession();
			  
	            session.setAttribute("AllDataInPatientMed", ali); 
	            response.sendRedirect("DisplayAllInPatientMed.jsp");
			
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
