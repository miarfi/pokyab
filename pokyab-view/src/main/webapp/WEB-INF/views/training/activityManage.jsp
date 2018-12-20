<div class="container">
    
    <!--Breadcrumb row-->
    <div class="row">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextRoot}/home">
                    <spring:message code="menu.navbar.home"/></a></li>   
                <li class="breadcrumb-item"><a href="${contextRoot}/activities">
                    <spring:message code="menu.navbar.activities"/></a></li>
                <li class="breadcrumb-item active" aria-current="page">${activity.activityName}</li>
                <a href="../lookup/lookupMain.jsp"></a>
            </ol>
        </nav>
    </div>
 
    <!--Training row-->
    <div class="row">
        <div class="col-12 col-lg-8">
            <div class="card">
                <div class="card-header">
                    <h4><spring:message code="activity.manage.title"/></h4>
                </div>
                <div class="card-body">
                    
                    <sf:form
                        id="activityForm"                            
                        modelAttribute="activity" 
                        action="${contextRoot}/manage/activity" 
                        method="POST"
                        class="form-horizonal">
                        <div class="form-group col-md-8">
                            <label for="activityName" class="col-form-label">
                                <spring:message code="activity.table.activityName"/></label>
                            <sf:input path="activityId" id="activityId" type="hidden"/>
                            <sf:input path="activityName" id="activityName" type="text" class="form-control" />
                            <sf:errors path="activityName" cssClass="text-danger" element="div"/>
                        </div>
                        <div class="form-group col-md-8">
                           <label for="activityType" class="col-form-label">
                               <spring:message code="activity.table.activityType"/></label>                            
                            <sf:select path="activityType" id="activityType" class="form-control">
                                <sf:option value="" label="---"/>
                                <sf:options items="${activityTypes}" itemLabel="meaning" itemValue="lookupCode" />
                            </sf:select>
                            <sf:errors path="activityType" cssClass="text-danger" element="div"/>
                        </div>                            
                        <div class="form-group col-md-8">
                            <label for="instructions" class="col-form-label">
                                <spring:message code="activity.table.instructions"/></label>
                            <sf:textarea path="instructions" id="instructions" class="form-control" />
                            <sf:errors path="instructions" cssClass="text-danger" element="div"/>
                        </div>                              
                        <div class="form-group col-md-8">
                            <label for="totalTime" class="col-form-label">
                                <spring:message code="activity.table.totalTime"/></label>
                            <sf:input path="totalTime" id="totalTime" type="number" class="form-control" /> 
                            <sf:errors path="totalTime" cssClass="text-danger" element="div"/>                            
                        </div>
                        <div class="form-group col-md-8">
                            <label for="goals" class="col-form-label">
                                <spring:message code="activity.table.goals"/></label>
                            <sf:textarea path="goals" id="goals" class="form-control" />
                            <sf:errors path="goals" cssClass="text-danger" element="div"/>
                        </div>
                        <div class="form-group col-md-8">
                            <label  for="metricType" class="col-form-label">
                                <spring:message code="activity.table.metricType"/></label>                            
                            <sf:select path="metricType" id="metricType" class="form-control">
                                <sf:option value="" label="---"/>
                                <sf:options items="${metricTypes}" itemLabel="meaning" itemValue="lookupCode" />
                            </sf:select>
                            <sf:errors path="metricType" cssClass="text-danger" element="div"/>
                        </div>         
                        <div class="form-group col-md-8">
                            <label for="uomCode" class="col-form-label">
                                <spring:message code="activity.table.uomCode"/></label>                            
                            <sf:select path="uomCode" id="uomCode" class="form-control">
                                <sf:option value="" label="---"/>
                                <sf:options items="${uomCodes}" itemLabel="meaning" itemValue="lookupCode" />
                            </sf:select>
                            <sf:errors path="uomCode" cssClass="text-danger" element="div"/>
                        </div>                              
                        <div class="form-group col-md-8">
                            <label for="quantityMin" class="col-form-label">
                                <spring:message code="activity.table.quantityMin"/></label>
                            <sf:input path="quantityMin" id="quantityMin" type="number" class="form-control"/> 
                            <sf:errors path="quantityMin" cssClass="text-danger" element="div"/>                            
                        </div>                                              
                        <div class="form-group col-md-8">
                            <label for="quantityMax" class="col-form-label">
                                <spring:message code="activity.table.quantityMax"/></label>
                            <sf:input path="quantityMax" id="quantityMax" type="number" class="form-control"/>
                            <sf:errors path="quantityMax" cssClass="text-danger" element="div"/>
                        </div>  
                        <div class="form-group col-md-8">
                            <label for="startDate" class="col-form-label">
                                <spring:message code="common.field.startDate"/>:</label>
                            <sf:input path="startDate" id="startDate" type="date"/>
                            <sf:errors path="startDate" cssClass="text-danger" element="div"/>
                        </div> 
                        <c:if test="${activity.activityId > 0 }">
                            <div class="form-group col-md-8">
                                <label for="endDate" class="col-form-label">
                                    <spring:message code="common.field.endDate"/>:</label>
                                <sf:input path="endDate" id="endDate" type="date"/>
                                <sf:errors path="endDate" cssClass="text-danger" element="div"/>                                
                            </div>  
                        </c:if>                         
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" class="btn btn-primary">
                                    <spring:message code="common.btn.save"/></button>
                            </div>
                        </div>                                        
                    </sf:form>                    
                </div>                
            </div>
        </div>
    </div>
    
</div>