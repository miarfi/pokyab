
<div class="container">   
    <!--Breadcrumb row-->
    <div class="row">

    </div>
 
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
                        class="form-horizonal">

                        <div class="form-group">
                            <label for="firstName" class="control-label col-md-4">
                                <spring:message code="person.table.firstName"/>:
                            </label>
                            <div class="col-md-8">
                                <sf:input id="personId" path="personId" type="hidden"/>
                                <sf:input path="firstName" id="firstName" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastName" class="control-label col-md-4"><spring:message code="person.table.lastName"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="lastName" id="lastName" type="text" class="form-control"/>
                            </div>
                        </div>                              
                        <div class="form-group">
                            <label for="genderCode" class="control-label col-md-4"><spring:message code="person.table.genderCode"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="genderCode" id="genderCode" type="text" class="form-control"/>
                            </div>
                        </div>  
                        <div class="form-group">
                            <label for="personType" class="control-label col-md-4"><spring:message code="person.table.personType"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="personType" id="personType" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="maritalStatusCode" class="control-label col-md-4"><spring:message code="person.table.maritalStatusCode"/>:</label>
                            <div class="col-md-8">
                                <sf:input id="maritalStatusCode" path="maritalStatusCode" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dateOfBirth" class="control-label col-md-4"><spring:message code="person.table.dateOfBirth"/>:</label>
                            <div class="col-md-4">
                                <sf:input id="dateOfBirth" path="dateOfBirth" type="date"/>
                            </div>
                        </div>                         
                        <div class="form-group">
                            <label for="startDate" class="control-label col-md-4"><spring:message code="common.field.startDate"/>:</label>
                            <div class="col-md-4">
                                <sf:input id="startDate" path="startDate" type="date"/>
                            </div>
                        </div>  
                        <c:if test="${person.personId > 0 }">
                            <div class="form-group">
                                <label for="endDate" class="control-label col-md-4"><spring:message code="common.field.endDate"/>:</label>
                                <div class="col-md-4">
                                    <sf:input id="endDate" path="endDate" type="date"/>
                                </div>
                            </div>   
                        </c:if>                        
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
