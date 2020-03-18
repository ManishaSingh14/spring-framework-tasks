<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contact Manager Home</title>
    </head>
    <body>
        <div align="center">
            <h1>Contact List</h1>
            <h3><a href="/newEmployee">New Employee</a></h3>
            <table border="1">
                <th>Id</th>
                <th>Name</th>
                <th>Department</th>

                <c:forEach var="employee" items="${employeeList}" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.department}</td>
                    <td>
                        <a href="/edit?id=${employee.id}">Edit</a>

                        <a href="/delete?id=${employee.id}">Delete</a>
                    </td>

                </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
