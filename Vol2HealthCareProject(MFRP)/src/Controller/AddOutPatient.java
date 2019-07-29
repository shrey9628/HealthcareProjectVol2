package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.InOutPatientDAO;
import Model.In_Patient_Employee;
import Model.Out_Patient;

/**
 * Servlet implementation class AddOutPatient
 */
public class AddOutPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOutPatient() {
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
	
		
		System.out.println("You hit me");
		String result=null;
		Out_Patient op = new Out_Patient(Integer.parseInt(request.getParameter("Opno")), request.getParameter("Name"),Integer.parseInt(request.getParameter("Age")) ,request.getParameter("type"),request.getParameter("dateAdmsn"),request.getParameter("gender") ,request.getParameter("dia") , request.getParameter("treatment"));
		System.out.println("in sevlet age is"+op.getAge());
		try {
			result = InOutPatientDAO.AddOutPatient(op);
			System.out.println("the result in servler"+ result);
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		   out.println("alert('"+result+"');");
		   out.println("location='AddOutPatient.jsp';");
		   out.println("</script>");
	}

		
		
		
		
		
		
		
		
		
	

}
