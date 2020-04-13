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
    var servletURL4 = window.location.origin + "/asst7";
  </script>
<title>First JSP</title>
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
Try the TwoButtons servlet:
<button onclick="window.location.assign(servletURL2);"> Click me! </button>
</br>
</br>
Try Assignment 6  - GMU Bookstore Survey:
<button onclick="window.location.assign(servletURL3);"> Click me! </button>
</br>
</br>
Try Assignment 7 (ReactJS app) - GMU Bookstore Survey:
<button onclick="window.location.assign(servletURL4);"> Click me! </button>
</br>
</br>
</body>
</html>
