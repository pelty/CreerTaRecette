<%-- 
    Document   : editUser
    Created on : 9 août 2022, 19:00:25
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
        <title>Edite User</title>
    </head>
    <body>
        <%@ include file="/model/_navbar.jsp" %>
        <h1>Modifie User</h1>
        <div class="container-lg"> 
            <div class="container p-8" style="margin-left: 25%; margin-right: 25%">
                <form method="POST" action="${pageContext.request.contextPath}/edituser">
                    <input type="hidden" name="currentRole" value="${ SESSION_USER_KEY.role }"/>
                    <input type="hidden" name="id" value="<c:out value="${ users.idUser }"/>" >
                    <fieldset>
                        <div class="row col-sm-8">
                            <div class="col-sm-4">
                                <label for="exampleSelect1" class="form-label mt-4">Genre</label>
                                <select class="form-select" name="gender" value="${users.gender}" id="exampleSelect1">
                                    <option>F</option>
                                    <option>M</option>
                                </select>
                            </div>
                            <div class="col-sm-4">
                                <label for="exampleSelect1" class="form-label mt-4">Role</label>
                                <select class="form-select" name="role" value="${users.role}" id="exampleSelect1">
                                    <option>${users.role}</option>
                                    <option>USER</option>
                                    <option>ADMIN</option>
                                </select>
                            </div>
                            <div class="col-sm-8">
                                <div class="form-group">
                                    <label for="inputPseudo" class="form-label mt-4">Pseudo</label>
                                    <input type="text" name="pseudo" value="${users.pseudo}" class="form-control" id="inputPseudo"  placeholder="Enter votre Pseudo">
                                </div>
                            </div>
                            <div class="col-sm-8">
                                <div class="form-group">
                                    <label for="inputPseudo" class="form-label mt-4">Mot de passe</label>
                                    <input type="text" name="password" value="${users.password}" class="form-control" id="inputPseudo"  placeholder="Modifier mot de passe">
                                </div>
                            </div>
                            
                            <div style="margin-top: 10px">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                                
                        </div>

                    </fieldset>
                </form>
            </div>
        </div>
           
    
    </body>
</html>