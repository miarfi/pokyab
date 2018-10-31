<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>--%>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 

<!DOCTYPE html>
<html>
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
        
        <link href="${css}/bs/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="${css}/bs/dataTables.bootstrap4.css" rel="stylesheet" type="text/css"/>
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
                                    
                <!--Table content-->                    
                <!--Load players content-->
                <c:if test="${userClickPlayers == true }">
                   <%@include file="persons.jsp"%>
                </c:if>
                <!--Load teams content-->
                <c:if test="${userClickTeams == true }">
                   <%@include file="teams.jsp"%>
                </c:if>
                <!--Load activities content-->
                <c:if test="${userClickActivities == true }">
                   <%@include file="activities.jsp"%>
                </c:if>  
                <!--Load trainings content-->
                <c:if test="${userClickTrainings == true }">
                   <%@include file="trainings.jsp"%>
                </c:if>
}                
                <!--Management content-->              
                <!--Load team content-->
                <c:if test="${userClickTeam == true }">
                   <%@include file="manageTeam.jsp"%>
                </c:if>
                <!--Load training content-->
                <c:if test="${userClickTraining == true }">
                   <%@include file="manageTraining.jsp"%>
                </c:if>
                <!--Load activity content-->
                <c:if test="${userClickActivity == true }">
                   <%@include file="manageActivity.jsp"%>
                </c:if>                
                <!--Load training_activity content-->
                <c:if test="${userClickTrainActivity == true }">
                   <%@include file="mngTrainingActivity.jsp"%>
                </c:if> 
            </div>
                
            <!--footer-->
            <%@include file="shared/footer.jsp"%>

            <!-- Bootstrap core JavaScript -->
            <script src="${js}/bs/jquery.min.js" type="text/javascript"></script>
            <!--No funciona dataTables-->
            <!--<script src="${js}/bs/jquery-3.3.1.slim.min.js" type="text/javascript"></script>-->
            <script src="${js}/bs/popper.min.js" type="text/javascript"></script>
            
            <!--Revisar diferencias 4 bs-->
            <script src="${js}/bs/bootstrap.js" type="text/javascript"></script>
            <!--<script src="${js}/bs/bootstrap.bundle.js" type="text/javascript"></script>-->
            <!--<script src="${js}/bs/bootstrap.bundle.min.js" type="text/javascript"></script>-->
            
            <!-- DataTables JavaScript -->
            <script src="${js}/bs/jquery.dataTables.js" type="text/javascript"></script>
            <script src="${js}/bs/dataTables.bootstrap.js" type="text/javascript"></script>            
            <!--Project Javascrip-->
            <script src="${js}/myapp.js" type="text/javascript"></script>
        
        </div>
    </body>
</html>
