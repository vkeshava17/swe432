/** *****************************************************************
assignment8part2.java
********************************************************************* */

// Import Java Libraries
import java.io.*;
import java.util.*;

//Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet( name = "assignment8part2", urlPatterns = {"/asst8part2"} )

public class assignment8part2 extends HttpServlet
{
  // Location of servlet.
  static String Domain  = "swe432vkeshava.herokuapp.com";
  static String Path    = "/";
  static String Servlet = "asst8part2";

  // Other strings.
  static String Style ="https://www.cs.gmu.edu/~offutt/classes/432/432-style.css";

  /** *****************************************************
  *  Overrides HttpServlet's doGet().
  ********************************************************* */
  public void doGet (HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException
  {
    String Q1 = request.getParameter("commonQ1");
    String Q2 = request.getParameter("commonQ2");
    String Q3 = request.getParameter("commonQ3");
    String Q4 = request.getParameter("commonQ4");
    String Q5 = request.getParameter("commonQ5");
    String allSubmissions = request.getParameter("allSubmissions");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
		PrintMain(out, Q1, Q2, Q3, Q4, Q5, allSubmissions);
    out.close();

  } // End doGet

private void PrintMain (PrintWriter out, String Q1, String Q2, String Q3, String Q4, String Q5, String allLines) // main index.html
{
	    out.println("<html>");
      out.println("<head>");
      out.println(" <title>Aggregate Summary of all Reviews</title>");
      out.println("		<style> ");
   		out.println("			body {background-color:#E1F3DB}");
   		out.println("		</style>");
      out.println("  <h1 align=\"center\">Aggregate Summary of all Reviews</h1>");
      out.println("</head>");
      out.println("");
      out.println("<body>");

			out.println("<table align=\"center\">");
  		out.println("<tr>");
   		out.println("<th style=\"background-color:darkblue\" align=\"center\"><b>Submission #</b></td>");
   		out.println("<th style=\"background-color:darkblue\" align=\"center\"><b>Major</b></td>
  		out.println("<th style=\"background-color:darkblue\" align=\"center\"><b>Year</b></td>");
   		out.println("<th style=\"background-color:darkblue\" align=\"center\"><b>Q1</b></td>");
   		out.println("<th style=\"background-color:darkblue\" align=\"center\"><b>Q2</b></td>");
   		out.println("<th style=\"background-color:darkblue\" align=\"center\"><b>Q3</b></td>");
   		out.println("<th style=\"background-color:darkblue\" align=\"center\"><b>Q4</b></td>");
      out.println("<th style=\"background-color:darkblue\" align=\"center\"><b>Q5</b></td>");
   		out.println("<th style=\"background-color:darkblue\" align=\"center\"><b>Additional Comments</b></td>");
  		out.println("</tr>");

			out.println("<tr>");
			out.println("<td style=\"background-color:#E1F3DB; border-left-color:#E1F3DB; border-bottom-color:#E1F3DB;\"></td>);
      out.println("<td style=\"background-color:#E1F3DB; border-left-color:#E1F3DB; border-bottom-color:#E1F3DB;\"></td>);
			out.println("<td style=\"background-color:gold\">Most Common Responses</td>");
			out.println("<td style=\"background-color:gold\">" + Q1 + "</td>");
			out.println("<td style=\"background-color:gold\">" + Q2 + "</td>");
			out.println("<td style=\"background-color:gold\">" + Q3 + "</td>");
			out.println("<td style=\"background-color:gold\">" + Q4 + "</td>");
			out.println("<td style=\"background-color:gold\">" + Q5 + "</td>");
			out.println("<td style=\"background-color:#E1F3DB; border-color:#E1F3DB;\"></td>");
			out.println("</tr>");
      out.println("</table>");

      out.println("<p>" + Q1 + "</p>");
      out.println("<p>" + Q2 + "</p>");
      out.println("<p>" + Q3 + "</p>");
      out.println("<p>" + Q4 + "</p>");
      out.println("<p>" + Q5 + "</p>");
      out.println("<p>" + allSubmissions + "</p>");

      out.println("</body>");
      out.println("</html>");
}

}  // End assignment 8 part 2
