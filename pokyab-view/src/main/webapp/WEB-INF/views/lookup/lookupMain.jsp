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
        window.currentPage = "lookupType";
    </script>
    <body>        
        <div class="wrapper">
            <!--navbar-->
            <%@include file="../shared/navbar.jsp"%>
            <!--main content-->
            <div class="content container-fluid">
                <!--alert message-->            
                <%@include file="../shared/alertMessage.jsp"%>
                <!--Load lookup_types content-->
                <c:if test="${userClickLookupTypes == true }">
                   <%@include file="lookupTypes.jsp"%>
                </c:if> 
                <!--Load lookup_type content-->
                <c:if test="${userClickManageLookupType == true }">
                   <%@include file="lookupTypeManage.jsp"%>
                </c:if>  
                <!--Load lookup_value content-->
                <c:if test="${userClickManageLookupValue == true }">
                   <%@include file="lookupValueManage.jsp"%>
                </c:if>  
                <!--Load lookup_use content-->
                <c:if test="${userClickManageLookupUse == true }">
                   <%@include file="lookupUseManage.jsp"%>
                </c:if>                  
            </div>
            <!--footer-->
            <%@include file="../shared/footer.jsp"%>
        </div>

        <!--javascript-->
        <%@include file="../shared/jsFooter.jsp"%>         
        <script src="${js}/lookup.js" type="text/javascript"></script>
    </body>
</html>