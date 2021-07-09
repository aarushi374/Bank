
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.util.ArrayList;
//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    if(request.getParameter("customer")!=null)
	    {
	    	PrintWriter out = response.getWriter();  
	        response.setContentType("text/html"); 
	        out.println("<html lang=\"en\">\r\n"
	        		+ "<head>\r\n"
	        		+ "<meta charset=\"UTF-8\">\r\n"
	        		+"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
	        		+ "<title>Customers</title>\r\n"
	        	    +"<script src=\"https://kit.fontawesome.com/1a87f1ecb3.js\" crossorigin=\"anonymous\"></script>\r\n"
	        	    + "		<link rel=\"stylesheet\"href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\"integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\"crossorigin=\"anonymous\" />\r\n"
	        	    + "		<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\"integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\"crossorigin=\"anonymous\"></script>\r\n"
	        	    + "		<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\"integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\"crossorigin=\"anonymous\"></script>\r\n"
	        	    + "		<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\"integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\"crossorigin=\"anonymous\"></script>\r\n"
	        	    + "		<script src=\"https://code.jquery.com/jquery-3.5.1.js\"integrity=\"sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=\"crossorigin=\"anonymous\"></script>\r\n"
	        	    + "  <script type=\"text/javascript\" src=\"JsFile.js\"></script>\r\n"
	        	    + "  <link rel=\"stylesheet\" href=\"Customers.css\">"
	        		+ "</head>\r\n"
	        		+ "<body class='body'><section>\r\n"
	        		+ "<nav>\r\n"
	        		+" <h1>Citizen Bank</h1>\r\n"
	        		+ "<button class=\"active\"><i class=\"fas fa-user\"></i></button>"
	        		+ "<button onclick=\"location.href = './HomePage.html';\"><i class=\"fas fa-home\"></i></button></nav>\r\n"  
	        		+ "<p class=\"name\">Customers</p>\r\n"
	        		+ "<table border=1 class='deco' id=\"GFGtable\">\r\n"
	        		+ "<tr><th>Account No.</th><th>Name</th><th>Email</th><th>Balance</th><th>Details</th></tr>");
		       try {
		    	   Connection con=DBconnection.initializeDatabase();
		    	   Statement stmt = con.createStatement();  
		            ResultSet rs = stmt.executeQuery("select * from customers");  
		            String acc=null,name=null,balance=null,email=null;
		            while(rs.next())
		            {
		                        acc = rs.getString("acc");
		                        name = rs.getString("name");
		                        balance=rs.getString("balance");
		                        email=rs.getString("email");
		                        out.println("<tr><td class=\"gfgusername\">" + acc + "</td><td class=\"gfgpp\">" + name + "</td><td>" + email + "</td><td class=\"gfgscores\">"+ balance+"</td><td><button class=\"gfgselect btn-purple\" data-toggle=\"modal\" data-target=\"#gfgmodal\">Select</button></td></tr>"); 
		                    
		                }
		             
		            out.println("</table></section>");
		            
		            out.println("<div class=\"modal fade\" id=\"gfgmodal\" tabindex=\"-1\"	role=\"dialog\">\r\n"
		            		+ "			<div class=\"modal-dialog\">\r\n"
		            		+ "				<div class=\"modal-content\">\r\n"
		            		+ "					<div class=\"modal-header\">\r\n"
		            		+ "						<h2 class=\"modal-title\" id=\"gfgmodallabel\">Customer Details</h2>\r\n"
		            		+ "						<button type=\"button\"class=\"close\"data-dismiss=\"modal\" aria-label=\"Close\">\r\n"
		            		+ "							<span aria-hidden=\"true\">×</span>\r\n"
		            		+ "						</button>\r\n"
		            		+ "					</div>\r\n"
		            		+ "					<div class=\"modal-body\">\r\n"
		            		+ "						<div class=\"GFGclass\"id=\"divGFG\"></div>\r\n"
		            		+ "						<div class=\"modal-footer\">\r\n"
		            		+ "							<button type=\"button\"class=\"btn btn-purple\"data-dismiss=\"modal\" onclick=\"show()\">Transfer Money</button>\r\n"
		            		+ "						</div></div></div></div></div></body></html>");  
		            
		            // Close all the connections
		            stmt.close();
		            con.close();  
		           }  
		            catch (Exception e) 
		           {  
		            e.printStackTrace(); 
		        }
	    		    }
	    else if(request.getParameter("transaction")!=null)
	    {
	    	PrintWriter out = response.getWriter();  
	        response.setContentType("text/html"); 
	        out.println("<html lang=\"en\">\r\n"
	        		+ "<head>\r\n"
	        		+ "<meta charset=\"UTF-8\">\r\n"
	        		+"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
	        		+ "<title>Transaction</title>\r\n"
	        	    +"<script src=\"https://kit.fontawesome.com/1a87f1ecb3.js\" crossorigin=\"anonymous\"></script>\r\n"
	        	    + "  <link rel=\"stylesheet\" href=\"Customers.css\">"
	        		+ "</head>\r\n"
	        		+ "<body class='body'><section>\r\n"
	        		+"<nav>\r\n"
	        		+" <h1>Citizen Bank</h1>\r\n"
	        		+ "      <button class=\"active\"><i class=\"fas fa-comments-dollar\"></i></button>\r\n"
	        		+ "      <button onclick=\"location.href = './HomePage.html';\"><i class=\"fas fa-home\"></i></button>\r\n"
	        		+ "  </nav>"
	        		+ "<p class=\"name\">Transactions</p>\r\n"
	        		+ "<table border=1 class='deco'>\r\n"
	        		+ "<tr><th>From</th><th>To</th><th>Transfer_Amount</th><th>Date/Time</th></tr>");
		       try {
		    	   Connection con=DBconnection.initializeDatabase();
		    	   Statement stmt = con.createStatement();  
		            ResultSet rs = stmt.executeQuery("select * from transfer");  
		            String to=null,from=null,amt=null,date=null;
		            while(rs.next())
		            {
		                        to = rs.getString("to");
		                        from = rs.getString("from");
		                        amt=rs.getString("amt");
		                        date=rs.getString("time");
		                        out.println("<tr><td>" + from + "</td><td>" + to + "</td><td>"+ amt + "</td><td>"+date+"</td></tr>"); 
		                    
		                }
		             
		            out.println("</table></section></body></html>");
		      
		            // Close all the connections
		            stmt.close();
		            con.close();  
		           }  
		            catch (Exception e) 
		           {  
		            e.printStackTrace(); 
		        }
	    }
			}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		DAO dao = new DAO();
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		if(request.getParameter("submit")!=null)
		{
			String to=request.getParameter("to");
			String from=request.getParameter("from");
			int amt=Integer.parseInt(request.getParameter("amount"));
			if(to.equals(from))
			{
				String someMessage = "PLZ PUT VALID INFO";
				out.println("<script type='text/javascript'>");
				out.println("alert(" + "'" + someMessage + "'" + ");window.location.href='./HomePage.html';</script>");

			}
			else
			{
				Customer c=new Customer(to,from,amt);
				String result=dao.check_amount(c);
					out.println("<script type='text/javascript'>");
					out.println("alert(" + "'" + result + "'" + ");window.location.href='./HomePage.html';</script>"); 
					//response.sendRedirect("./HomePage.html");
				}
				
			}
			}
				
	}

