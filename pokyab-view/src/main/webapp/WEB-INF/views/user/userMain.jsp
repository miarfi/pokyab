<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="js" value="/resources/js"/>
<spring:url var="images" value="/resources/images"/>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>     

<!DOCTYPE html>
<html>
    <!--head-->
    <%@include file="../shared/head.jsp"%>

    <body>        
        <div class="wrapper">

            <!--navbar-->
            <%@include file="../shared/navbar.jsp"%>
            <!--message-->            
            <%@include file="../shared/alertMessage.jsp"%>

            <!--main content-->
            <%@include file="users.jsp"%>

            <!--footer-->
            <%@include file="../shared/footer.jsp"%>
        </div>

        <!--javascript-->
        <%@include file="../shared/jsFooter.jsp"%>         
        <%@include file="${js}/user.js"%>
    </body>
</html>