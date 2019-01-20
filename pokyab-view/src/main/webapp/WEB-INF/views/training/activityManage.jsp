<!--<div class="container-fluid">-->
    
    <!--Breadcrumb row-->
    <div class="row">
        <div class="col-12 col-md-10 col-xl-8">
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
    </div>
 
    <!--Training row-->
    <div class="row">
        <div class="col-12 col-md-10 col-xl-8">
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
                        <div class="form-row">
                            <div class="form-group col-sm-6 col-md-5">
                                <label for="activityName" class="col-form-label">
                                    <spring:message code="activity.table.activityName"/></label>
                                <sf:hidden path="activityId" id="activityId"/>
                                <sf:input path="activityName" id="activityName" type="text" class="form-control" required="true"/>
                                <sf:errors path="activityName" cssClass="text-danger" element="div"/>
                            </div>
                            <div class="form-group col-sm-6 col-md-5">
                               <label for="activityType" class="col-form-label">
                                   <spring:message code="activity.table.activityType"/></label>                            
                                <sf:select path="activityType" id="activityType" class="form-control" required="true">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${activityTypes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>
                                <sf:errors path="activityType" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-sm-6 col-md-5">
                                <label for="instructions" class="col-form-label">
                                    <spring:message code="activity.table.instructions"/></label>
                                <sf:textarea path="instructions" id="instructions" class="form-control" required="true"/>
                                <sf:errors path="instructions" cssClass="text-danger" element="div"/>
                            </div>                              
                            <div class="form-group col-sm-6 col-md-5">
                                <label for="goals" class="col-form-label">
                                    <spring:message code="activity.table.goals"/></label>
                                <sf:textarea path="goals" id="goals" class="form-control" />
                                <sf:errors path="goals" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-row"> 
                            <div class="form-group col-sm-5 col-md-4">
                                <label  for="metricType" class="col-form-label">
                                    <spring:message code="activity.table.metricType"/></label>                            
                                <sf:select path="metricType" id="metricType" class="form-control" required="true">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${metricTypes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>
                                <sf:errors path="metricType" cssClass="text-danger" element="div"/>
                            </div>                            
                            <div class="form-group col-sm-2 col-md-2">
                                <label for="totalTime" class="col-form-label">
                                    <spring:message code="activity.table.totalTime"/></label>
                                <sf:input path="totalTime" id="totalTime" type="number" class="form-control" required="true"/> 
                                <sf:errors path="totalTime" cssClass="text-danger" element="div"/>                            
                            </div> 
                            <div class="form-group col-sm-5 col-md-4">
                                <label for="uomCode" class="col-form-label">
                                    <spring:message code="activity.table.uomCode"/></label>                            
                                <sf:select path="uomCode" id="uomCode" class="form-control" required="true">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${uomCodes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>
                                <sf:errors path="uomCode" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-row">                          
                            <div class="form-group col-6 col-sm-3 col-md-2">
                                <label for="quantityMin" class="col-form-label">
                                    <spring:message code="activity.table.quantityMin"/></label>
                                <sf:input path="quantityMin" id="quantityMin" type="number" class="form-control"/> 
                                <sf:errors path="quantityMin" cssClass="text-danger" element="div"/>                            
                            </div>                       
                            <div class="form-group col-6 col-sm-3 col-md-2">
                                <label for="quantityMax" class="col-form-label">
                                    <spring:message code="activity.table.quantityMax"/></label>
                                <sf:input path="quantityMax" id="quantityMax" type="number" class="form-control"/>
                                <sf:errors path="quantityMax" cssClass="text-danger" element="div"/>
                            </div>  
                            <div class="form-group col-6 col-sm-3 col-md-3">
                                <label for="startDate" class="col-form-label">
                                    <spring:message code="common.field.startDate"/></label>
                                <div>
                                    <sf:input path="startDate" id="startDate" type="date" class="form-control" required="true"/> 
                                </div>
                                <sf:errors path="startDate" cssClass="text-danger" element="div"/>
                            </div> 
                            <c:if test="${activity.activityId > 0 }">
                                <div class="form-group col-6 col-sm-3 col-md-3">
                                    <label for="endDate" class="col-form-label">
                                        <spring:message code="common.field.endDate"/></label>
                                    <div>
                                        <sf:input path="endDate" id="endDate" type="date" class="form-control"/> 
                                    </div>
                                    <sf:errors path="endDate" cssClass="text-danger" element="div"/>                                
                                </div>  
                            </c:if>
                        </div>
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
    
<!--</div>-->