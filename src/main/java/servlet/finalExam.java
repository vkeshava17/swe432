/** *****************************************************************
    finalExam.java   servlet example

        @author Vandana Keshavamurthy
********************************************************************* */

// Import Java Libraries
import java.io.*;
import java.util.*;

//Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet( name = "finalExam", urlPatterns = {"/finalExam"} )

public class finalExam extends HttpServlet
{

// Location of servlet.
static String Domain  = "swe432vkeshava.herokuapp.com";
static String Path    = "/";
static String Servlet = "finalExam";

// Button labels
static String Submit = "Submit";

// Other strings.
static String Style ="https://www.cs.gmu.edu/~offutt/classes/432/432-style.css";

/** *****************************************************
 *  Overrides HttpServlet's doPost().
 *  Converts the values in the form, performs the operation
 *  indicated by the submit button, and sends the results
 *  back to the client.
********************************************************* */
public void doPost (HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
{
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();

   String input = request.getParameter("predicate");

   String[] parameters = input.split("\\s+");
   PrintResponse(out, parameters);
   out.close();
}  // End doPost

/** *****************************************************
 *  Overrides HttpServlet's doGet().
 *  Prints an HTML page with a blank form.
********************************************************* */
public void doGet (HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException
{
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   PrintHead(out);
   PrintBody(out);
   PrintTail(out);
} // End doGet

/** *****************************************************
 *  Prints the <head> of the HTML page, no <body>.
********************************************************* */
private void PrintHead (PrintWriter out)
{
   out.println("<html>");
   out.println("");

   out.println("<head>");
   out.println("<title>Final Exam</title>");
   out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"" + Style + "\">");
   out.println("		<style> ");
   out.println("			body {background-color:#E1F3DB}");
   out.println("		</style>");
   out.println("</head>");
   out.println("");
} // End PrintHead

/** *****************************************************
 *  Prints the <BODY> of the HTML page with the form data
 *  values from the parameters.
********************************************************* */
private void PrintBody (PrintWriter out, String input)
{
   out.println("<body>");
   out.println("<p>");
   out.println("Name: Vandana Keshavamurthy");
   out.println(" <br>");
   out.println("<h3> Please enter your boolean predicate below and click submit when done. </h3>");
   out.println(" <br>");
   out.println("For the AND logical operator you can use AND, &, &&.");
   out.println(" <br>");
   out.println("For example -- A AND B & C && D -- is acceptable.");
   out.println("<br>");
   out.println("<br>");
   out.println("For the OR logical operator you can use OR, |, ||.");
   out.println("<br>");
   out.println("For example -- A OR B | C || D -- is acceptable.");
   out.println("<br>");
   out.println(" <br>");
   out.println("For example: X OR B");
   out.println(" <br>");
   out.println("</p>");
   out.print  ("<form method=\"post\"");
   out.println(" action=\"https://" + Domain + Path + Servlet + "\">");
   out.println("");
   out.println(" <table>");
   out.println("  <tr>");
   out.println("   <td>Input:");
   out.println("   <td><input type=\"text\" name=\"predicate\" value=\"" + input + "\" size=5>");
   out.println("  </tr>");
   out.println(" </table>");
   out.println(" <br>");
   out.println(" <br>");
   out.println(" <input type=\"submit\" value=\" style=\"width: 10%; height: 4%; font-size: 13px;\"" + Submit + "\" name=\"submission\">");
   out.println("</form>");
   out.println("");
   out.println("</body>");
} // End PrintBody

/** *****************************************************
 *  Overloads PrintBody (out,lhs,rhs,rslt) to print a page
 *  with blanks in the form fields.
********************************************************* */
private void PrintBody (PrintWriter out)
{
   PrintBody(out, "");
}

/** *****************************************************
 *  Prints the bottom of the HTML page.
********************************************************* */
private void PrintTail (PrintWriter out)
{
   out.println("");
   out.println("</html>");
} // End PrintTail

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
  out.println("</html>");
}

}  // End Final Exam
