package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDataServlet
 */
public class Connect extends HttpServlet {

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String FullName = request.getParameter("FullName");
  String Username = request.getParameter("Username");
  String Age = request.getParameter("Age");
  String MobileNumber = request.getParameter("MobileNumber");
  String City = request.getParameter("City");
  String Address = request.getParameter("Address");
  String Password = request.getParameter("Password");
 

  // validate given input
  if (FullName.isEmpty() || Username.isEmpty() || Age.isEmpty() || MobileNumber.isEmpty() || City.isEmpty() || Address.isEmpty() || Password.isEmpty()) {
   RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
   out.println("<font color=red>Please fill all the fields</font>");
   rd.include(request, response);
  } else {
   // inserting data into mysql database 
   try {
    Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logindemo", "root", ""); 

    
    String query1 = "insert into `login`( `Username`, `Password`) values(?,?)";
    PreparedStatement ps1 = con.prepareStatement(query1);
    ps1.setString(1, Username);
    ps1.setString(2, Password);
    ps1.executeUpdate(); // execute it on test database
    System.out.println("successfuly inserted into login table");
    ps1.close();
    
    
    String query = "INSERT into `registered`(`FullName`, `Username`, `Age`, `MobileNumber`, `City`, `Address`, `Password`) VALUES (?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement ps = con.prepareStatement(query); // generates sql query

    ps.setString(1, FullName);
    ps.setString(2, Username);
    ps.setInt(3, Integer.parseInt(Age));
    ps.setString(4, MobileNumber);
    ps.setString(5, City);
    ps.setString(6, Address);
    ps.setString(7, Password);

    ps.executeUpdate(); // execute it on test database
    System.out.println("successfuly inserted");
    ps.close();
    con.close();
    
   } catch (ClassNotFoundException | SQLException e) {
    // TODO Auto-generated catch block
    System.out.println(e.getMessage());
   }
   RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
   rd.forward(request, response);
  }
 }
}
