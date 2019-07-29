package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DrugDAO;
import Model.Main_Store;

/**
 * Servlet implementation class AddDrugMainn
 */
public class AddDrugMainn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDrugMainn() {
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
	    
		PrintWriter out  = response.getWriter();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	//	System.out.println("opno "+opno+" name "+request.getParameter("name")+" type "+request.getParameter("type")+" gender "+request.getParameter("gender")+" B1 "+request.getParameter("beneficiaryone")+" b2 "+ request.getParameter("beneficiarytwo")+" address "+request.getParameter("address")+" age "+ Integer.parseInt(request.getParameter("Age")));
		System.out.println("drug_name "+request.getParameter("name")+" in store "+request.getParameter("count")+" Expiry date one "+request.getParameter("expone")+" Expiry_Date_2 "+ request.getParameter("exptwo"));
		
		try {
			Main_Store  ms = new  Main_Store(request.getParameter("name"), Integer.parseInt(request.getParameter("count")),sdf.parse(request.getParameter("expone")) , sdf.parse(request.getParameter("exptwo")));
			
			System.out.println("Objct of "+ms);
			String result = DrugDAO.AddDrugMain(ms);
			PrintWriter out3 = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			   out3.println("alert('"+result+"');");
			   out3.println("location='AddDrugMain.jsp';");
			   out3.println("</script>");
			
			
			
			
			
			
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
