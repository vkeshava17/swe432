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

   //get input
   String input = request.getParameter("predicate");
   String output_choice = "";
   output_choice = request.getParameter("truth_value");

   //remove all parenthesis from string if they exist
   String input_cleaned = input.replaceAll("[()]", "");

   String[] parameters = input_cleaned.split("\\s+");

   //N is the number of clauses you have
   int num_clauses = 0;

   //find number of clauses
   for (String s : parameters) {
     //as long as s is not an operator, increment it
     if (!s.equals("AND") && !s.equals("and") && !s.equals("&") && !s.equals("&&") &&
         !s.equals("OR") && !s.equals("or") && !s.equals("||") && !s.equals("|") &&
         !s.equals("XOR") && !s.equals("xor") && !s.equals("^")) {
           num_clauses += 1;
     }
   }

   //get all the clauses from user input
   String[] clauses = new String[num_clauses];
   int i = -1;
   for (String s : parameters) {
     //as long as s is not an operator, increment it
     if (!s.equals("AND") && !s.equals("and") && !s.equals("&") && !s.equals("&&") &&
         !s.equals("OR") && !s.equals("or") && !s.equals("||") && !s.equals("|") &&
         !s.equals("XOR") && !s.equals("xor") && !s.equals("^")) {
           i += 1;
           clauses[i] = s;
     }
   }

   //gets string for truth table
   printTruthTable(num_clauses, 0, new int[num_clauses]);

   String[] truth_table = output.split("\\s+");

   //values to present in truth table
   String true_value = "true";
   String false_value = "false";
   //make sure output_choice is not null
   if (output_choice != null && output_choice != "" && output_choice.equals("t-f")) {
     true_value = "t";
     false_value = "f";
   }
   else if (output_choice != null && output_choice != "" && output_choice.equals("T-F")) {
     true_value = "T";
     false_value = "F";
   }
   else if (output_choice != null && output_choice != "" && output_choice.equals("1-0")) {
     true_value = "1";
     false_value = "0";
   }
   else {
     true_value = "true";
     false_value = "false";
   }

   i = 0;
   for (String truth_value : truth_table) {
     if (truth_value.equals("0")) {
       truth_table[i] = true_value;
     }
     else if (truth_value.equals("1")) {
       truth_table[i] = false_value;
     }
     i += 1;
   }

   PrintResponse(out, input_cleaned, clauses, truth_table, num_clauses);
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
   out.println("   table, th, td {padding: 5px; border: 1px solid black; border-collapse: collapse; font: 15px; table-layout: fixed; width: 50%; background-color: #F5FFFA;}");
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
   out.println("<h3> Welcome! </h3>");
   out.println("<h3> Please enter your boolean predicate below and click submit when done. </h3>");
   out.println("</p>");
   out.println("<form method=\"post\"");
   out.println(" action=\"https://" + Domain + Path + Servlet + "\">");
   out.println("");
   out.println("Below are the requirements for your input:");

   out.println("<table align=\"left\" class=\"table1\">");

   out.println("<tr>");
   out.println("<th style=\"background-color:lightgoldenrodyellow\" align=\"center\">" + "Component" + "</td>");
   out.println("<th style=\"background-color:lightgoldenrodyellow\" align=\"center\">" + "Acceptable Syntax" + "</td>");
   out.println("<th style=\"background-color:lightgoldenrodyellow\" align=\"center\">" + "Example" + "</td>");
   out.println("</tr>");

   out.println("<tr>");
   out.println("<td>" + "AND" + "</td>");
   out.println("<td>" + "AND, and, &, &&" + "</td>");
   out.println("<td>" + "A AND B & C && D and E" + "</td>");
   out.println("</tr>");

   out.println("<tr>");
   out.println("<td>" + "OR" + "</td>");
   out.println("<td>" + "OR, or, |, ||" + "</td>");
   out.println("<td>" + "A OR B | (C || D) or E" + "</td>");
   out.println("</tr>");

   out.println("<tr>");
   out.println("<td>" + "XOR" + "</td>");
   out.println("<td>" + "XOR, xor, ^" + "</td>");
   out.println("<td>" + "(A XOR B) xor C ^ E" + "</td>");
   out.println("</tr>");

   out.println("<tr>");
   out.println("<td>Include spaces between operators and variables.</td>");
   out.println("<td></td>");
   out.println("<td>A OR (B OR C)</td>");
   out.println("</tr>");

   out.println("</table class=\"table1\">");

   out.println(" <br>");
   out.println(" <br>");
   out.println(" <br>");
   out.println(" <br>");
   out.println(" <br>");
   out.println(" <br>");
   out.println(" <br>");
   out.println(" <br>");

   out.println(" <table class=\"table2\">");
   out.println("  <tr>");
   out.println("   <td><b>Input your expression here:</b>");
   out.println("   <td><input type=\"text\" name=\"predicate\" value=\"" + input + "\" size=13 style=\" height: 6%; \">");
   out.println("  </tr>");
   out.println(" </table>");
   out.println(" <br>");
   out.println(" <br>");
   out.println("");

   out.println("			How would you like to display the truth-values in truth table?");
   out.println("			<br>");
   out.println("			<input type=\"radio\" name=\"truth_value\" id=\"t-f\" value=\"t-f\"/>");
   out.println("			<label for=\"t-f\">t-f</label>");
   out.println("			<br/>");
   out.println("			<input type=\"radio\" name=\"truth_value\" id=\"T-F\" value=\"T-F\"/>");
   out.println("			<label for=\"T-F\">T-F</label>");
   out.println("			<br/>");
   out.println("			<input type=\"radio\" name=\"truth_value\" id=\"1-0\" value=\"1-0\"/>");
   out.println("			<label for=\"1-0\">1-0</label>");
   out.println("			<br/>");
   out.println("			<input type=\"radio\" name=\"truth_value\" id=\"true-false\" value=\"true-false\"/>");
   out.println("			<label for=\"true-false\">true-false</label>");
   out.println("			<br/>");

   out.println(" <br>");
   out.println(" <br>");
   out.println(" <input type=\"submit\" value=\"" + Submit + "\" name=\"submission\" style=\"width: 10%; height: 6%; font-size: 20px;\">");
   out.println("</form>");

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
  out.println("   table, th, td {padding: 5px; border: 1px solid black; border-collapse: collapse; font: 15px; table-layout: fixed; width: 25%; background-color: #F5FFFA;}");
  out.println("			body {background-color:#E1F3DB}");
  out.println("		</style>");
  out.println("  </head>");
  out.println("  <body>");
  out.println("<h3>Below is a complete truth table for your predicate.</h3>");
  out.println("  <p>");
  out.println("     </br>");
  out.println("     User's Predicate String: " + input + "");
  out.println("  </br>");
  out.println("  </br>");
  out.println("  </br>");

  out.println("<table align=\"left\">");

  //to print out clauses for table headers
  out.println("<tr>");
  for (String clause : clauses) {
    out.println("<th style=\"background-color:lightseagreen\" align=\"center\"><b>" + clause + "</b></td>");
  }
  out.println("</tr>");

  //to print out actual truth values
  out.println("<tr>");
  int i = 0;
  for (String truth_value : truth_table) {
    i += 1;
    out.println("<td>" + truth_value + "</td>");
    //move to the next row
    if (i == num_clauses && i != truth_table.length) {
      out.println("</tr>");
      out.println("<tr>");
      i = 0;
    }
  }
  out.println("</tr>");

  out.println("</table>");

  out.println("  </body>");

  out.println("</html>");


}

}  // End Final Exam
