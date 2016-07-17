<%@ page import="java.util.Calendar" %>
<%@ page import="main.java.com.mantiso.User" %><%--
  Created by IntelliJ IDEA.
  User: xue
  Date: 16-7-17
  Time: 下午1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My App</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
          crossorigin="anonymous">
    <link href="../metro-bootstrap-master/css/metro-bootstrap.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<%@include file="_header.jsp" %>
<section class="main container-fluid">
    <%
        Calendar calendar = Calendar.getInstance();
    %>
    <div
            class="container">
        <h1>Home</h1>
        <div class="row-fluid">
            <div class="col-md-3"><%= calendar.getTime().toString()%>
            </div>
            <div class="col-md-9">
                <%
                    User user = (User) request.getAttribute("user");
                    if (user == null) {
                        user = new User();
                    }
                %>
                <tabset>
                    <tab headings="search">
                        <div>
                            <h2>Welcome <%= user.getName()%>
                            </h2>
                            <form action="home" method="post">
                                <p>
                                    Name: <input type="text" name="name"/>
                                </p>
                                <p>
                                    <input type="submit" value="Enter name"/>
                                </p>
                            </form>
                        </div>
                    </tab>
                    <tab heading="Next">
                        yet More static content
                    </tab>
                </tabset>
            </div>
        </div>
    </div>
</section>
</body>
</html>
