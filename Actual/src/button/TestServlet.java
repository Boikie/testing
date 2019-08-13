package button;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");



      RequestDispatcher rd=request.getRequestDispatcher("login.jsp");    

      rd.forward(request,response);  
  }

}	
