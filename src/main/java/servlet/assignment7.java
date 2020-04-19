/** *****************************************************************
    assignment7.java
********************************************************************* */

// Import Java Libraries
import java.io.*;
import java.util.*;

//Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet( name = "assignment7", urlPatterns = {"/asst7"} )

public class assignment7 extends HttpServlet
{

// Location of servlet.
static String Domain  = "swe432vkeshava.herokuapp.com";
static String Path    = "/";
static String Servlet = "asst7";

// Other strings.
static String Style ="https://www.cs.gmu.edu/~offutt/classes/432/432-style.css";

/** *****************************************************
 *  Overrides HttpServlet's doPost().
********************************************************* */
public void doPost (HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
{
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();

   String Major = request.getParameter("Major");
   String Year = request.getParameter("Year");
   String Q1 = request.getParameter("Q1");
   String Q2 = request.getParameter("Q2");
   String Q3 = request.getParameter("Q3");
   String Q4 = request.getParameter("Q4");
   String Q5 = request.getParameter("Q5");
   String Comments = request.getParameter("Comments");

   String[] parameters = {Major, Year, Q1, Q2, Q3, Q4, Q5, Comments};

   PrintResponse(out, parameters);
   out.close();
}  // End doPost



/** *****************************************************
 *  Prints the form data's html
********************************************************* */
private void PrintResponse (PrintWriter out, String[] parameters) // response to survey html
{
   out.println("<html>");
   out.println("  <head>");
   out.println("  <title>Responses</title>");
   out.println("  <style> ");
   out.println("    body {background-color:#E1F3DB}");
   out.println("  </style>");
   out.println("  </head>");
   out.println("  <body>");
   out.println("  <p>");
   out.println("  Assignment 6");
   out.println("     </br>");
   out.println("     Developed by: Satyasaarika Putla, Vandana Keshavamurthy");
   out.println("     </br>");
   out.println("     For our collaboration summary, click");
   out.println("     <a href=\"http://mason.gmu.edu/~vkeshava\">here</a>");
   out.println("  <h1 align=\"center\">User Responses</h1>");
   out.println("  </br>");

   out.println("  The table below shows the responses you have submitted.");
   out.println("  </br>");
   out.println("  </br>");

   out.println("	<table border=\"2\" width=\"75%\" align=\"left\" cellSpacing=\"1\" cellPadding=\"1\">");

   out.println("    <tr>");
   out.println("      <th>Questions</th>");
   out.println("       <th>Submitted Responses</th>");
   out.println("    </tr>");

   out.println("  <tr>");
   out.println("    <td>Major</td>");
   out.println("    <td>" + parameters[0] + "</td>");
   out.println("  </tr>");

   out.println("  <tr>");
   out.println("    <td>Year</td>");
   out.println("    <td>" + parameters[1] + "</td>");
   out.println("  </tr>");

   out.println("  <tr>");
   out.println("    <td>Q1: How easy was it for you to find your textbooks in the store?</td>");
   out.println("    <td>" + parameters[2] + "</td>");
   out.println("  </tr>");

   out.println("  <tr>");
   out.println("    <td>Q2: How many times were the textbooks you needed (digital or hard copy) out of stock?</td>");
   out.println("    <td>" + parameters[3] + "</td>");
   out.println("  </tr>");

   out.println("  <tr>");
   out.println("    <td>Q3: How reasonable do you think the textbook prices were compared to other sellers?</td>");
   out.println("    <td>" + parameters[4] + "</td>");
   out.println("  </tr>");

   out.println("  <tr>");
   out.println("    <td>Q4: If given the option, do you prefer digital or hard copy textbooks? </td>");
   out.println("    <td>" + parameters[5] + "</td>");
   out.println("  </tr>");

   out.println("  <tr>");
   out.println("    <td>Q5: How accurate are the recommended and required textbook lists that the bookstore provides online?</td>");
   out.println("    <td>" + parameters[6] + "</td>");
   out.println("  </tr>");

   out.println("  <tr>");
   out.println("    <td>Additional Comments</td>");
   out.println("    <td>" + parameters[7] + "</td>");
   out.println("  </tr>");

   out.println("</table>");
   out.println("</body>");
   out.println("</html>");

}

}
