<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
  <script>
    var servletURL = window.location.origin + "/hello";
    var servletURL2 = window.location.origin + "/twoButtons";
    var servletURL3 = window.location.origin + "/asst6";
    var servletURL4 = "swe-432-react.herokuapp.com/asst7";
    var servletURL5 = window.location.origin + "/file";
    var servletURL6 = window.location.origin + "/sessionLifeCycle";
    var servletURL7 = window.location.origin + "/attributeServlet";
    var servletURL8 = window.location.origin + "/asst8";
  </script>
<title>SWE JSPs</title>
</head>
<%@ page import="java.util.Date" %>
<body>
<h2>Hello Heroku! I am JSP</h2>
<strong>Current Time is</strong>: <%=new Date() %>
</br>
</br>
Try the Hello Servlet:
<button onclick="window.location.assign(servletURL);"> Click me! </button>
</br>
</br>
Try the TwoButtons Servlet:
<button onclick="window.location.assign(servletURL2);"> Click me! </button>
</br>
</br>
Try the persistenceFile Servlet:
<button onclick="window.location.assign(servletURL5);"> Click me! </button>
</br>
</br>
Try the sessionLifeCycle Servlet:
<button onclick="window.location.assign(servletURL6);"> Click me! </button>
</br>
</br>
Try the attributeServlet Servlet:
<button onclick="window.location.assign(servletURL7);"> Click me! </button>
</br>
</br>
Try Assignment 5 - GMU Bookstore Survey - Plain HTML:
<button onclick="window.location.href = 'http://mason.gmu.edu/~vkeshava/assignment5';"> Click me! </button>
</br>
</br>
Try Assignment 6 - GMU Bookstore Survey - DoGet & DoPost:
<button onclick="window.location.assign(servletURL3);"> Click me! </button>
</br>
</br>
Try Assignment 7 - GMU Bookstore Survey - ReactJS app:
<button onclick="window.location.href = 'https://swe-432-react.herokuapp.com/asst7';"> Click me! </button>
</br>
</br>
Try Assignment 8 - GMU Bookstore Survey - Persisting Data:
<button onclick="window.location.assign(servletURL8);"> Click me! </button>
</br>
</br>
</body>
</html>
