package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import Model.In_Patient_Employee;
import Model.In_Patient_Student;
import Model.Out_Patient;
import Model.RegisterUserModel;

public class InOutPatientDAO {
	
	public static String AddInStudent(In_Patient_Student ips) throws NumberFormatException, ParseException{
		int i=0;
		PreparedStatement ps = null;
		String str = "insert into USER1.IN_PATIENT_STUDENT values (?,?,?,?,?,?,?,?,?,?,?)";
		String pn = String.valueOf(ips.getOpNo());
		RegisterUserModel rum =  RegistrationDAO.FindRegUsr(pn);
		
		System.out.println("The rum is in DAO"+rum);
		if(rum==null)
		{
			return("No Registerd User Found With this OPno");
		}
		if(rum.getOpNo()==ips.getOpNo() && rum.getName().equalsIgnoreCase(ips.getName()) && rum.getType().equalsIgnoreCase("Student"))
		{		
		try(Connection con= DBManager.getConnection();)
		{
			ps = con.prepareStatement(str);
			ps.setInt(1, ips.getOpNo());
			ps.setString(2,ips.getName());
			
			ps.setInt(3, ips.getAge());
			ps.setString(4, ips.getSex());
			ps.setString(5, ips.getOccupation());
			ps.setString(6, ips.getDate_of_admission());
			ps.setString(7, ips.getDate_of_discharge());
			ps.setString(8,ips.getDiagnosis());
			ps.setString(9,ips.getPresent_complaint());
			ps.setString(10,ips.getPatient_history());
			ps.setString(11,ips.getDrugs_allergy());

		     i=  ps.executeUpdate();
		     
		    
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(i==1)
	    	return ("In Patient Student inserted successfully");
	    	else
	    		return ("In Patient Student insert fail");
		}
		else
		{
			return ("Somthing Went Wrong");
		}
		
	}	
		
		
		
		
		
		public static ArrayList<In_Patient_Student> DisplayInStudent(){
			//	System.out.println(id+"  "+password);
			 ArrayList<In_Patient_Student> ali = new ArrayList<In_Patient_Student>();
			
				String statement="select * from USER1.IN_PATIENT_STUDENT";
				try(Connection con=DBManager.getConnection()){
				
					Statement st=con.createStatement();
				
					ResultSet rs=st.executeQuery(statement);
				   
					while(rs.next()){
						In_Patient_Student ips = new In_Patient_Student(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
						System.out.println(ips.getName());
						ali.add(ips);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return ali;
			}
		
	
		
		
		public static In_Patient_Student FindRegUsr(String str) throws NumberFormatException, ParseException{
			
			System.out.println("You are in DAO"+str);
			String statement="select * from USER1.IN_PATIENT_STUDENT WHERE OPNO='"+Integer.parseInt(str)+"'";
			In_Patient_Student ms=null;
				try(Connection con=DBManager.getConnection()){
				
					Statement st=con.createStatement();
				
					ResultSet rs=st.executeQuery(statement);
					
					if(rs.next()){
						  ms = new In_Patient_Student(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
						  System.out.println(ms.getOpNo()+" "+ms.getName());
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return ms;
			}
		
		

		
	
		
		
		
		
		public static String AddInEmployeee(In_Patient_Employee ipe) throws NumberFormatException, ParseException{
			int i=0;
			PreparedStatement ps = null;
			//"insert into USER1.IN_PATIENT_STUDENT values (?,?,?,?,?,?,?,?,?,?,?)";
			String strr = "insert into USER1.IN_PATIENT_EMPLOYEE values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			String pn = String.valueOf(ipe.getOpNo());
			RegisterUserModel rum =  RegistrationDAO.FindRegUsr(pn);
			
			System.out.println("The rum is in DAO"+rum);
			if(rum==null)
			{
				return("No Registerd User Found With this OPno");
			}
			System.out.println(rum.getOpNo()==ipe.getOpNo());
			System.out.println(rum.getName().equalsIgnoreCase(ipe.getName()));
            System.out.println(rum.getType().equalsIgnoreCase("Employee"));
			if(rum.getOpNo()==ipe.getOpNo() && rum.getName().equalsIgnoreCase(ipe.getName()) && rum.getType().equalsIgnoreCase("Employee"))
			{		
			try(Connection con= DBManager.getConnection())
			{
				System.out.println(ipe.getOpNo()+" "+ipe.getName()+" "+ipe.getAge()+" "+ipe.getSex()+" "+ipe.getOccupation()+" "+ipe.getDate_of_admission()+" "+ipe.getDate_of_discharge()+" "+ipe.getDiagnosis()+" "+ipe.getPresent_complaints()+" "+ipe.getPatient_history()+" "+ipe.getDrug_allergy()+" "+ipe.getBed_charges()+" "+ipe.getXray_charges()+" "+ipe.getBilling());
				System.out.println("You are here Welcome");
				ps = con.prepareStatement(strr);
			
				ps.setInt(1, ipe.getOpNo());
				ps.setString(2,ipe.getName());
				
				ps.setInt(3, ipe.getAge());
				ps.setString(4, ipe.getSex());
				ps.setString(5, ipe.getOccupation());
				ps.setString(6, ipe.getDate_of_admission());
				ps.setString(7, ipe.getDate_of_discharge());
				ps.setString(8,ipe.getDiagnosis());
				ps.setString(9,ipe.getPresent_complaints());
				ps.setString(10,ipe.getPatient_history());
				ps.setString(11,ipe.getDrug_allergy());
				ps.setDouble(12,ipe.getBed_charges());
				ps.setDouble(13,ipe.getXray_charges());
				ps.setDouble(14,ipe.getBilling());

			     i=  ps.executeUpdate();
			     
			    
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(i==1){
		    	return ("In Patient Student inserted successfully");
			}
		    else{
		    	return ("In Patient Student insert fail");
		    }
			}
			else
			{
				return ("patient is not present in registered DB");
			}
			
		}	
			
			
		
	
		
		
		public static ArrayList<In_Patient_Employee> DisplayInEmployee(){
			//	System.out.println(id+"  "+password);
			 ArrayList<In_Patient_Employee> ali = new ArrayList<In_Patient_Employee>();
			
				String statement="select * from USER1.IN_PATIENT_EMPLOYEE";
				try(Connection con=DBManager.getConnection()){
				
					Statement st=con.createStatement();
				
					ResultSet rs=st.executeQuery(statement);
				   
					while(rs.next()){
						In_Patient_Employee ipe = new In_Patient_Employee(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getDouble(12),rs.getDouble(13),rs.getDouble(14));
						System.out.println(ipe.getName());
						ali.add(ipe);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return ali;
			}
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		public static In_Patient_Employee FindInEmployee(String str) throws NumberFormatException, ParseException{
			
			System.out.println("You are in DAO"+str);
			String statement="select * from USER1.IN_PATIENT_EMPLOYEE WHERE OPNO='"+Integer.parseInt(str)+"'";
			In_Patient_Employee ms=null;
				try(Connection con=DBManager.getConnection()){
				
					Statement st=con.createStatement();
				
					ResultSet rs=st.executeQuery(statement);
					
					if(rs.next()){
						  ms = new In_Patient_Employee(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getDouble(12),rs.getDouble(13),rs.getDouble(14));
						  System.out.println(ms.getOpNo()+" "+ms.getName());
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return ms;
			}
		
		

		
	
		
		
		
		
		

		public static String AddOutPatient(Out_Patient op) throws NumberFormatException, ParseException{
			int i=0;
			PreparedStatement ps = null;
			String str = "insert into USER1.OUT_PATIENT values (?,?,?,?,?,?,?,?)";
			String pn = String.valueOf(op.getOp_No());
			RegisterUserModel rum =  RegistrationDAO.FindRegUsr(pn);
			
			System.out.println("The rum is in DAO"+rum);
			if(rum==null)
			{
				return("No Registerd User Found With this OPno");
			}
			if(rum.getOpNo()==op.getOp_No() && rum.getName().equalsIgnoreCase(op.getName()) && rum.getType().equalsIgnoreCase(op.getType()))
			{		
			try(Connection con= DBManager.getConnection();)
			{
				ps = con.prepareStatement(str);
				ps.setInt(1, op.getOp_No());
				ps.setString(2,op.getName());
				
				ps.setInt(3, op.getAge());
				ps.setString(4, op.getType());
				ps.setString(5, op.getDate_of_admission());
				ps.setString(6, op.getSex());
				ps.setString(7, op.getDiagnosis());
				ps.setString(8,op.getTreatment());

			     i=  ps.executeUpdate();
			     
			    
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(i==1)
		    	return ("Out Patient inserted successfully");
		    	else
		    		return ("Out Patient insert fail");
			}
			else
			{
				return ("Somthing Went Wrong");
			}
			
		}	
			
			
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		public static ArrayList<Out_Patient> DisplayOutPatient(){
			//	System.out.println(id+"  "+password);
			 ArrayList<Out_Patient> ali = new ArrayList<Out_Patient>();
			
				String statement="select * from USER1.OUT_PATIENT";
				try(Connection con=DBManager.getConnection()){
				
					Statement st=con.createStatement();
				
					ResultSet rs=st.executeQuery(statement);
				   
					while(rs.next()){
						Out_Patient op = new Out_Patient(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
						System.out.println(op.getName());
						ali.add(op);
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return ali;
			}
		
	
		
		
		
	
		
		
		
	
		
		
		public static Out_Patient FindOutPatient(String str) throws NumberFormatException, ParseException{
			
			System.out.println("You are in DAO"+str);
			String statement="select * from USER1.OUT_PATIENT WHERE OPNO='"+Integer.parseInt(str)+"'";
			Out_Patient ms=null;
				try(Connection con=DBManager.getConnection()){
				
					Statement st=con.createStatement();
				
					ResultSet rs=st.executeQuery(statement);
					
					if(rs.next()){
						  ms = new Out_Patient(rs.getInt(1), rs.getString(2),rs.getInt(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
						  System.out.println(ms.getOp_No()+" "+ms.getName());
						
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return ms;
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}
	
	


