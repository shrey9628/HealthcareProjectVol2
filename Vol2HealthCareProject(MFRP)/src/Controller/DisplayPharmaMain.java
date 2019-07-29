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

import DAO.DrugDAO;
import Model.Main_Store;

/**
 * Servlet implementation class DisplayPharmaMain
 */
public class DisplayPharmaMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPharmaMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Main_Store> ali = null;
		try {
			ali = DrugDAO.DisplayPharmaBase();
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
			   out.println("location='operator.jsp';");
			   out.println("</script>");
			
		}
		else
		{
			
			 HttpSession session = request.getSession();
			  
	            session.setAttribute("DrugPharmaData", ali); 
	            response.sendRedirect("DisplayPharmaBase.jsp");
			
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
