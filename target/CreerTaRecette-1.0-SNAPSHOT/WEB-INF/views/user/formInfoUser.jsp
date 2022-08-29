<%-- 
    Document   : profilUserDetail
    Created on : 11 août 2022, 09:35:29
    Author     : dev-pro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <title>Info Utilisateur </title>
    </head>
    <body>
        <h1>Information complementaire!</h1>
        <div class="container-lg"> 
            <div class="container p-8" style="margin-left: 25%; margin-right: 25%">
                <form method="POST" action="${pageContext.request.contextPath}/createinfouser">
                    <fieldset>
                        <div class="row col-sm-8">
                            <div class="col-sm-8">
                                <div class="form-group">
                                    <input type="hidden" name="idUser" value="${ SESSION_USER_KEY.idUser }" class="form-control" id="inputId">
                                </div>
                            </div>
                            <div class="col-sm-8">
                                <div class="form-group">
                                    <label for="inputPrenom" class="form-label mt-4">Prenom</label>
                                    <input type="text" name="firstname" class="form-control" id="inputPrenom"  placeholder="Enter votre prenom">
                                </div>
                            </div>
                            <div class="col-sm-8">
                                <div class="form-group">
                                    <label for="inputNom" class="form-label mt-4">Nom</label>
                                    <input type="text" name="lastname" class="form-control" id="inputNom"  placeholder="Enter votre Nom">
                                </div>
                            </div>
                            <div class="col-sm-8">
                                <div class="form-group">
                                    <label for="inputNumero" class="form-label mt-4">Numero</label>
                                    <input type="tel" name="number" class="form-control" id="inputNumero"  placeholder="Enter votre Numero">
                                </div>
                            </div>
                            <div class="col-sm-8">
                                <div class="form-group">
                                    <label for="inputEmail" class="form-label mt-4">Email</label>
                                    <input type="email" name="email" class="form-control" id="inputEmail"  placeholder="Enter votre mail">
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
