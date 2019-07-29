package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Model.Main_Store;
import Model.RegisterUserModel;

public class DrugDAO {
	
	
	

SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	public static String AddDrugMain(Main_Store ms){
		int i=0;
		String res = null;
		PreparedStatement ps = null;
		String str = "insert into USER1.MAIN_STORE values (?,?,?,?)";
		try(Connection con= DBManager.getConnection();)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			ps = con.prepareStatement(str);
			ps.setString(1, ms.getDrug_name());
			ps.setInt(2, ms.getIn_store()); 
			
			ps.setString(3, sdf.format(ms.getExpiry_Date_1()));
			ps.setString(4, sdf.format(ms.getExpiry_Date_2()));
			
		     i=  ps.executeUpdate();
		     
		    
		}catch (SQLException e) {
			// TODO Aut3o-generated catch block
			e.printStackTrace();
		}
		int j=0;
		if(i==1)
		{
			System.out.println("Pharma entry");
			String str1 = "insert into USER1.PHARMACY_STORE values (?,?,?,?)";
			
			try(Connection con= DBManager.getConnection();)
			{
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				ps = con.prepareStatement(str1);
				ps.setString(1, ms.getDrug_name());
				ps.setInt(2, 0);
				
				ps.setString(3, " ");
				ps.setString(4, " ");
				
			     j=  ps.executeUpdate();
			     
			    
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(j==1)
			{
			res = "Drug inserted successfully";
			}
			
			
			
			
		}
	    	
	    	else
	    	{
	    		res= "Drug insert fail";
	    	}
	return res;
	}
	
	
	

	
	public static ArrayList<Main_Store> display() throws NumberFormatException, ParseException{
		
		 ArrayList<Main_Store> msli = new ArrayList<Main_Store>();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String statement="select * from USER1.MAIN_STORE";
			try(Connection con=DBManager.getConnection()){
			
				Statement st=con.createStatement();
			
				ResultSet rs=st.executeQuery(statement);
			   
				while(rs.next()){
					Main_Store  ms = new Main_Store(rs.getString(1), rs.getInt(2),sdf.parse(rs.getString(3)), sdf.parse(rs.getString(4)));
				    System.out.println(ms.getDrug_name());
					msli.add(ms);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return msli;
		}
	
	
	
	
	
	public static String DeleteMainBase(String name) throws NumberFormatException, ParseException{
		System.out.println("you are in DAO DElete"+name);
		
		String statement="DELETE from USER1.MAIN_STORE WHERE DRUG_NAME='"+name+"'";
		int rs=0;
			try(Connection con=DBManager.getConnection()){
			
				Statement st=con.createStatement();
			
				rs=st.executeUpdate(statement);
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("value of rs "+rs);
			if(rs==1)
		    	return ("Drug Deleted successfully from Main Base");
		    	else
		    		return ("Drung not found");
		}
	
	
	
	
	
	
	
	
	
	
	public static String UpdateDrugMain(Main_Store ms) throws NumberFormatException, ParseException{
		System.out.println("you are in DAO DElete"+ms);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String statement="UPDATE USER1.MAIN_STORE SET IN_STORE = '"+ms.getIn_store()+"', EXPIRY_DATE_1='"+sdf.format(ms.getExpiry_Date_1())+"' , EXPIRY_DATE_2='"+sdf.format(ms.getExpiry_Date_2())+"' WHERE DRUG_NAME='"+ms.getDrug_name()+"'"; 
		int rs=0;
			try(Connection con=DBManager.getConnection()){
			
				Statement st=con.createStatement();
			
				rs=st.executeUpdate(statement);
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("value of rs "+rs);
			if(rs==1)
		    	return ("Drug Update successfully in Main Base");
		    	else
		    		return ("Drung not found for updation");
		}
	
	
	
	
	
	
	

	public static String UpdatePharmaBase(Main_Store ms) throws NumberFormatException, ParseException{
		System.out.println("you are in DAO DElete"+ms);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		int rs=0;
		String statement="UPDATE USER1.PHARMACY_STORE SET IN_STOCK = '"+ms.getIn_store()+"', EXPIRY_DATE_1='"+sdf.format(ms.getExpiry_Date_1())+"' , EXPIRY_DATE_2='"+sdf.format(ms.getExpiry_Date_2())+"' WHERE DRUG_NAME='"+ms.getDrug_name()+"'"; 
	    Main_Store mainbase = DrugDAO.FindMainBase(ms.getDrug_name());
	    if(mainbase!=null)
	    {
	    	
	    	
	    	
	    int drugmb = mainbase.getIn_store();
	    int drugphar = ms.getIn_store();
		
		
	       if(drugmb>drugphar)
	       {
	    	 int finalcountmb = drugmb-drugphar;
	    	 Main_Store mainbasee = new Main_Store(mainbase.getDrug_name(),finalcountmb , mainbase.getExpiry_Date_1(),mainbase.getExpiry_Date_2()); 
	    	   DrugDAO.UpdateDrugMain(mainbasee);
			try(Connection con=DBManager.getConnection()){
			
				Statement st=con.createStatement();
			
				rs=st.executeUpdate(statement);
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("value of rs "+rs);
			if(rs==1)
			{
		    	return ("Drug Update successfully in Pharma Base");
		    	
		    	
		    	
		    	
			}
		    	else
		    		return ("Drung not found for updation");
			
			
			
	       }
	       else
	       {
	    	   return("Insufficient Drug in Main Base");
	       }
			
			
	    }
	    else
	    {
	    	return ("Drung not found in Main Base");
	    }
		}
	
	
	public static String UpdatePharmaBasee(Main_Store ms) throws NumberFormatException, ParseException{
		System.out.println("you are in DAO DElete"+ms);
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		int rs=0;
		String statement="UPDATE USER1.PHARMACY_STORE SET IN_STOCK = '"+ms.getIn_store()+"', EXPIRY_DATE_1='"+sdf.format(ms.getExpiry_Date_1())+"' , EXPIRY_DATE_2='"+sdf.format(ms.getExpiry_Date_2())+"' WHERE DRUG_NAME='"+ms.getDrug_name()+"'"; 

			try(Connection con=DBManager.getConnection()){
			
				Statement st=con.createStatement();
			
				rs=st.executeUpdate(statement);
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			if(rs==1)
			{
		    	return ("Drug Update successfully in Pharma Base");
		    	
		    	
		    	
		    	
			}
		    	else
		    		return ("Drung not found for updation");
			
			
			
	       
		}
	
	
	
	
	
	
	
	
public static Main_Store FindMainBase(String str) throws NumberFormatException, ParseException{
		SimpleDateFormat sdf  = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println(str);
		String statement="select * from USER1.MAIN_STORE WHERE DRUG_NAME='"+str+"'";
		Main_Store ms=null;
			try(Connection con=DBManager.getConnection()){
			
				Statement st=con.createStatement();
			
				ResultSet rs=st.executeQuery(statement);
				
				if(rs.next()){
					  ms = new Main_Store(rs.getString(1), rs.getInt(2),sdf.parse(rs.getString(3)), sdf.parse(rs.getString(4)));
					
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ms;
		}
	
	

	


public static Main_Store FindPharmaBase(String str) throws NumberFormatException, ParseException{
	SimpleDateFormat sdf  = new SimpleDateFormat("MM/dd/yyyy");
	System.out.println(str);
	String statement="select * from USER1.PHARMACY_STORE WHERE DRUG_NAME='"+str+"'";
	Main_Store ms=null;
		try(Connection con=DBManager.getConnection()){
		
			Statement st=con.createStatement();
		
			ResultSet rs=st.executeQuery(statement);
			
			if(rs.next()){
				if(rs.getInt(2)==0)
				{
					
					
				}
				else
				{
				  ms = new Main_Store(rs.getString(1), rs.getInt(2),sdf.parse(rs.getString(3)), sdf.parse(rs.getString(4)));
				}
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return ms;
	}












	
	
	
	
	
	public static ArrayList<Main_Store> DisplayPharmaBase() throws NumberFormatException, ParseException{
		
		 ArrayList<Main_Store> msli = new ArrayList<Main_Store>();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String statement="select * from USER1.PHARMACY_STORE";
			try(Connection con=DBManager.getConnection()){
			
				Statement st=con.createStatement();
			
				ResultSet rs=st.executeQuery(statement);
			   
				while(rs.next()){
					if(rs.getString(3).equals(" "))
					{
						
					}
					else{
					Main_Store  ms = new Main_Store(rs.getString(1), rs.getInt(2),sdf.parse(rs.getString(3)), sdf.parse(rs.getString(4)));
				    System.out.println(ms.getDrug_name());
					msli.add(ms);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return msli;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
