package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.InOutPatientDAO;
import DAO.OutPatientDAO;
import Model.OperatorEntry;

/**
 * Servlet implementation class AddOutPatientMed
 */
public class AddOutPatientMed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOutPatientMed() {
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
		OperatorEntry ope = new OperatorEntry(Integer.parseInt(request.getParameter("Opno")),request.getParameter("DrugName") , request.getParameter("adDate"), Integer.parseInt(request.getParameter("quant")));
		String result=null;
		System.out.println("in sevlet age is"+ope.getDrug_Name());
		try {
			result = OutPatientDAO.AddOutPatientMed(ope);
			System.out.println("the result in servler"+ result);
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
		   out.println("alert('"+result+"');");
		   out.println("location='AddOutPatientMed.jsp';");
		   out.println("</script>");
	}

		
	}


