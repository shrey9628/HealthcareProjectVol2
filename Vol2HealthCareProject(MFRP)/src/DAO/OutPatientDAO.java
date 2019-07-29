package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import Model.In_Patient_Employee;
import Model.In_Patient_Student;
import Model.Main_Store;
import Model.NurseEntry;
import Model.OperatorEntry;
import Model.Out_Patient;
import Model.RegisterUserModel;

public class OutPatientDAO {
	
	
	

	public static String AddOutPatientMed(OperatorEntry ope) throws NumberFormatException, ParseException{
		int i=0;
		PreparedStatement ps = null;
		String str = "insert into USER1.OPERATOR_ENTRY values (?,?,?,?)";
		Out_Patient op = InOutPatientDAO.FindOutPatient(String.valueOf(ope.getOp_No()));
		if(op!=null)
		{
			Main_Store pharmabase = DrugDAO.FindPharmaBase(ope.getDrug_Name()) ;
			if(pharmabase!=null)
			{
				int quantphar = pharmabase.getIn_store();
				int given = ope.getNo_Of_Drugs();
				if(quantphar>=given)
				{
					int totalphar = quantphar-given;
					Main_Store RealPharmaBase = new Main_Store(pharmabase.getDrug_name(), totalphar, pharmabase.getExpiry_Date_1(), pharmabase.getExpiry_Date_2());
					DrugDAO.UpdatePharmaBase(RealPharmaBase);
		try(Connection con= DBManager.getConnection();)
		{
			ps = con.prepareStatement(str);
			ps.setInt(1, ope.getOp_No());
			ps.setString(2,ope.getDrug_Name());
			
			ps.setString(3, ope.getDate());
			ps.setInt(4, ope.getNo_Of_Drugs());
			
		     i=  ps.executeUpdate();
		     
		    
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(i==1)
	    	return ("Out Patient Medicine Inserted Successfuly");
	    	else
	    		return ("Out Patient Medicine insert fail");
		
				}
				else
				{
					return("Insufficient Medicine in Pharma Base");
				}
		}
			else
			{
				return("Medicine is Not present In Pharma Base");
			}
		}
		
		
		
		
		else
		{
			return("This Opno is not present in Out Patient DB");
		}
	
	}
	
	
	
	
	

public static ArrayList<OperatorEntry> FindOutPatientMed(String str) throws NumberFormatException, ParseException{
		
		System.out.println(str);
		String statement="select * from USER1.OPERATOR_ENTRY WHERE OP_NO='"+Integer.parseInt(str)+"'";
		OperatorEntry ms=null;
		ArrayList<OperatorEntry> ali = new ArrayList<OperatorEntry>(); 
			try(Connection con=DBManager.getConnection()){
			
				Statement st=con.createStatement();
			
				ResultSet rs=st.executeQuery(statement);
				
				while(rs.next()){
					  ms = new OperatorEntry(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getInt(4));
					ali.add(ms);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ali;
		}
	
	

	





public static ArrayList<OperatorEntry> DisplayAllOutPatientMed() throws NumberFormatException, ParseException{
	
	 ArrayList<OperatorEntry> msli = new ArrayList<OperatorEntry>();
	String statement="select * from USER1.OPERATOR_ENTRY";
		try(Connection con=DBManager.getConnection()){
		
			Statement st=con.createStatement();
		
			ResultSet rs=st.executeQuery(statement);
		   
			while(rs.next()){
				OperatorEntry  ms = new OperatorEntry(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getInt(4));
			    System.out.println(ms.getOp_No());
				msli.add(ms);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return msli;
	}



	
	
	
	

public static ArrayList<NurseEntry> DisplayAllInPatientMed() throws NumberFormatException, ParseException{
	
	 ArrayList<NurseEntry> msli = new ArrayList<NurseEntry>();
	String statement="select * from USER1.NURSE_ENTRY";
		try(Connection con=DBManager.getConnection()){
		
			Statement st=con.createStatement();
		
			ResultSet rs=st.executeQuery(statement);
		   
			while(rs.next()){
				NurseEntry  ms = new NurseEntry(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getInt(5));
			    System.out.println(ms.getOp_No());
				msli.add(ms);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return msli;
	}



	
	


public static ArrayList<NurseEntry> FindInPatientMed(String str) throws NumberFormatException, ParseException{
		
		System.out.println(str);
		String statement="select * from USER1.NURSE_ENTRY WHERE OP_NO='"+Integer.parseInt(str)+"'";
		NurseEntry ms=null;
		ArrayList<NurseEntry> ali = new ArrayList<NurseEntry>(); 
			try(Connection con=DBManager.getConnection()){
			
				Statement st=con.createStatement();
			
				ResultSet rs=st.executeQuery(statement);
				
				while(rs.next()){
					  ms = new NurseEntry(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getInt(5));
					ali.add(ms);
					
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return ali;
		}

	
	










public static String AddInPatientMed(NurseEntry ope) throws NumberFormatException, ParseException{
	int i=0;
	PreparedStatement ps = null;
	String str = "insert into USER1.NURSE_ENTRY values (?,?,?,?,?)";
	In_Patient_Student  st = InOutPatientDAO.FindRegUsr(String.valueOf(ope.getOp_No()));
	In_Patient_Employee  emp = InOutPatientDAO.FindInEmployee(String.valueOf(ope.getOp_No()));
	if(st!=null || emp!=null )
	{
		Main_Store pharmabase = DrugDAO.FindPharmaBase(ope.getDrug_Name()) ;
		if(pharmabase!=null)
		{
			int quantphar = pharmabase.getIn_store();
			int given = ope.getQuantity();
			if(quantphar>=given)
			{
				int totalphar = quantphar-given;
				Main_Store RealPharmaBase = new Main_Store(pharmabase.getDrug_name(), totalphar, pharmabase.getExpiry_Date_1(), pharmabase.getExpiry_Date_2());
				DrugDAO.UpdatePharmaBase(RealPharmaBase);
	try(Connection con= DBManager.getConnection();)
	{
		ps = con.prepareStatement(str);
		ps.setInt(1, ope.getOp_No());
		ps.setString(2,ope.getDrug_Name());
		
		ps.setString(3, ope.getMed_Given_date());
		ps.setString(4, ope.getTime());
		ps.setInt(5, ope.getQuantity());
		
	     i=  ps.executeUpdate();
	     
	    
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if(i==1)
    	return ("In Patient Medicine Inserted Successfuly");
    	else
    		return ("In Patient Medicine insert fail");
	
			}
			else
			{
				return("Insufficient Medicine in Pharma Base");
			}
	}
		else
		{
			return("Medicine is Not present In Pharma Base");
		}
	}
	

	
	

	
	else
	{
		return("Opno not found in IN patient DB");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	if(op!=null)
//	{
//		Main_Store pharmabase = DrugDAO.FindPharmaBase(ope.getDrug_Name()) ;
//		if(pharmabase!=null)
//		{
//			int quantphar = pharmabase.getIn_store();
//			int given = ope.getNo_Of_Drugs();
//			if(quantphar>=given)
//			{
//				int totalphar = quantphar-given;
//				Main_Store RealPharmaBase = new Main_Store(pharmabase.getDrug_name(), totalphar, pharmabase.getExpiry_Date_1(), pharmabase.getExpiry_Date_2());
//				DrugDAO.UpdatePharmaBase(RealPharmaBase);
//	try(Connection con= DBManager.getConnection();)
//	{
//		ps = con.prepareStatement(str);
//		ps.setInt(1, ope.getOp_No());
//		ps.setString(2,ope.getDrug_Name());
//		
//		ps.setString(3, ope.getDate());
//		ps.setInt(4, ope.getNo_Of_Drugs());
//		
//	     i=  ps.executeUpdate();
//	     
//	    
//	}catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	if(i==1)
//    	return ("Out Patient Medicine Inserted Successfuly");
//    	else
//    		return ("Out Patient Medicine insert fail");
//	
//			}
//			else
//			{
//				return("Insufficient Medicine in Pharma Base");
//			}
//	}
//		else
//		{
//			return("Medicine is Not present In Pharma Base");
//		}
//	}
//	
//	
//	
//	
//	else
//	{
//		return("This Opno is not present in Out Patient DB");
//	}

}
















	
	
	

}
