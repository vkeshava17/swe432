/** *****************************************************************
assignment8.java
********************************************************************* */

// Import Java Libraries
import java.io.*;
import java.util.*;

//Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet( name = "assignment8", urlPatterns = {"/asst8"} )

public class assignment8 extends HttpServlet
{
  static String RESOURCE_FILE = "entries.txt";
  static final String VALUE_SEPARATOR = ";";
  boolean commentsTF = false;

  // Location of servlet.
  static String Domain  = "swe432vkeshava.herokuapp.com";
  static String Path    = "/";
  static String Servlet = "asst8";

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


    commentsTF = false;
    if (Comments == null || Comments.equals("") || Comments.equals("null")) {
      Comments = "No comments";
      commentsTF = true;
    }

    PrintWriter entriesPrintWriter = new PrintWriter(new FileWriter(RESOURCE_FILE, true), true);
    entriesPrintWriter.println(Major+VALUE_SEPARATOR+Year+VALUE_SEPARATOR+Q1+VALUE_SEPARATOR+Q2+VALUE_SEPARATOR+Q3+VALUE_SEPARATOR+Q4+VALUE_SEPARATOR+Q5+VALUE_SEPARATOR+Comments+VALUE_SEPARATOR);
    entriesPrintWriter.close();

    PrintResponse(out, RESOURCE_FILE);

