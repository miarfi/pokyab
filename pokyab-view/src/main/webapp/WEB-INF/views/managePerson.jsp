
<div class="container">   
    <%@include file="alertMessage.jsp" %>
    
    <!--Breadcrumb row-->
    <div class="row">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextRoot}/home">
                    <spring:message code="menu.navbar.home"/></a></li>
                <li class="breadcrumb-item"><a href="${contextRoot}/persons">
                    <spring:message code="menu.navbar.persons"/></a></li>
                <li class="breadcrumb-item active" aria-current="page">${person.firstName} ${person.lastName}</li>
            </ol>
        </nav>
    </div>
    
    <!--Alert Message Row-->
    <%@include file="alertMessage.jsp" %>
 
    <!--Training row-->
    <div class="row">
        <div class="col-12 col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4><spring:message code="person.manage.title"/></h4>
                </div>
                <div class="panel-body">
                                           
                    <sf:form 
                        id="personForm"
                        modelAttribute="person" 
                        action="${contextRoot}/manage/person" 
                        method="POST"
                        class="form-horizonal"
                        enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="firstName" class="col-form-label col-md-4">
                                <spring:message code="person.table.firstName"/>:</label>
                            <div class="col-md-8">
                                <sf:input id="personId" path="personId" type="hidden"/>
                                <sf:input path="firstName" id="firstName" type="text" class="form-control"/>
                                <sf:errors path="firstName" cssClass="text-danger" element="div" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastName" class="col-form-label col-md-4">
                                <spring:message code="person.table.lastName"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="lastName" id="lastName" type="text" class="form-control"/>
                                <sf:errors path="lastName" cssClass="text-danger" element="div" />
                            </div>
                        </div>                              
                        <div class="form-group">
                            <label for="genderCode" class="col-form-label col-md-4">
                                <spring:message code="person.table.genderCode"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="genderCode" id="genderCode" type="text" class="form-control"/>
                                <sf:errors path="genderCode" cssClass="text-danger" element="div" />
                            </div>
                        </div>  
                        <div class="form-group">
                            <label for="personType" class="col-form-label col-md-4">
                                <spring:message code="person.table.personType"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="personType" id="personType" type="text" class="form-control"/>
                                <sf:errors path="personType" cssClass="text-danger" element="div" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="maritalStatusCode" class="col-form-label col-md-4">
                                <spring:message code="person.table.maritalStatusCode"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="maritalStatusCode" id="maritalStatusCode" type="text" class="form-control"/>
                                <sf:errors path="maritalStatusCode" cssClass="text-danger" element="div" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dateOfBirth" class="col-form-label col-md-4">
                                <spring:message code="person.table.dateOfBirth"/>:</label>
                            <div class="col-md-4">
                                <sf:input path="dateOfBirth" id="dateOfBirth" type="date"/>
                                <sf:errors path="dateOfBirth" cssClass="text-danger" element="div" />
                            </div>
                        </div>                         
                        <div class="form-group">
                            <label for="startDate" class="col-form-label col-md-4">
                                <spring:message code="common.field.startDate"/>:</label>
                            <div class="col-md-4">
                                <sf:input path="startDate" id="startDate" type="date"/>
                                <sf:errors path="startDate" cssClass="text-danger" element="div" />
                            </div>
                        </div>  
                        <c:if test="${person.personId > 0 }">
                            <div class="form-group">
                                <label for="endDate" class="col-form-label col-md-4">
                                    <spring:message code="common.field.endDate"/>:</label>
                                <div class="col-md-4">
                                    <sf:input path="endDate" id="endDate" type="date"/>
                                    <sf:errors path="endDate" cssClass="text-danger" element="div" />
                                </div>
                            </div>   
                        </c:if>
                        <div class="form-group">
                            <label for="file" class="col-form-label col-md-4">
                                <spring:message code="common.field.file.upload"/></label>
                            	<div class="col-md-8">
                                    <sf:input path="file" id="file" type="file" class="form-control"/>
                                    <sf:errors path="file" cssClass="text-danger" element="div"/>
				</div>
			</div>
                        <div class="form-group">								
                            <div class="col-offset-4 col-md-8">                                  
                                <input type="submit" value="<spring:message code="common.btn.save"/>" class="btn btn-primary">
                            </div>
                        </div>                                       
                    </sf:form>                    
                </div>                
            </div>
        </div>
    </div>
                        
</div>
