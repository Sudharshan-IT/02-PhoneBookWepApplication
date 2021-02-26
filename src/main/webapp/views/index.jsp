<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css"/><link>
</head>
<body>
             <h1>Contact Form Page</h1>
           
           <font color='green'>${succMsg}</font>
           <font color='red'>${errMsg}</font>
              <form:form action="saveContact" method="post" modelAttribute="contact">
              <table>
                   <tr>
                            <td>ContactName</td>
                            <td><form:input path="contactName"/></td>
                             <td> <form:hidden path="contactId"/></td>
                   </tr>       
                    <tr>
                            <td>ContactEmail</td>
                            <td><form:input path="mail"/></td>
                   </tr> 
                    <tr>
                            <td>ContactNumber</td>
                            <td><form:input path="contactNumber"/></td>
                   </tr> 
                    <tr>
                            <td><input type="submit" value="Submit"/></td>
                   </tr>                   
              </table>
              </form:form>
              <a href="viewContacts">View All Contacts</a><br>
</body>
</html>