    out.close();
  }  // End doPost

  //censors inappropriate words
  private String processResponses(String text) {
    return text.replaceAll("(shit)|(fuck)|(damn)|(bitch)|(Shit)|(Fuck)|(Damn)|(Bitch)|(ass)|(Ass)", "*");
  }

  /** *****************************************************
  *  Overrides HttpServlet's doGet().
  ********************************************************* */
  public void doGet (HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException
  {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    PrintMain(out);
    out.close();
  } // End doGet


  /** *****************************************************
  *  Prints the form/survey questions html
  ********************************************************* */
  private void PrintMain (PrintWriter out) // main index.html
  {
    out.println("<html>");
    out.println("    <head>");
    out.println("		<title>GMU Bookstore Ratings</title>");
    out.println("		<style> ");
    out.println("			body {background-color:#E1F3DB}");
    out.println("		</style>");
    out.println("		<script type='text/javascript'>");
    out.println("			function focus() { ");
    out.println("				document.UserInfo.Major.focus()");
    out.println("			}");
    out.println("			function IsNum (string) {");
    out.println("				var value = parseInt (string);");
    out.println("				return (value > 0);");
    out.println("			}");
    out.println("			function CheckInput() {");
    out.println("				var ErrorMessage = '';");
    out.println("				var NumErrors = 0;");
    out.println("				var Major = document.UserInfo.Major;");
    out.println("				if (IsNum(Major.value)) { ");
    out.println("					NumErrors++;");
    out.println("					ErrorMessage += '\\n' + NumErrors + ') Major should be a valid name, not a number. For example: CS, SWE, IT, etc.';");
    out.println("				}");
    out.println("				if (Major.value == '')");
    out.println("                            {");
    out.println("				NumErrors++;");
    out.println("			ErrorMessage += '\\n' + NumErrors + ') Missing major. ';");
    out.println("			}");
    out.println("				var Year = document.UserInfo.Year;");
    out.println("		if (!IsNum(Year.value)) { ");
    out.println("				NumErrors++;");
    out.println("					ErrorMessage += '\\n' + NumErrors + ') Year should be an integer (ex: 1 = Freshman, 2 = Sophomore, etc.). ';");
    out.println("				}");
    out.println("				if (Year.value == '')");
    out.println("                                {");
    out.println("					NumErrors++;");
    out.println("					ErrorMessage += '\\n' + NumErrors + ') Missing year.  ';");
    out.println("				}");
    out.println("				if (NumErrors > 0)");
    out.println("				{");
    out.println("					alert('Please correct the errors below and resubmit:  ' + ErrorMessage);");
    out.println("					return (false);");
    out.println("				}");
    out.println("				else");
    out.println("				{");
    out.println("					alert('Your responses have been saved. Thank you for your feedback!');");
    out.println("					return (true);");
    out.println("				}");
    out.println("			}");
    out.println("		</script>");
    out.println("	</head>");
    out.println("	<body onload=\"focus()\">");
    out.println("		<p>");
    out.println("		Assignment 8");
    out.println("		</br>");
    out.println("		Developed by: Satyasaarika Putla, Vandana Keshavamurthy");
    out.println("		</br>");
    out.println("		For our collaboration summary, click");
    out.println("		<a href=\"http://mason.gmu.edu/~vkeshava/asst8Collab\">here</a>");
    out.println("		<h1 align=\"center\">George Mason Bookstore Ratings</h1>");

    out.println("		This website allows students in the Volgenau School of Engineering to rate the George Mason Bookstore, Barnes and Noble, based on their 			experiences with buying textbooks. </p>");
    out.println("		<form method=\"post\" action=\"asst8\" name=\"UserInfo\" onSubmit=\"return (CheckInput())\">");
    out.println("			<table>	");
    out.println("				<tbody>");
    out.println("					<tr>");
    out.println("						<td style=\"margin: 5px; padding: 5px;\">Major:");
    out.println("						</td>");
    out.println("						<td>");
    out.println("							<input type=\"text\" name=\"Major\">");
    out.println("						</td>");
    out.println("					</tr>");

    out.println("					<tr>");
    out.println("						<td>Year:");
    out.println("							</td>");
    out.println("						<td>");
    out.println("							<input type=\"text\" name=\"Year\">");
    out.println("						</td>");
    out.println("					</tr>");
    out.println("				</tbody>");
    out.println("			</table>") ;
    out.println("			<br>");


    out.println("			1. How easy was it for you to find your textbooks in the store?");
    out.println("			<br>");
    out.println("			<input type=\"radio\" name=\"Q1\" id=\"Very Easy\" value=\"Very Easy\"/>");
    out.println("			<label for=\"Very Easy\">Very Easy</label>");
    out.println("			<br/>");
    out.println("			<input type=\"radio\" name=\"Q1\" id=\"Easy\" value=\"Easy\"/>");
    out.println("			<label for=\"Easy\">Easy</label>");
    out.println("			<br/>");
    out.println("			<input type=\"radio\" name=\"Q1\" id=\"Hard\" value=\"Hard\"/>");
    out.println("			<label for=\"Hard\">Hard</label>");
    out.println("			<br/>");
    out.println("			<input type=\"radio\" name=\"Q1\" id=\"Very Hard\" value=\"Very Hard\"/>");
    out.println("			<label for=\"Very Hard\">Very Hard</label>");
    out.println("			<br/>");
    out.println("			<br>");

    out.println("			2. How many times were the textbooks you needed (digital or hard copy) out of stock?");
    out.println("			<br>");
    out.println("			<input type=\"radio\" name=\"Q2\" id=\"Never\" value=\"Never\"/>");
    out.println("			<label for=\"Never\">Never</label>");
    out.println("			<br/>");
    out.println("			<input type=\"radio\" name=\"Q2\" id=\"1-3 times\" value=\"1-3 times\"/>");
    out.println("			<label for=\"1-3 times\">1-3 times</label>");
    out.println("			<br/>");
    out.println("			<input type=\"radio\" name=\"Q2\" id=\"4-6 times\" value=\"4-6 times\"/>");
    out.println("			<label for=\"4-6 times\">4-6 times</label>");
    out.println("			<br/>");
    out.println("			<input type=\"radio\" name=\"Q2\" id=\"7 or more times\" value=\"7 or more times\"/>");
    out.println("			<label for=\"7 or more times\">7 or more times</label>");
    out.println("			<br/>");
    out.println("			<br>");

    out.println("			3. How reasonable do you think the textbook prices were compared to other sellers?");
    out.println("			<br>");
    out.println("			<input type=\"radio\" name=\"Q3\" id=\"Very Reasonable\" value=\"Very Reasonable\"/>");
    out.println("			<label for=\"Very Reasonable\">Very Reasonable</label>");
    out.println("			<br/>");
    out.println("			<input type=\"radio\" name=\"Q3\" id=\"Reasonable\" value=\"Reasonable\"/>");
    out.println("			<label for=\"Reasonable\">Reasonable</label>");
    out.println("			<br/>");
    out.println("			<input type=\"radio\" name=\"Q3\" id=\"Expensive\" value=\"Expensive\"/>");
    out.println("			<label for=\"Expensive\">Expensive</label>");
    out.println("			<br/>");
    out.println("			<input type=\"radio\" name=\"Q3\" id=\"Very Expensive\" value=\"Very Expensive\"/>");
    out.println("			<label for=\"Very Expensive\">Very Expensive</label>");
    out.println("			<br/>");
    out.println("			<br>");

    out.println("			4. If given the option, do you prefer digital or hard copy textbooks? ");
    out.println("			<br>");
    out.println("			<input type=\"radio\" name=\"Q4\" id=\"Yes\" value=\"Yes\"/>");
    out.println("			<label for=\"Yes\">Yes</label>");
    out.println("			<br/>");
    out.println("			<input type=\"radio\" name=\"Q4\" id=\"No\" value=\"No\"/>");
    out.println("			<label for=\"No\">No, I prefer using hard copies for these classes</label>");
    out.println("			<br/>");
    out.println("			<input type=\"radio\" name=\"Q4\" id=\"Depends\" value=\"Depends\"/>");
    out.println("			<label for=\"Depends\">Depends on the class</label>");
    out.println("			<br/>");
    out.println("			<br>");

    out.println("			5. How accurate are the recommended and required textbook lists that the bookstore provides online?");
    out.println("			<br>");
    out.println("			<input type=\"radio\" name=\"Q5\" id=\"Very Accurate\" value=\"Very Accurate\"/>");
    out.println("			<label for=\"Very Accurate\">Very Accurate, used all textbooks frequently</label>");
    out.println("			<br/>");
    out.println("			<input type=\"radio\" name=\"Q5\" id=\"Accurate\" value=\"Accurate\"/>");
    out.println("			<label for=\"Accurate\">Somewhat Accurate, occasionally used some textbooks</label>");
    out.println("			<br/>");
    out.println("			<input type=\"radio\" name=\"Q5\" id=\"Not Accurate\" value=\"Not Accurate\"/>");
    out.println("			<label for=\"Not Accurate\">Not Accurate, never used any textbooks</label>");
    out.println("			<br>");
    out.println("			<p> Additional Comments, Suggestions, and Concerns:</p>");
    out.println("			<textarea id=\"textArea\" name=\"Comments\" rows=\"6\" cols=\"40\"></textarea>");
    out.println("			<br/>");
    out.println("			<br/>");
    out.println("			<button type=\"submit\"onclick=\"submitSuccess()\" style=\"width: 10%; height: 4%; font-size: 13px;\">Submit Answers</button>");
    out.println("			<br/>");
    out.println("			<br/>");
    out.println("		</form>");
    out.println("	</body>");
    out.println("</html>");

  } // End PrintHead

  /** *****************************************************
  *  Prints the form data's html
  ********************************************************* */
  private void PrintResponse (PrintWriter out, String resourcePath) // response to survey html
  {
    out.println("<html>");
    out.println("  <head>");
    out.println("  <title>GMU Bookstore Survey</title>");
    out.println("  <style> ");
    out.println("    body {background-color:#E1F3DB}");
    out.println("  </style>");
    out.println("  </head>");
    out.println("  <body>");

    ArrayList<String[]> allParams = new ArrayList<String[]>();

    String allLines = "";
    try {
      File file = new File(resourcePath);
      if(!file.exists()){
        out.println("<p>No entries persisted yet</p>");
        return;
      }

      int i = 0;
      int index = 0;
      BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
      String line = "";
      while ((line = bufferedReader.readLine()) != null) {
      	allLines += line;
        String[] parameters = new String[8];
        String[] entry = line.split(VALUE_SEPARATOR);
        i = 0;
        for(String value: entry){
          if (i == 7) {
            if (commentsTF == true) {
              parameters[i] = "No comments";
              commentsTF = false;
            }
            else {
              value = processResponses(value);
              parameters[i] = value;
            }
          }
          else if (value == null || value.equals("") || value.equals("null")) {
            parameters[i] = "No response";
          }
          else {
            value = processResponses(value);
            parameters[i] = value;
          }
          i += 1;
        }
        allParams.add(parameters);
        index += 1;
      }

      bufferedReader.close();
    }
    catch (FileNotFoundException ex) {
      ex.printStackTrace();
    } catch (IOException ex) {
      ex.printStackTrace();
    }

		String mostQ1 = "";
    String mostQ2 = "";
    String mostQ3 = "";
    String mostQ4 = "";
    String mostQ5 = "";

		//Very Easy, Easy, Hard, Very Hard
    String[] Q1Values = {"Very Easy", "Easy", "Hard", "Very Hard"};
    String[] Q2Values = {"Never", "1-3 times", "4-6 times", "Very Hard"};
    String[] Q3Values = {"Very Reasonable", "Reasonable", "Expensive", "Very Expensive"};
    String[] Q4Values = {"Yes", "No", "Depends"};
    String[] Q5Values = {"Very Accurate", "Accurate", "Not Accurate"};

    int[] Q1 = {0,0,0,0};
    int[] Q2 = {0,0,0,0};
    int[] Q3 = {0,0,0,0};
    int[] Q4 = {0,0,0};
    int[] Q5 = {0,0,0};

		for (String[] parameters : allParams) {
      if (parameters[2].equals("Very Easy")) {Q1[0] += 1;}
      else if (parameters[2].equals("Easy")) {Q1[1] += 1;}
      else if (parameters[2].equals("Hard")) {Q1[2] += 1;}
      else if (parameters[2].equals("Very Hard")) {Q1[3] += 1;}

      if (parameters[3].equals("Never")) {Q2[0] += 1;}
      else if (parameters[3].equals("1-3 times")) {Q2[1] += 1;}
      else if (parameters[3].equals("4-6 times")) {Q2[2] += 1;}
      else if (parameters[3].equals("7 or more times")) {Q2[3] += 1;}

      if (parameters[4].equals("Very Reasonable")) {Q3[0] += 1;}
      else if (parameters[4].equals("Reasonable")) {Q3[1] += 1;}
      else if (parameters[4].equals("Expensive")) {Q3[2] += 1;}
      else if (parameters[4].equals("Very Expensive")) {Q3[3] += 1;}

      if (parameters[5].equals("Yes")) {Q4[0] += 1;}
      else if (parameters[5].equals("No")) {Q4[1] += 1;}
      else if (parameters[5].equals("Depends")) {Q4[2] += 1;}

      if (parameters[6].equals("Very Accurate")) {Q5[0] += 1;}
      else if (parameters[6].equals("Accurate")) {Q5[1] += 1;}
      else if (parameters[6].equals("Not Accurate")) {Q5[2] += 1;}
    }


    int max = Q1[0];
		int Q1index = 0;
		for (int i = 0; i < Q1.length; i++)
		{
			if (max < Q1[i])
			{
				max = Q1[i];
				Q1index = i;
			}
		}

    max = Q2[0];
		int Q2index = 0;
		for (int i = 0; i < Q2.length; i++)
		{
			if (max < Q2[i])
			{
				max = Q2[i];
				Q2index = i;
			}
		}

    max = Q3[0];
		int Q3index = 0;
		for (int i = 0; i < Q3.length; i++)
		{
			if (max < Q3[i])
			{
				max = Q3[i];
				Q3index = i;
			}
		}

    max = Q4[0];
		int Q4index = 0;
		for (int i = 0; i < Q4.length; i++)
		{
			if (max < Q4[i])
			{
				max = Q4[i];
				Q4index = i;
			}
		}

    max = Q5[0];
		int Q5index = 0;
		for (int i = 0; i < Q5.length; i++)
		{
			if (max < Q5[i])
			{
				max = Q5[i];
				Q5index = i;
			}
		}

    out.println("  <p>");
    out.println("  Assignment 8");
    out.println("     </br>");
    out.println("     Developed by: Satyasaarika Putla, Vandana Keshavamurthy");
    out.println("     </br>");
    out.println("     For our collaboration summary, click");
    out.println("     <a href=\"http://mason.gmu.edu/~vkeshava/asst8Collab\">here</a>");
    out.println("  </p>");
    out.println("  <h1 align=\"center\">All User Responses</h1>");

    String lifeCycleURL = "asst8part2";
    out.println("<h2>Second Servlet with Aggregate Summary of all Reviews:");
    out.println("<a href=\"" + lifeCycleURL + "?commonQ1=" + Q1Values[Q1index] + "&commonQ2=" + Q2Values[Q2index] +  "&commonQ3=" + Q3Values[Q3index] + "&commonQ4=" + Q4Values[Q4index] + "&commonQ5=" + Q5Values[Q5index] + "&allSubmissions=" + allLines + "\">");
    out.println("Click here!</a></h2>");

    out.println("<h3 align=\"left\">Questions Key</h3>");
    out.println("<p>Q1: How easy was it for you to find your textbooks in the store?</p>");
    out.println("<p>Q2: How many times were the textbooks you needed (digital or hard copy) out of stock?</p>");
    out.println("<p>Q3: How reasonable do you think the textbook prices were compared to other sellers?</p>");
    out.println("<p>Q4: If given the option, do you prefer digital or hard copy textbooks?</p>");
    out.println("<p>Q5: How accurate are the recommended and required textbook lists that the bookstore provides online?</p>");
    out.println("  </br>");

    int submissionCounter = 1;
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

}  // End assignment 8
