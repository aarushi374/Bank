import java.sql.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
public class DAO {
	public String check_amount(Customer customer) 
	{

		Connection con = DBconnection.initializeDatabase();


		String result = "NOT ENOUGH BALANCE IN THE ACCOUNT!!";
		 //String result=customer.getFrom();

	try {       
		//Statement stmt1=con.createStatement();
		String sql="select * from customers where name=?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, customer.getFrom());
        ResultSet rs = st.executeQuery();
        if(rs.next())
        {
        int bal=Integer.parseInt(rs.getString("balance"));
        if(customer.getAmt()<bal)
        {
            result="TRANSACTION SUCCESSFUL";
            deposit(customer);
            withdrawl(customer);
            transfer(customer);
         }
        }
    rs.close ();
    //rs1.close();	

	} catch (Exception e) {

		// TODO Auto-generated catch block

		//e.printStackTrace();

		result = e.toString();

	}

	return result;
}
	public void deposit(Customer customer)
	{
		Connection con = DBconnection.initializeDatabase();
		String sql_1 = "update customers set balance =? where name= ?";
   		PreparedStatement ps;
       try {
   		ps = con.prepareStatement(sql_1);
		Statement stmt2=con.createStatement();
        ResultSet rs1 = stmt2.executeQuery("select balance from customers where name='"+customer.getTo()+"'"); 
        while(rs1.next())
        {
        	int bal=rs1.getInt("balance")+customer.getAmt();
   		    ps.setInt(1, bal);
 	        ps.setString(2, customer.getTo());
 	        ps.executeUpdate();

       }
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
	}
	public void withdrawl(Customer customer)
	{
		Connection con = DBconnection.initializeDatabase();
		String sql_1 = "update customers set balance =? where name= ?";
   		PreparedStatement ps;
       try {
   		ps = con.prepareStatement(sql_1);
		Statement stmt2=con.createStatement();
        ResultSet rs1 = stmt2.executeQuery("select * from customers where name='"+customer.getFrom()+"'"); 
        while(rs1.next())
        {
   		int bal=Integer.parseInt(rs1.getString("balance"))-customer.getAmt();
        	 ps.setInt(1, bal);
 	        ps.setString(2, customer.getFrom());
 	        ps.executeUpdate();

       }
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
	}
	public void transfer(Customer customer)
	{
		Connection con = DBconnection.initializeDatabase();
		String sql_1 = "insert into transfer values(?,?,?,?)";
   		PreparedStatement ps;
   		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy H:mm a");  
   	   LocalDateTime now = LocalDateTime.now();  
	 	try
	 	{
	 		ps=con.prepareStatement(sql_1);
	 		ps.setString(1, customer.getFrom());
	 		ps.setString(2, customer.getTo());
	 		ps.setInt(3, customer.getAmt());
	 		ps.setString(4, dtf.format(now));
	 		ps.executeUpdate();
	 	}
	 	catch(Exception e)
	 	{
	 		e.printStackTrace();
	 	}
	}
	
}