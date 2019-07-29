package Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*; 



import com.sun.xml.internal.bind.v2.runtime.Name;

import DAO.RegistrationDAO;
import Model.RegisterUserModel;

/**
 * Servlet implementation class RegisterUser
 */
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
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
		
		Random rand = new Random();
		int opno = (int) rand.nextInt(1000)+5000;
		System.out.println("opno "+opno+" name "+request.getParameter("name")+" type "+request.getParameter("type")+" gender "+request.getParameter("gender")+" B1 "+request.getParameter("beneficiaryone")+" b2 "+ request.getParameter("beneficiarytwo")+" address "+request.getParameter("address")+" age "+ Integer.parseInt(request.getParameter("Age")));
		RegisterUserModel reguser = new RegisterUserModel(opno, request.getParameter("name"),request.getParameter("type") , request.getParameter("gender") ,request.getParameter("beneficiaryone")  , request.getParameter("beneficiarytwo"), request.getParameter("address"),  Integer.parseInt(request.getParameter("Age")) , request.getParameter("email"));
		String result = RegistrationDAO.RegisterUser(reguser);
		PrintWriter out = response.getWriter();
		

		
		String host="smtp.gmail.com";  
		  final String user="shreysharma96280@gmail.com";//change accordingly  
		  final String password="shrey@9628";//change accordingly  
		    
		  String to=reguser.getEmail();//change accordingly  
		  
		   //Get the session object  
		   Properties props = new Properties();  
		   props.put("mail.smtp.host",host);  
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable","true");
		   props.put("mail.smtp.socketFactory.port", "587");
		   props.put("mail.smtp.port", "587"); 		     
		   Session session = Session.getDefaultInstance(props,  
		    new javax.mail.Authenticator() {  
		      protected PasswordAuthentication getPasswordAuthentication() {  
		    return new PasswordAuthentication(user,password);  
		      }  
		    });  
		  
		   //Compose the message  
		    try {  
		     MimeMessage message = new MimeMessage(session);  
		     message.setFrom(new InternetAddress(user));  
		     message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		     message.setSubject("Registration Done");  
		     message.setContent("<h2>Hi "+request.getParameter("name")+"</h2><br><p>You are now registred with us your registed id is <u>"+opno+ "</u></p><br><br><h3>Thanks & Regards</h3><br><h3>Team S.L.V HealthCare</h3> ","text/html"); 
		       
		    //send the message  
		     Transport.send(message);  
		  
		     System.out.println("message sent successfully...");  
		   
		     } catch (MessagingException e) {e.printStackTrace();} 
		
		
		
		
		
		
		
		
		
		
		out.println("<script type=\"text/javascript\">");
		   out.println("alert('"+result+"');");
		   out.println("location='register.jsp';");
		   out.println("</script>");
		
	}

}
