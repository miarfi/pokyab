
<div class="container">

    <!--Breadcrumb row-->
    <div class="row">

    </div>

    <!--Training row-->
    <div class="row">
        <div class="col-12 col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4><spring:message code="training.manage.title"/></h4>
                </div>
                <div class="panel-body">

                    <sf:form
                        id="trainingForm"                            
                        modelAttribute="training" 
                        action="${contextRoot}/manage/training" 
                        method="POST"
                        class="form-horizonal">
                        <div class="form-group">
                            <label class="control-label col-md-4" for="trainingName">
                                <spring:message code="training.table.trainingName"/>                        
                            </label>
                            <div class="col-md-8 disabled">
                                <sf:input id="trainingId" path="trainingId" type="hidden"/>
                                <sf:input type="text " id="trainingName" path="trainingName" class="form-control"/> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="control-label col-md-4">
                                <spring:message code="training.table.description"/>
                            </label>
                            <div class="col-md-8 disabled">
                                <sf:textarea id="description" path="description" class="form-control"/> 
                            </div>
                        </div>                              
                        <div class="form-group">
                            <label class="control-label col-md-4" for="categoryCode">
                                <spring:message code="training.table.categoryCode"/>
                            </label>
                            <div class="col-md-8 disabled">
                                <sf:input type="text" id="categoryCode" path="categoryCode" class="form-control"/> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="goals" class="control-label col-md-4">
                                <spring:message code="training.table.goals"/>
                            </label>
                            <div class="col-md-8 disabled">
                                <sf:textarea id="goals" path="goals" class="form-control"/> 
                            </div>
                        </div>                              
                        <div class="form-group">
                            <label class="control-label col-md-4" for="weeks">
                                <spring:message code="training.table.weeks"/>
                            </label>
                            <div class="col-md-4 disabled">
                                <sf:input type="text" id="weeks" path="weeks" class="form-control" /> 
                            </div>
                        </div>                                              
                        <div class="form-group">
                            <label class="control-label col-md-4" for="days">
                                <spring:message code="training.table.days"/>
                            </label>
                            <div class="col-md-4 disabled">
                                <sf:input type="text" id="days" path="days" class="form-control" placeholder="Days" /> 
                            </div>
                        </div>   
                        <div class="form-group">
                            <label for="startDate" class="control-label col-md-4"><spring:message code="common.field.startDate"/>:</label>
                            <div class="col-md-4">
                                <sf:input id="startDate" path="startDate" type="date"/>
                            </div>
                        </div> 
                        <c:if test="${training.trainingId > 0 }">
                            <div class="form-group">
                                <label for="endDate" class="control-label col-md-4"><spring:message code="common.field.endDate"/>:</label>
                                <div class="col-md-4">
                                    <sf:input id="endDate" path="endDate" type="date"/>
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

    <c:if test="${training.trainingId > 0 }">
        <script>
            window.trainingId = '${training.trainingId}';
        </script>
        <!--Button Row-->
        <div class="row">
            <div class="col-12 col-md-8">
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
