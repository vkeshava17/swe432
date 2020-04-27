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
    allSubmissions = processResponses(allSubmissions);

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    PrintMain(out, Q1, Q2, Q3, Q4, Q5, allSubmissions);
    out.close();

  } // End doGet

  //censors inappropriate words
  private String processResponses(String text) {
    return text.replaceAll("(shit)|(fuck)|(damn)|(bitch)", "*");
  }

  private void PrintMain (PrintWriter out, String Q1, String Q2, String Q3, String Q4, String Q5, String allLines) // main index.html
  {

    String[] lines = allLines.split(";");
    ArrayList<String[]> allParams = new ArrayList<String[]>();
    String[] params = new String[8];
    int current = 0;
    int counter = 1;
    for (int i = 0; i < lines.length; i++) {
      if (lines[i] == null || lines[i].equals("") || lines[i].equals("null")) {
        params[current] = "No response";
      }
      else {
        params[current] = lines[i];
      }
      if (counter % 8 == 0) {
        current = 0;
        counter = 1;
        allParams.add(params);
      }
      current += 1;
      counter += 1;
    }

    out.println("<html>");
    out.println("<head>");
    out.println(" <title>Aggregate Summary of all Reviews</title>");
    out.println("		<style> ");
    out.println("   table, th, td {padding: 5px; border: 1px solid black; border-collapse: collapse; font: 15px; table-layout: fixed; width: 98%; background-color: #F5FFFA;}");
    out.println("			body {background-color:#E1F3DB}");
    out.println("		</style>");
    out.println("  <h1 align=\"center\">Aggregate Summary of all Reviews</h1>");
    out.println("</head>");
    out.println("");
    out.println("<body>");

    out.println("<table align=\"center\">");
    out.println("<tr>");
    out.println("<th style=\"background-color:lightseagreen\" align=\"center\"><b>Submission #</b></td>");
    out.println("<th style=\"background-color:lightseagreen\" align=\"center\"><b>Major</b></td>");
    out.println("<th style=\"background-color:lightseagreen\" align=\"center\"><b>Year</b></td>");
    out.println("<th style=\"background-color:lightseagreen\" align=\"center\"><b>Q1</b></td>");
    out.println("<th style=\"background-color:lightseagreen\" align=\"center\"><b>Q2</b></td>");
    out.println("<th style=\"background-color:lightseagreen\" align=\"center\"><b>Q3</b></td>");
    out.println("<th style=\"background-color:lightseagreen\" align=\"center\"><b>Q4</b></td>");
    out.println("<th style=\"background-color:lightseagreen\" align=\"center\"><b>Q5</b></td>");
    out.println("<th style=\"background-color:lightseagreen\" align=\"center\"><b>Additional Comments</b></td>");
    out.println("</tr>");

    int submissionCounter = 0;
    for (String[] parameters : allParams) {
      out.println("<tr>");
      out.println("<td>" + submissionCounter + "</td>");
      out.println("<td>" + parameters[0] + "</td>");
      out.println("<td>" + parameters[1] + "</td>");
      out.println("<td>" + parameters[2] + "</td>");
      out.println("<td>" + parameters[3] + "</td>");
      out.println("<td>" + parameters[4] + "</td>");
      out.println("<td>" + parameters[5] + "</td>");
      out.println("<td>" + parameters[6] + "</td>");
      out.println("<td>" + parameters[7] + "</td>");
      out.println("</tr>");
      submissionCounter += 1;
    }

    out.println("<tr>");
    out.println("<td style=\"background-color:#E1F3DB; border-left-color:#E1F3DB; border-bottom-color:#E1F3DB; border-right-color:#E1F3DB;\"></td>");
    out.println("<td style=\"background-color:#E1F3DB; border-left-color:#E1F3DB; border-bottom-color:#E1F3DB;\"></td>");
    out.println("<td style=\"background-color:lightgoldenrodyellow\"><b>Most Common Responses:</b></td>");
    out.println("<td style=\"background-color:lightgoldenrodyellow\"><b>" + Q1 + "</b></td>");
    out.println("<td style=\"background-color:lightgoldenrodyellow\"><b>" + Q2 + "</b></td>");
    out.println("<td style=\"background-color:lightgoldenrodyellow\"><b>" + Q3 + "</b></td>");
    out.println("<td style=\"background-color:lightgoldenrodyellow\"><b>" + Q4 + "</b></td>");
    out.println("<td style=\"background-color:lightgoldenrodyellow\"><b>" + Q5 + "</b></td>");
    out.println("<td style=\"background-color:#E1F3DB; border-color:#E1F3DB;\"></td>");

    out.println("</tr>");
    out.println("</table>");

    out.println("<p>" + Q1 + "</p>");
    out.println("<p>" + Q2 + "</p>");
    out.println("<p>" + Q3 + "</p>");
    out.println("<p>" + Q4 + "</p>");
    out.println("<p>" + Q5 + "</p>");
    out.println("<p>" + allLines + "</p>");

    for (String[] parameters : allParams) {
      out.println("<h3><b><u>Submission #" + submissionCounter + ":</u></b></h3>");
      out.println("<p>Major: " + parameters[0] + "</p>");
      out.println("<p>Year:  " + parameters[1] + "</p>");
      out.println("<p>Q1: " + parameters[2] + "</p>");
      out.println("<p>Q2: " + parameters[3] + "</p>");
      out.println("<p>Q3: " + parameters[4] + "</p>");
      out.println("<p>Q4: " + parameters[5] + "</p>");
      out.println("<p>Q5: " + parameters[6] + "</p>");
      out.println("<p>Comments: " + parameters[7] + "</p>");
      out.println("</br>");
      submissionCounter += 1;
    }

    out.println("</body>");
    out.println("</html>");
  }

}  // End assignment 8 part 2
