<%-- 
    Document   : home
    Created on : 7 août 2022, 12:30:51
    Author     : dev-pro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="/model/_navbar.jsp" %>
        
        <div class="container mt-3">
         <h2>Liste des utilisateur</h2>
            <div class="row overflow-scroll" style="height: 600px" >
                <p style="color: red;">${errMsg}</p>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Pseudo</th>
                            <th>Password</th>
                            <th>createDate</th>
                            <th>Actif</th>
                            <th>Role</th>
                            <th>Gender</th>
                        </tr>
                    </thead>
                    <tbody>
                        <div class="col-8 ">
                        <c:forEach items="${listUser}" var="list">
                        <tr>
                            <td><c:out value="${list.idUser}" /></td>
                            <td><c:out value="${list.pseudo}" /></td>
                            <td><c:out value="${list.password}" /></td>
                            <td><c:out value="${list.createDate}" /></td>
                            <td><c:out value="${list.actif}" /></td>
                            <td><c:out value="${list.role}" /></td>
                            <td><c:out value="${list.gender}" /></td>
                            <td><a href="edituser?idedituser=${list.idUser}"><i class="bi bi-pencil-square"></i></a></td>
                            <td><a href="deleteuser?iddeleteuser=${list.idUser}"><i class="bi bi-trash3"></i></a></td>
                        </tr>
                        </c:forEach>
                        </div>
                    </tbody>
                </table>
            </div>
            <div class="row">
                <a href="formregisteruser"><i class="bi bi-person-plus-fill"></i></a>
            </div>
        </div>
        <!-- creer un toat avec pour msg msg (delete) -->
    </body>
</html>
