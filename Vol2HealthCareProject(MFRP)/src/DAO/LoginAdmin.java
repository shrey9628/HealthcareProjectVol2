package DAO;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;


import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;


public class LoginAdmin {

	public static boolean login(String id, String password){
		System.out.println(id+"  "+password);
		
		boolean b=false;
		String statement="select * from USER1.LOGIN where ID='"+id+"' and PASSWORD='"+password+"'";
		try(Connection con=DBManager.getConnection()){
		
			Statement st=con.createStatement();
		
			ResultSet rs=st.executeQuery(statement);
		
			while(rs.next()){
				System.out.println(rs.getString(1)+"  "+rs.getString(2));
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	
	
	
	
	
	public static int verifyotp(String id){
		
		int result=0;
		String statement="select * from USER1.LOGIN where ID='"+id+"'";
		try(Connection con=DBManager.getConnection()){
		
			Statement st=con.createStatement();
		
			ResultSet rs=st.executeQuery(statement);
		
			while(rs.next()){
				result=rs.getInt(3);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	public static void updatekey(String id){
		
		boolean b=false;
		Random rand = new Random();
		int opno = (int) rand.nextInt(1000)+5000;
		String statement="UPDATE USER1.LOGIN SET KEY='"+opno+"' WHERE ID='"+id+"'";
		try(Connection con=DBManager.getConnection()){
		
			Statement st=con.createStatement();
		
			int rs=st.executeUpdate(statement);
		
		
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public static boolean forgotpassword(String id){
		System.out.println(id);
		
		boolean b=false;
		boolean result = false;
		String EmailIdEmp = "";
		String EmpName = "";
		int Key=0;
		String statement="select * from USER1.LOGIN where ID='"+id+"'";
		try(Connection con=DBManager.getConnection()){
		
			Statement st=con.createStatement();
		
			ResultSet rs=st.executeQuery(statement);
		    
			while(rs.next()){
				EmailIdEmp= rs.getString(4);
				EmpName= rs.getString(1);
				Key = rs.getInt(3);
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(b)
		{
			

			
			String host="smtp.gmail.com";  
			  final String user="shreysharma96280@gmail.com";//change accordingly  
			  final String password="shrey@9628";//change accordingly  
			    
			  String to=EmailIdEmp;//change accordingly  
			  
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
			     message.setContent("<h2>Hi "+EmpName+"</h2><br><p>Your OTP to change password is <u>"+Key+ "</u></p><br><br><h3>Thanks & Regards</h3><br><h3>Team S.L.V HealthCare</h3> ","text/html"); 
			       
			    //send the message  
			     Transport.send(message);  
			  
			     System.out.println("message sent successfully...");  
			     result=true;
			   
			     } catch (MessagingException e) {e.printStackTrace();} 
			
			
			
			

		}
		
		return result;
		
		
	}
	
	
	
	
	
	
	
	
public static boolean ChangePassword(String id , String otp , String pass1 , String pass2){
	boolean b=false;
	int otp1 = Integer.parseInt(otp);
	if(verifyotp(id)==otp1)
		
	{
		
		
		Random rand = new Random();
		int opno = (int) rand.nextInt(1000)+5000;
		String statement="UPDATE USER1.LOGIN SET  PASSWORD='"+pass1+"' , KEY='"+opno+"'   WHERE ID='"+id+"'";
		try(Connection con=DBManager.getConnection()){
		
			Statement st=con.createStatement();
		
			int rs=st.executeUpdate(statement);
			if(rs==1)
			{
				b=true;
			}
		
			}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	return b;
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
