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
    <script>
        window.currentPage = "contactPoint";
    </script>
        
    <body>        
        <div class="wrapper">
            <!--navbar-->
            <%@include file="../shared/navbar.jsp"%>
            <!--main content-->
            <div class="content container-fluid">
                <!--message-->            
                <%@include file="../shared/alertMessage.jsp"%>
                <!--Load persons content-->
                <c:if test="${userClickPersons == true }">
                    <%@include file="persons.jsp"%>
                </c:if>
                <!--Load person content-->
                <c:if test="${userClickPerson == true }">
                    <%@include file="personManage.jsp"%>
                </c:if>  
            </div>
            <!--footer-->
            <%@include file="../shared/footer.jsp"%>
        </div>

        <!--javascript-->
        <%@include file="../shared/jsFooter.jsp"%>         
        <script src="${js}/person.js" type="text/javascript"></script>
    </body>
</html>