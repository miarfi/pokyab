
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--<div class="container-fluid">-->
    
    <!--Breadcrumb row-->
    <div class="row">
        <div class="col-12 col-md-10 col-xl-8">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${contextRoot}/home">
                        <spring:message code="menu.navbar.home"/></a></li>
                    <li class="breadcrumb-item"><a href="${contextRoot}/users">
                        <spring:message code="menu.navbar.users"/></a></li>
                    <li class="breadcrumb-item active" aria-current="page">${user.firstName} ${user.lastName}</li>
                </ol>
            </nav>
        </div>
    </div>    
            
    <!--Team row-->
    <div class="row">
        <div class="col-12 col-md-10 col-xl-8">
            <div class="card">
                <div class="card-header">
                    <h5><spring:message code="user.manage.title"/></h5>
                </div>
                <div class="card-body">
                    
                    <sf:form
                        method="POST"
                        modelAttribute="user"
                        action="${contextRoot}/manage/user" 
                        class="form-horizontal"
                        id="userForm">
                        <div class="form-row">
                            <div class="form-group col-sm-5 col-md-4">
                                <label for="firstName" class="col-form-label">
                                    <spring:message code="user.form.firstName"/></label>   
                                <sf:hidden path="userId" id="userId"/>
                                <sf:input path="firstName" type="text" class="form-control" required="true"/>
                                <sf:errors path="firstName" cssClass="text-danger" element="div"/>                             
                            </div>
                            <div class="form-group col-sm-5 col-md-4">
                                <label for="lastName" class="col-form-label">
                                    <spring:message code="user.form.lastName"/></label>
                                <sf:input path="lastName" type="text" class="form-control" required="true"/>
                                <sf:errors path="lastName" cssClass="text-danger" element="div"/> 
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-sm-5 col-md-4">
                                <label for="contactNumber" class="col-form-label">
                                    <spring:message code="user.form.contactNumber"/></label>
                                <sf:input type="text" path="contactNumber" class="form-control" maxlength="10" />
                                <sf:errors path="contactNumber" cssClass="text-danger" element="div"/> 
                            </div>
                            <div class="form-group col-sm-5 col-md-4">
                                <label for="email" class="col-form-label">
                                    <spring:message code="user.form.email"/></label>
                                <sf:input path="email" type="text" class="form-control" required="true"/>
                                <sf:errors path="email" cssClass="text-danger" element="div"/> 									                                
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-sm-5 col-md-4">
                                <label for="password" class="col-form-label">
                                    <spring:message code="user.form.password"/></label>
                                <sf:input type="password" path="password" class="form-control" required="true"/>
                                <sf:errors path="password" cssClass="text-danger" element="div"/> 
                            </div>
                            <div class="form-group col-sm-5 col-md-4">
                                <label for="confirmPassword" class="col-form-label">
                                    <spring:message code="user.form.confirmPassword"/></label>
                                <sf:input type="password" path="confirmPassword" class="form-control" required="true"/>
                                <sf:errors path="confirmPassword" cssClass="text-danger" element="div"/>										 
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-sm-5 col-md-4">
                                <label class="col-form-label"><spring:message code="user.form.role"/></label>
                                <div class="col-md-8">
                                    <c:choose>
                                        <c:when test="${user.role.equals('ROLE_USER') }">
                                            <label class="radio-inline">
                                                <sf:radiobutton path="role" value="ROLE_USER" checked="checked"/> Usuario 				
                                            </label>
                                            <label class="radio-inline">
                                                <sf:radiobutton path="role" value="ROLE_ADMIN"/> Admin
                                            </label>                                     
                                        </c:when>   
                                        <c:when test="${user.role.equals('ROLE_ADMIN') }">
                                            <label class="radio-inline">
                                                <sf:radiobutton path="role" value="ROLE_USER" checked="checked"/> Usuario 				
                                            </label>
                                            <label class="radio-inline">
                                                <sf:radiobutton path="role" value="ROLE_ADMIN"/> Admin
                                            </label>                                     
                                        </c:when>
                                        <c:otherwise>
                                            <label class="radio-inline">
                                                <sf:radiobutton path="role" value="ROLE_USER"/> Usuario 				
                                            </label>
                                            <label class="radio-inline">
                                                <sf:radiobutton path="role" value="ROLE_ADMIN"/> Admin
                                            </label>   
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                            <div class="form-group col-6 col-sm-4 col-md-3 col-lg-3">
                                <label for="startDate" class="col-form-label">
                                    <spring:message code="common.field.startDate"/></label>
                                <div>
                                    <sf:input path="startDate" id="startDate" type="date" class="form-control" required="true"/> 
                                </div>
                                <sf:errors path="startDate" cssClass="text-danger" element="div" />
                            </div> 
                            <c:if test="${user.userId > 0 }">
                                <div class="form-group col-6 col-sm-4 col-md-3 col-lg-3">
                                    <label for="endDate" class="col-form-label">
                                        <spring:message code="common.field.endDate"/></label>
                                    <div>
                                        <sf:input path="endDate" id="endDate" type="date" class="form-control"/> 
                                    </div>
                                    <sf:errors path="endDate" cssClass="text-danger" element="div" />
                                </div>   
                            </c:if>
                        </div>
                        <div class="form-group">
                                <button type="submit" class="btn btn-primary">
                                    <spring:message code="common.btn.save"/>                                    
                                </button>																	                
                        </div>
                        
                    </sf:form>
                    
                </div>                
            </div>
        </div>
    </div>                    