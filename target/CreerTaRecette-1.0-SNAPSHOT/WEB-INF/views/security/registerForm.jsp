<%-- 
    Document   : registerForm
    Created on : 7 août 2022, 12:33:46
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
        <title>Formulaire d'inscription</title>
    </head>
    <body>
        <%@ include file="/model/_navbar.jsp" %>
        <h1>Formulaire d'inscription</h1>
        
        <div class="container-lg"> 
            <div class="container p-8" style="margin-left: 25%; margin-right: 25%">
                <p style="color: red;">${returnMsg}</p>
                <form method="POST" action="${pageContext.request.contextPath}/formregisteruser">
                    <input type="hidden" name="currentUser" value="<c:out value="${ SESSION_USER_KEY.role }"/>" >
                    <fieldset>
                        <div class="row col-sm-8">
                            <div class="col-sm-4">
                                <label for="exampleSelect1" class="form-label mt-4">Genre</label>
                                <select class="form-select" name="gender" id="exampleSelect1">
                                    <option>F</option>
                                    <option>M</option>
                                </select>
                            </div>
                            <div class="col-sm-4">
                                <label for="exampleSelect1" class="form-label mt-4">Role</label>
                                <select class="form-select" name="role" id="exampleSelect1">
                                    <option>USER</option>
                                    <option>ADMIN</option>
                                </select>
                            </div>

                            <div class="col-sm-8">
                                <div class="form-group">
                                    <label for="inputPseudo" class="form-label mt-4">Pseudo</label>
                                    <input type="text" name="pseudo" class="form-control" id="inputPseudo"  placeholder="Enter votre Pseudo">
                                </div>
                            </div>
                            <div class="col-sm-8">
                                <div class="form-group">
                                    <label for="exampleInputPassword1" class="form-label mt-4">Password</label>
                                    <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                            </div>
                            <div class="col-sm-8">
                                <div class="form-group">
                                    <label for="exampleInputPassword2" class="form-label mt-4">Password</label>
                                    <input type="password" name="password2" class="form-control" id="exampleInputPassword2" placeholder="Password">
                                </div>
                            </div>
                            <div style="margin-top: 10px">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>

                    </fieldset>
                </form>
            </div>
           
    
    </body>
</html>