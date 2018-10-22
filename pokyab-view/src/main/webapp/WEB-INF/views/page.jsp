<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>  

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie-edge" >    
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Pokyab - ${title}</title>
        <script>
            window.menu = '${title}';
            window.contextRoot = '${contextRoot}';
        </script>
        <link href="${css}/bs/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${css}/myapp.css" rel="stylesheet" type="text/css"/>      
    </head>
    
    <body>
        
        <div class="wrapper">
        
            <!--navbar-->
            <%@include file="shared/navbar.jsp"%>

            <!-- Page Content -->
            <div class="content">
                
                <!-- Load de about content -->
                <c:if test="${userClickAbout == true }">
                   <%@include file="about.jsp" %>
                </c:if>

                <!-- Load de contact content -->
                <c:if test="${userClickContact == true }">
                   <%@include file="contact.jsp" %>
                </c:if>     

                <!--Load player content-->
                <c:if test="${userClickPlayers == true }">
                   <%@include file="persons.jsp"%>
                </c:if>
                 
            </div>
                
            <!--footer-->
            <%@include file="shared/footer.jsp"%>

            <!-- Bootstrap core JavaScript -->
            <script src="${js}/bs/jquery-3.3.1.slim.min.js" type="text/javascript"></script>
            <script src="${js}/bs/popper.min.js" type="text/javascript"></script>
            <script src="${js}/bs/bootstrap.min.js" type="text/javascript"></script>

            <script src="${js}/myapp.js" type="text/javascript"></script>
        
        </div>
    </body>
</html>
