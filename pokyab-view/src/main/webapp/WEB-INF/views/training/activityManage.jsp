

<div class="container">
    <%@include file="alertMessage.jsp" %>
    
    <!--Breadcrumb row-->
    <div class="row">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextRoot}/home">
                    <spring:message code="menu.navbar.home"/></a></li>   
                <li class="breadcrumb-item"><a href="${contextRoot}/activities">
                    <spring:message code="menu.navbar.activities"/></a></li>
                <li class="breadcrumb-item active" aria-current="page">${activity.activityName}</li>
            </ol>
        </nav>
    </div>
 
    <!--Training row-->
    <div class="row">
        <div class="col-12 col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4><spring:message code="activity.manage.title"/></h4>
                </div>
                <div class="panel-body">
                    
                    <sf:form
                        id="activityForm"                            
                        modelAttribute="activity" 
                        action="${contextRoot}/manage/activity" 
                        method="POST"
                        class="form-horizonal">
                        <div class="form-group">
                            <label for="activityName" class="col-form-label col-md-4">
                                <spring:message code="activity.table.activityName"/></label>
                            <div class="col-md-8">
                                <sf:input path="activityId" id="activityId" type="hidden"/>
                                <sf:input path="activityName" id="activityName" type="text" class="form-control" />
                                <sf:errors path="activityName" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">
                           <label for="activityType" class="col-form-label col-md-4">
                               <spring:message code="activity.table.activityType"/></label>
                            <div class="col-md-8">
                                <sf:input path="activityType" id="activityType" type="text" class="form-control" />
                                <sf:errors path="activityType" cssClass="text-danger" element="div"/>
                            </div>
                        </div>                            
                        <div class="form-group">
                            <label for="instructions" class="col-form-label col-md-4">
                                <spring:message code="activity.table.instructions"/></label>
                            <div class="col-md-8">
                                <sf:textarea path="instructions" id="instructions" class="form-control" />
                                <sf:errors path="instructions" cssClass="text-danger" element="div"/>
                            </div>
                        </div>                              
                        <div class="form-group">
                            <label for="totalTime" class="col-form-label col-md-4">
                                <spring:message code="activity.table.totalTime"/></label>
                            <div class="col-md-4">
                                <sf:input path="totalTime" id="totalTime" type="number" class="form-control" /> 
                                <sf:errors path="totalTime" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="goals" class="col-form-label col-md-4">
                                <spring:message code="activity.table.goals"/></label>
                            <div class="col-md-8">
                                <sf:textarea path="goals" id="goals" class="form-control" />
                                <sf:errors path="goals" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  for="metricType" class="col-form-label col-md-4">
                                <spring:message code="activity.table.metricType"/></label>
                            <div class="col-md-8">
                                <sf:input path="metricType" id="metricType" type="text" class="form-control" /> 
                                <sf:errors path="metricType" cssClass="text-danger" element="div"/>
                            </div>
                        </div>         
                        <div class="form-group">
                            <label for="uomCode" class="col-form-label col-md-4">
                                <spring:message code="activity.table.uomCode"/></label>
                            <div class="col-md-8">
                                <sf:input path="uomCode" id="uomCode" type="text" class="form-control"/>
                                <sf:errors path="uomCode" cssClass="text-danger" element="div"/>
                            </div>
                        </div>                              
                        <div class="form-group">
                            <label for="quantityMin" class="col-form-label col-md-4">
                                <spring:message code="activity.table.quantityMin"/></label>
                            <div class="col-md-4">
                                <sf:input path="quantityMin" id="quantityMin" type="number" class="form-control"/> 
                                <sf:errors path="quantityMin" cssClass="text-danger" element="div"/>
                            </div>
                        </div>                                              
                        <div class="form-group">
                            <label for="quantityMax" class="col-form-label col-md-4">
                                <spring:message code="activity.table.quantityMax"/></label>
                            <div class="col-md-4">
                                <sf:input path="quantityMax" id="quantityMax" type="number" class="form-control"/>
                                <sf:errors path="quantityMax" cssClass="text-danger" element="div"/>
                            </div>
                        </div>  
                        <div class="form-group">
                            <label for="startDate" class="col-form-label col-md-4">
                                <spring:message code="common.field.startDate"/>:</label>
                            <div class="col-md-4">
                                <sf:input path="startDate" id="startDate" type="date"/>
                                <sf:errors path="startDate" cssClass="text-danger" element="div"/>
                            </div>
                        </div> 
                        <c:if test="${activity.activityId > 0 }">
                            <div class="form-group">
                                <label for="endDate" class="col-form-label col-md-4">
                                    <spring:message code="common.field.endDate"/>:</label>
                                <div class="col-md-4">
                                    <sf:input path="endDate" id="endDate" type="date"/>
                                    <sf:errors path="endDate" cssClass="text-danger" element="div"/>
                                </div>
                            </div>  
                        </c:if>                         
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" name="submit" value="<spring:message code="common.btn.save"/>" class="btn btn-primary"/>
                            </div>
                        </div>                                        
                    </sf:form>                    
                </div>                
            </div>
        </div>
    </div>
    
