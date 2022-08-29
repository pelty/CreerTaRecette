<%-- 
    Document   : profilUser
    Created on : 7 août 2022, 12:32:52
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
        <div class="">
            <h1>Bienvenue ${ SESSION_USER_KEY.pseudo } !</h1>


            <c:if test="${ !empty sessionScope.role }">
                <p>Votre role ${ sessionScope.role } !</p>
            </c:if>

            <p>test Session user </p>
            <c:if test="${ !empty sessionScope.SESSION_USER_KEY }">
                <p>Votre Id ${ SESSION_USER_KEY.idUser } !</p>
                <p>Votre UserName ${ SESSION_USER_KEY.pseudo } !</p>
                <p>Votre Role ${ SESSION_USER_KEY.role } !</p>
            </c:if>

            <h3>test Cookie user </h3>

            <c:if test="${ !empty cookie.ATT_NAME_USER_ID }">
                <p>Ok</p>
                <p>Votre Cookie Usernam 1 <c:out value="${usernameCookie}" /> !</p>
            </c:if>
                
                <c:if test = "${ !empty returnMsg }">
                    <p style="color: red"><c:out value="${ returnMsg }" /></p>
                </c:if>
                    
                    <p style="color: red"><c:out value="${userInfo.lastname}" /> ookokokok</p>
                    
                
            <a href="${pageContext.request.contextPath}/createinfouser"><button>Create User Info</button></a>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th scope="col">Type</th>
                        <th scope="col">Column heading</th>
                        <th scope="col">Column heading</th>
                        <th scope="col">Column heading</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="table-active">
                        <th scope="row">Active</th>
                        <td>Column content</td>
                        <td>Column content</td>
                        <td>Column content</td>
                    </tr>
                    <tr>
                        <th scope="row">Default</th>
                        <td>Column content</td>
                        <td>Column content</td>
                        <td>Column content</td>
                    </tr>
                    <tr class="table-primary">
                        <th scope="row">Primary</th>
                        <td>Column content</td>
                        <td>Column content</td>
                        <td>Column content</td>
                    </tr>
                </tbody>
            </table>

            <%@ include file="_offcanvavasUserDestail.jsp" %>   

<!-- Offcanvas Sidebar -->
<div class="offcanvas offcanvas-start" id="demo">
  <div class="offcanvas-header">
    <h1 class="offcanvas-title">Heading</h1>
    <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"></button>
  </div>
  <div class="offcanvas-body">
    <p>Some text lorem ipsum.</p>
    <p>Some text lorem ipsum.</p>
    <button class="btn btn-secondary" type="button">A Button</button>
  </div>
</div>

<!-- Button to open the offcanvas sidebar -->
<button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#demo">
  Open Offcanvas Sidebar
</button>

        </div>
    </body>
</html>