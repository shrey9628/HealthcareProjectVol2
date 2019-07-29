package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import Model.RegisterUserModel;



public class RegistrationDAO {

	private static final String ArrayList = null;


public static RegisterUserModel FindRegUsr(String str) throws NumberFormatException, ParseException{
		
		System.out.println(str);
		String statement="select * from USER1.REGISTERUSER WHERE OPNO='"+Integer.parseInt(str)+"'";
		RegisterUserModel ms=null;
			try(Connection con=DBManager.getConnection()){
			
				Statement st=con.createStatement();
			
				ResultSet rs=st.executeQuery(statement);
				
				if(rs.next()){
					  ms = new RegisterUserModel(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8) , rs.getString(9));
					  System.out.println(ms.getOpNo()+" "+ms.getName());
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ms;
		}
	
	

	
	
	
	


	public static String RegisterUser(RegisterUserModel reguser){
		int i=0;
		PreparedStatement ps = null;
		String str = "insert into USER1.REGISTERUSER values (?,?,?,?,?,?,?,?,?)";
		try(Connection con= DBManager.getConnection();)
		{
			ps = con.prepareStatement(str);
			ps.setInt(1, reguser.getOpNo());
			ps.setString(2,reguser.getName());
			
			ps.setString(3, reguser.getGender());
			ps.setString(4, reguser.getType());
			ps.setString(5, reguser.getBenificiary1());
			ps.setString(6, reguser.getBenificiary2());
			ps.setString(7, reguser.getAddress());
			ps.setInt(8,reguser.getAge());
			ps.setString(9,reguser.getEmail());
		     i=  ps.executeUpdate();
		     
		    
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(i==1)
	    	return ("Customer inserted successfully and you opno is "+reguser.getOpNo());
	    	else
	    		return ("Customer insert fail");
		
	
	}
	
	
	

	
	public static ArrayList<RegisterUserModel> display(){
		//	System.out.println(id+"  "+password);
		 ArrayList<RegisterUserModel> ali = new ArrayList<RegisterUserModel>();
		
			String statement="select * from USER1.REGISTERUSER";
			try(Connection con=DBManager.getConnection()){
			
				Statement st=con.createStatement();
			
				ResultSet rs=st.executeQuery(statement);
			   
				while(rs.next()){
					RegisterUserModel rum = new RegisterUserModel(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8) , rs.getString(9));
					System.out.println(rum.getName());
					ali.add(rum);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ali;
		}
	
	
	
	
	
}
