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
            <!--main content-->
            <div class="content container-fluid">
                <!--message-->            
                <%@include file="../shared/alertMessage.jsp"%>
                <!--Load activities content-->
                <c:if test="${userClickActivities == true }">
                    <%@include file="activities.jsp"%>
                </c:if>  
                <!--Load trainings content-->
                <c:if test="${userClickTrainings == true }">
                    <%@include file="trainings.jsp"%>
                </c:if>    
                <!--Load activity content-->
                <c:if test="${userClickActivity == true }">
                    <%@include file="activityManage.jsp"%>
                </c:if>  
                <!--Load training content-->
                <c:if test="${userClickTraining == true }">
                    <%@include file="trainingManage.jsp"%>
                </c:if>
                <!--Load training activity content-->
                <c:if test="${userClickTrainActivity == true }">
                    <%@include file="trainActivManage.jsp"%>
                </c:if>
            </div>
            <!--footer-->
            <%@include file="../shared/footer.jsp"%>
        </div>

        <!--javascript-->
        <%@include file="../shared/jsFooter.jsp"%>         
        <script src="${js}/training.js" type="text/javascript"></script>
    </body>
</html>