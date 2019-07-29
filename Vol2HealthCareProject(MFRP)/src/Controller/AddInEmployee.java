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
import Model.In_Patient_Student;

/**
 * Servlet implementation class AddInEmployee
 */
public class AddInEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInEmployee() {
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
		Double totalamount = Double.parseDouble(request.getParameter("bedChrg"))+Double.parseDouble(request.getParameter("XrayChrg"));
		In_Patient_Employee ipe = new In_Patient_Employee(Integer.parseInt(request.getParameter("Opno")), request.getParameter("Name"),Integer.parseInt(request.getParameter("Age")) ,request.getParameter("gender") ,"Employee" , request.getParameter("adDate"), request.getParameter("disDate"),request.getParameter("dia"), request.getParameter("prcom") , request.getParameter("prhis"),request.getParameter("DrAl"),Double.parseDouble(request.getParameter("bedChrg")),Double.parseDouble(request.getParameter("XrayChrg")),totalamount);
		System.out.println("in sevlet age is"+ipe.getAge());
		try {
			result = InOutPatientDAO.AddInEmployeee(ipe);
			System.out.println("the result in servler"+ result);
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		   out.println("alert('"+result+"');");
		   out.println("location='AddInEmployee.jsp';");
		   out.println("</script>");
	}

}
