
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

// have a string questions.js -> prints our questions to the screen
// have a string response.js -> prints our response to the screen

public void doPost (HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
{


   String Major = request.getParameter("Major");
   String Year = request.getParameter("Year");
   String Question1 = request.getParameter("Q1");
   String Question2 = request.getParameter("Q2");
   String Question3 = request.getParameter("Q3");
   String Question4 = request.getParameter("Q4");
   String Question5 = request.getParameter("Q5");
   String Comments = request.getParameter("Comments");


  // String[] parameters = {Major, Year, Q1, Q2, Q3, Q4, Q5, Comments};
   request.setAttribute("Major", Major);
   request.setAttribute("Year", Year);
   request.setAttribute("Q1", Question1);
   request.setAttribute("Q2", Question2);
   request.setAttribute("Q3", Question3);
   request.setAttribute("Q4", Question4);
   request.setAttribute("Q5", Question5);
   request.setAttribute("Comments", Comments);

   RequestDispatcher fd = request.getRequestDispatcher("/resources/printresults.js");
   fd.forward(request,response);

}  // End doPost



/** *****************************************************
 *  Overrides HttpServlet's doGet().
********************************************************* */
public void doGet (HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException
{
    RequestDispatcher fd = request.getRequestDispatcher("/resources/index.html");
	fd.forward(request,response);

} // End doGet
}
