
<!--<div class="container-fluid">-->   
    
    <!--Breadcrumb row-->
    <div class="row">
        <div class="col-12 col-md-10 col-xl-8">
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
    </div>
    
 
    <!--Person Manage row-->
    <div class="row">
        <div class="col-12 col-md-10 col-xl-8">
            <div class="card">
                <div class="card-header">
                    <h5><spring:message code="person.manage.title"/></h5>
                </div>
                <div class="card-body">
                                           
                    <sf:form 
                        id="personForm"
                        modelAttribute="person" 
                        action="${contextRoot}/manage/person" 
                        method="POST"
                        class="form-horizonal"
                        enctype="multipart/form-data">
                        <div class="form-row">   
                            <div class="form-group col-sm-4 col-md-4 col-lg-3">
                                <img class="img-fluid d-block mx-auto" src="${images}/person_${person.personId}.jpg" alt=""> 
                            </div>
                            <div class="form-group col-sm-4 col-md-4 col-lg-3">
                                <label for="file" class="col-form-label">
                                    <spring:message code="common.field.file.upload"/></label>
                                <div>
                                    <sf:input path="file" id="file" type="file" class="form-control"/>
                                    <sf:errors path="file" cssClass="text-danger" element="div"/>
				</div>
                            </div>                             
                        </div>
                        <div class="form-row">
                            <div class="form-group col-sm-4 col-md-4 col-lg-3">
                                <label for="firstName" class="col-form-label">
                                    <spring:message code="person.table.firstName"/></label>                                
                                <sf:hidden id="personId" path="personId"/>
                                <sf:input path="firstName" id="firstName" type="text" class="form-control" required="true"/>
                                <sf:errors path="firstName" cssClass="text-danger" element="div" />                                
                            </div>
                            <div class="form-group col-sm-4 col-md-4 col-lg-3">
                                <label for="lastName" class="col-form-label">
                                    <spring:message code="person.table.lastName"/></label>                                
                                <sf:input path="lastName" id="lastName" type="text" class="form-control" required="true"/>
                                <sf:errors path="lastName" cssClass="text-danger" element="div" />                                
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-sm-4 col-md-4 col-lg-3">
                                <label for="genderCode" class="col-form-label">
                                    <spring:message code="person.table.genderCode"/></label>                                                               
                                <sf:select path="genderCode" id="genderCode" class="form-control" required="true">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${genderCodes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>                                
                                <sf:errors path="genderCode" cssClass="text-danger" element="div" />                                
                            </div>  
                            <div class="form-group col-sm-4 col-md-4 col-lg-3">
                                <label for="personType" class="col-form-label">
                                    <spring:message code="person.table.personType"/></label>                                                               
                                <sf:select path="personType" id="personType" class="form-control" required="true">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${personTypes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select> 
                                <sf:errors path="personType" cssClass="text-danger" element="div" />                                
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-sm-4 col-md-4 col-lg-3">
                                <label for="maritalStatusCode" class="col-form-label">
                                    <spring:message code="person.table.maritalStatusCode"/></label>                               
                                <sf:select path="maritalStatusCode" id="maritalStatusCode" class="form-control">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${maritalStatusCodes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select> 
                                <sf:errors path="maritalStatusCode" cssClass="text-danger" element="div" />
                            </div>
                                                        
                        </div>
                        <div class="form-row">
                            <div class="form-group col-6 col-sm-4 col-md-4 col-lg-3">
                                <label for="dateOfBirth" class="col-form-label">
                                    <spring:message code="person.table.dateOfBirth"/></label>
                                <div>
                                    <sf:input path="dateOfBirth" id="dateOfBirth" type="date" class="form-control" required="true"/> 
                                    <sf:errors path="dateOfBirth" cssClass="text-danger" element="div" />
                                </div>
                            </div> 
                            <div class="form-group col-6 col-sm-4 col-md-4 col-lg-3">
                                <label for="startDate" class="col-form-label">
                                    <spring:message code="common.field.startDate"/></label>
                                <div>
                                    <sf:input path="startDate" id="startDate" type="date" class="form-control" required="true"/> 
                                    <sf:errors path="startDate" cssClass="text-danger" element="div" />
                                </div>
                            </div>  
                            <c:if test="${person.personId > 0 }">
                                <div class="form-group col-6 col-sm-4 col-md-4 col-lg-3">
                                    <label for="endDate" class="col-form-label">
                                        <spring:message code="common.field.endDate"/></label>
                                    <div>
                                        <sf:input path="endDate" id="endDate" type="date" class="form-control"/> 
                                        <sf:errors path="endDate" cssClass="text-danger" element="div" />
                                    </div>
                                </div>   
                            </c:if>                            
                        </div>
                        
                        <div class="form-group">								                                                        
                            <button type="submit" class="btn btn-primary">
                                <spring:message code="common.btn.save"/></button>
                        </div>                                       
                    </sf:form>                    
                
                    
                    
                
                </div>                
            </div>
        </div>
    </div>
             
                                
    <%@include  file="contactPoints.jsp"%>                                
<!--</div>-->