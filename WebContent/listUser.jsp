<%@ page import="main.java.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Title</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>Id!!!!!</th>
        <th>Name</th>
        <th>Login</th>
        <th>Password</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>

</table>
<h2><%
    // retrieve your list from the request, with casting
    ArrayList<User> list = new ArrayList<>();
    list = (ArrayList<User>) request.getAttribute("users");

// print the information about every category of the list
    for(User user : list) {
        out.println(user.getId());
        out.println(user.getName());

    }
%></h2>
<p><a href="login.html">Add User</a></p>
</body>
</html>