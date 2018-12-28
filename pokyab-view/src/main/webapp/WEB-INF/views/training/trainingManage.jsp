<div class="container">

    <!--Breadcrumb row-->
    <div class="row">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextRoot}/home">
                    <spring:message code="menu.navbar.home"/></a></li>
                <li class="breadcrumb-item"><a href="${contextRoot}/trainings">
                    <spring:message code="menu.navbar.trainings"/></a></li>
                <li class="breadcrumb-item active" aria-current="page">${training.trainingName}</li>
            </ol>
        </nav>
    </div>
    
    <!--Training row-->
    <div class="row">
        <div class="col-12 col-lg-8">
            <div class="card">
                <div class="card-header">
                    <h5><spring:message code="training.manage.title"/></h5>
                </div>
                <div class="card-body">

                    <sf:form
                        id="trainingForm"                            
                        modelAttribute="training" 
                        action="${contextRoot}/manage/training" 
                        method="POST"
                        class="form-horizonal">
                        <div class="form-row">
                            <div class="form-group col-sm-6 col-md-5">
                                <label for="trainingName" class="col-form-label">
                                    <spring:message code="training.table.trainingName"/></label>                            
                                <sf:input id="trainingId" path="trainingId" type="hidden"/>
                                <sf:input path="trainingName" id="trainingName" type="text" class="form-control"/> 
                                <sf:errors path="trainingName" cssClass="text-danger" element="div"/>                            
                            </div>
                            <div class="form-group col-sm-6 col-md-5">
                                <label for="weeks" class="col-form-label">
                                    <spring:message code="training.table.weeks"/></label>
                                <sf:input path="weeks" id="weeks" type="text" class="form-control" /> 
                                <sf:errors path="weeks" cssClass="text-danger" element="div" />                            
                            </div> 
                        </div>
                        <div class="form-row">
                            <div class="form-group col-sm-6 col-md-5">
                                <label for="description" class="col-form-label">
                                    <spring:message code="training.table.description"/></label>                            
                                <sf:textarea path="description" id="description" class="form-control"/> 
                                <sf:errors path="description" cssClass="text-danger" element="div" />                            
                            </div>
                            <div class="form-group col-sm-6 col-md-5">
                                <label for="goals" class="col-form-label">
                                    <spring:message code="training.table.goals"/></label>                            
                                <sf:textarea id="goals" path="goals" class="form-control"/> 
                                <sf:errors path="goals" cssClass="text-danger" element="div" />                            
                            </div>                                                           
                        </div> 
                        <div class="form-row">
                            <div class="form-group col-sm-6 col-md-5">
                                <label  for="categoryCode" class="col-form-label">
                                    <spring:message code="training.table.categoryCode"/></label>                            
                                <sf:select path="categoryCode" id="categoryCode" class="form-control">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${trainCategoryCodes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>
                                <sf:errors path="categoryCode" cssClass="text-danger" element="div" />
                            </div>
                            <c:if test="${training.trainingId > 0 }">
                                <div class="form-group col-sm-6 col-md-5">
                                    <label  for="statusCode" class="col-form-label">
                                        <spring:message code="training.table.statusCode"/></label>                            
                                    <sf:select path="statusCode" id="statusCode" class="form-control">
                                        <sf:option value="" label="---"/>
                                        <sf:options items="${trainStatusCodes}" itemLabel="meaning" itemValue="lookupCode" />
                                    </sf:select>
                                    <sf:errors path="statusCode" cssClass="text-danger" element="div" />
                                </div>
                            </c:if>
                        </div>                                                     
                        <div class="form-row">
                            <div class="form-group col-5 col-sm-4 col-md-3">
                                <label for="startDate" class="col-form-label">
                                    <spring:message code="common.field.startDate"/>:</label>
                                <div>
                                    <sf:input path="startDate" id="startDate" type="date"/>
                                    <sf:errors path="startDate" cssClass="text-danger" element="div" />
                                </div>
                            </div> 
                            <c:if test="${training.trainingId > 0 }">
                                <div class="form-group col-5 col-sm-4 col-md-3">
                                    <label for="endDate" class="col-form-label">
                                        <spring:message code="common.field.endDate"/>:</label>
                                    <div>
                                        <sf:input path="endDate" id="endDate" type="date"/>
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

    <c:if test="${training.trainingId > 0 }">
        <script>
            window.trainingId = '${training.trainingId}';
        </script>
        <!--Button Row-->
        <div class="row">
            <div class="col-12 col-lg-8">
                <div class="text-right">
                    <br/>										
                    <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myTrainActivModal">
                        <spring:message code="training.table.btn.addTrainActiv"/>
                    </button>
                </div>      
            </div>
        </div>

        <!--Training activity table row-->
        <%@include file="trainActivities.jsp" %>

        <!--Training activity modal row-->
        <%@include file="trainActivModal.jsp" %>
    </c:if>
</div>
