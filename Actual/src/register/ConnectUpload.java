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
public class ConnectUpload extends HttpServlet {

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String Name = request.getParameter("Name");
  String Genre = request.getParameter("Genre");
  String Publisher = request.getParameter("Publisher");
  String ISBN = request.getParameter("ISBN");
  String Author = request.getParameter("Author");
  String Edition = request.getParameter("Edition");
 

  // validate given input
  if (Name.isEmpty() || Genre.isEmpty() || Publisher.isEmpty() || ISBN.isEmpty() || Author.isEmpty() || Edition.isEmpty() ) {
   RequestDispatcher rd = request.getRequestDispatcher("uploadBooks.jsp");
   out.println("<font color=red>Please fill all the fields</font>");
   rd.include(request, response);
   
  } else {
   // inserting data into mysql database \
	
   try {
    Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/logindemo", "root", "");
    
   
    
    String query = "INSERT INTO `allbooks`( `Name`, `Genre`, `Publisher`, `ISBN`, `Author`, `Edition`) VALUES(?,?,?,?,?,?)";
    PreparedStatement ps = con.prepareStatement(query); // generates sql query

    ps.setString(1, Name);
    ps.setString(2, Genre);
    ps.setString(3, Publisher);
    ps.setString(4, ISBN);
    ps.setString(5, Author);
    ps.setString(6, Edition);
    
    ps.executeUpdate(); // execute it on test database
    System.out.println("successfuly inserted");
    ps.close();
    con.close();
   } catch (ClassNotFoundException | SQLException e) {
    // TODO Auto-generated catch block
    //e.printStackTrace();
    System.out.println(e.getMessage());
   
   }
   
   RequestDispatcher rd = request.getRequestDispatcher("ViewAllBooks.jsp");
   rd.forward(request, response);
   
  }

 }
}
