<%-- 
    Document   : _offcanvavasUserDestail
    Created on : 8 août 2022, 18:19:17
    Author     : dev-pro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<a class="btn btn-primary" data-bs-toggle="offcanvas" href="#offcanvasExample" role="button" aria-controls="offcanvasExample">
    Link with href
</a>
<button class="btn btn-primary" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">
    Button with data-bs-target
</button>
<div class="offcanvas offcanvas-start" tabindex="-1" id="offcanvasExample" aria-labelledby="offcanvasExampleLabel">
    <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasExampleLabel">Offcanvas</h5>
        <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
    </div>
    <div class="offcanvas-body">
        <div>
            Some text as placeholder. In real life you can have the elements you have chosen. Like, text, images, lists, etc.
        </div>
        <div>
            <imag></imag>
            <ul>
                <li>Nom : <c:out value="${userInfo.lastname}" /></li>
                <li>Prenom : <c:out value="${userInfo.firstname}" /></li>
                <li>Numero : 0<c:out value="${userInfo.number}" /></li>
                <li>Email : <c:out value="${userInfo.email}" /></li>
            </ul>
        </div>
        <div class="dropdown mt-3">
            <c:if test = "${ empty userInfo }">
                <a href="${pageContext.request.contextPath}/createinfouser">
                    <button class="btn btn-primary" type="button" >Créer ton profil</button>
                </a>
            </c:if>
            <c:if test = "${ !empty userInfo }">
                <a  href="#">
                    <button class="btn btn-primary" type="button" >Modifier</button>
                </a>
            </c:if>
        </div>
    </div>
</div>

                <c:if test = "${ !empty returnMsg }">
                    <p style="color: red"><c:out value="${ returnMsg }" /></p>
                </c:if>