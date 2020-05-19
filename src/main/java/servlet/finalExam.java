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

//stores strings to print for truth table
static String output = "";

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

   //N is the number of clauses you have
   int num_clauses = 0;

   //find number of clauses
   for (String s: parameters) {
     //as long as s is not an operator, increment it
     if (!s.equals("AND") && !s.equals("and") && !s.equals("&") && !s.equals("&&") && !s.equals("OR") && !s.equals("or") && !s.equals("||") && !s.equals("|")) {
       num_clauses += 1;
     }
   }

   //get all the clauses from user input
   String[] clauses = new String[num_clauses];
   int i = -1;
   for (String s: parameters) {
     //as long as s is not an operator, increment it
     if (!s.equals("AND") && !s.equals("and") && !s.equals("&") && !s.equals("&&") && !s.equals("OR") && !s.equals("or") && !s.equals("||") && !s.equals("|")) {
       i += 1;
       clauses[i] = s;
     }
   }

   //gets string for truth table
   printTruthTable(num_clauses, 0, new int[num_clauses]);

   String[] truth_table = output.split("\\s+");

   PrintResponse(out, input, clauses, truth_table, num_clauses);
   out.close();

   output = "";
}  // End doPost

//print the truth table
public void printTruthTable(int N, int index, int[] truthVals) {
   if (index == N) {
      for (int i=0; i<N; i++) {
         output += truthVals[i] + " ";
       }
      output += "\n";
   }
   else {
      for (int i=0; i<2; i++) {
         truthVals[index] = i;
         printTruthTable(N, index + 1, truthVals);
      }
   }
}

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
   out.println("For the AND logical operator you can use AND, and, &, &&.");
   out.println(" <br>");
   out.println("For example -- A AND B & C && D and E -- is acceptable.");
   out.println("<br>");
   out.println("<br>");
   out.println("For the OR logical operator you can use OR, or, |, ||.");
   out.println("<br>");
   out.println("For example -- A OR B | C || D or E -- is acceptable.");
   out.println("<br>");
   out.println(" <br>");
   out.println("</p>");
   out.println("<form method=\"post\"");
   out.println(" action=\"https://" + Domain + Path + Servlet + "\">");
   out.println("");
   out.println(" <table>");
   out.println("  <tr>");
   out.println("   <td><b>Input:</b>");
   out.println("   <td><input type=\"text\" name=\"predicate\" value=\"" + input + "\" size=10>");
   out.println("  </tr>");
   out.println(" </table>");
   out.println(" <br>");
   out.println(" <br>");
   out.println(" <input type=\"submit\" value=\"" + Submit + "\" name=\"submission\" style=\"width: 10%; height: 4%; font-size: 15px;\">");
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
 *  Prints the output (truth table)
********************************************************* */
private void PrintResponse (PrintWriter out, String input, String[] clauses, String[] truth_table, int num_clauses)
{
  out.println("<html>");
  out.println("  <head>");
  out.println("  <title>Responses</title>");
  out.println("		<style> ");
  out.println("   table, th, td {padding: 5px; border: 1px solid black; border-collapse: collapse; font: 15px; table-layout: fixed; width: 98%; background-color: #F5FFFA;}");
  out.println("			body {background-color:#E1F3DB}");
  out.println("		</style>");
  out.println("  </head>");
  out.println("  <body>");
  out.println("<h3>Below is a complete truth table for your predicate.</h3>");
  out.println("  <p>");
  out.println("     </br>");
  out.println("     User's Predicate: " + input + "");
  out.println("  </br>");
  out.println("  </br>");
  out.println("" + output + "");
  out.println("  </br>");
  out.println("  </br>");

  out.println("<table align=\"left\">");

  //to print out clauses for table headers
  out.println("<tr>");
  for (String clause : clauses) {
    out.println("<th style=\"background-color:lightseagreen\" align=\"center\"><b>" + clause + "#</b></td>");
  }
  out.println("</tr>");

  //to print out actual truth values
  out.println("<tr>");
  int i = 0;
  for (String truth_value : truth_table) {
    out.println("<td>" + truth_value + "</td>");
    i += 1;
    //move to the next row
    if (i == num_clauses && i != truth_table.length) {
      out.println("</tr>");
      out.println("<tr>");
    }
  }
  out.println("</tr>");

  out.println("</table>");

  out.println("  </body>");

  out.println("</html>");


}

}  // End Final Exam
