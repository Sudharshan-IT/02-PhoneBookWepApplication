<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/><link>
       
       <script>
                   function deleteConfirm(){
                	   confirm("Are You Sure , you want to delete ?");
                   }
       </script>
</head>
<body>
          <h1>Contact List Form Page</h1>
      <a href="loadForm">+Add New Contact</a>
         <table border="1">
                   <tr>
                          <th>Name</th>
                          <th>Email</th>
                          <th>ContactNumber</th>
                          <th>Action</th>
                   </tr>
          <c:forEach items="${contacts }" var="contact">
                  <tr>
                         <td>${contact.contactName}</td>
                         <td>${contact.mail}</td>
                         <td>${contact.contactNumber}</td>
                         <td>
                         <a href="editContact?cid=${contact.contactId}">Edit</a>
                         <a href="deleteContact?cid=${contact.contactId }" onclick="return deleteConfirm()">Delete</a>
                         </td>
                  </tr>
          </c:forEach>
         </table>
</body>
</html>