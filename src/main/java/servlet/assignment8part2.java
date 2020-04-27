/** *****************************************************************
assignment8prt2.java
********************************************************************* */

// Import Java Libraries
import java.io.*;
import java.util.*;

//Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet( name = "assignment8part2", urlPatterns = {"/asst8prt2"} )

public class assignment8part2 extends HttpServlet
{
  // Location of servlet.
  static String Domain  = "swe432vkeshava.herokuapp.com";
  static String Path    = "/";
  static String Servlet = "asst8prt2";

  // Other strings.
  static String Style ="https://www.cs.gmu.edu/~offutt/classes/432/432-style.css";

  /** *****************************************************
  *  Overrides HttpServlet's doGet().
  ********************************************************* */
  public void doGet (HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException
  {
    //response.setContentType("text/html");
    String Q1 = request.getParameter("commonQ1");
    String Q2 = request.getParameter("commonQ2");
    String Q3 = request.getParameter("commonQ3");
    String Q4 = request.getParameter("commonQ4");
    String Q5 = request.getParameter("commonQ5");

    //PrintWriter out = response.getWriter();
    //PrintMain(out);
    //out.close();
    if (Q1 != null){
    	// Called from the invalidate button, kill the session.
      // Get session object

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      out.println("<html>");
      out.println("<head>");
      out.println(" <title>Aggregate Summary of all Reviews</title>");
      out.println("  <h1 align=\"center\">Aggregate Summary of all Reviews</h1>");
      out.println("</head>");
      out.println("");
      out.println("<body>");

      out.println("<p>" + Q1 + "</p>");
      out.println("<p>" + Q2 + "</p>");
      out.println("<p>" + Q3 + "</p>");
      out.println("<p>" + Q4 + "</p>");
      out.println("<p>" + Q5 + "</p>");

      out.println("</body>");
      out.println("</html>");
      out.close();
   }

  } // End doGet

}  // End assignment 8 part 2
