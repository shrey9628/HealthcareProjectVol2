package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.InOutPatientDAO;
import Model.In_Patient_Student;
import Model.Out_Patient;

/**
 * Servlet implementation class FindOutPatient
 */
public class FindOutPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindOutPatient() {
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
		System.out.println("You are in Servelt "+request.getParameter("opno"));
		try {
			Out_Patient op = InOutPatientDAO.FindOutPatient(request.getParameter("opno"));
			System.out.println("The value of ips"+op);
			if(op!=null)
			{
				System.out.println("The value of ips"+op.getName());
				HttpSession session = request.getSession();
				  
	            session.setAttribute("FindOutPatientData", op); 
	            response.sendRedirect("ShowOutPatient.jsp");
			}
			else
			{
			
          
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('No In Patient Student Present');");
				   out.println("location='SearchInStudent.jsp';");
				   out.println("</script>");
			}
			
			
			
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
