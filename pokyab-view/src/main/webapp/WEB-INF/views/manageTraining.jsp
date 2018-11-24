
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
                            <label for="trainingName" class="col-form-label col-md-4">
                                <spring:message code="training.table.trainingName"/>                        
                            </label>
                            <div class="col-md-8 disabled">
                                <sf:input id="trainingId" path="trainingId" type="hidden"/>
                                <sf:input path="trainingName" id="trainingName" type="text" class="form-control"/> 
                                <sf:errors path="trainingName" cssClass="text-danger" element="div"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-form-label col-md-4">
                                <spring:message code="training.table.description"/>
                            </label>
                            <div class="col-md-8 disabled">
                                <sf:textarea path="description" id="description" class="form-control"/> 
                                <sf:errors path="description" cssClass="text-danger" element="div" />
                            </div>
                        </div>                              
                        <div class="form-group">
                            <label  for="categoryCode" class="col-form-label col-md-4">
                                <spring:message code="training.table.categoryCode"/>
                            </label>
                            <div class="col-md-8 disabled">
                                <sf:input path="categoryCode" id="categoryCode" type="text" class="form-control"/> 
                                <sf:errors path="categoryCode" cssClass="text-danger" element="div" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="goals" class="col-form-label col-md-4">
                                <spring:message code="training.table.goals"/>
                            </label>
                            <div class="col-md-8 disabled">
                                <sf:textarea id="goals" path="goals" class="form-control"/> 
                                <sf:errors path="goals" cssClass="text-danger" element="div" />
                            </div>
                        </div>                              
                        <div class="form-group">
                            <label for="weeks" class="col-form-label col-md-4">
                                <spring:message code="training.table.weeks"/>                                
                            </label>
                            <div class="col-md-4 disabled">
                                <sf:input path="weeks" id="weeks" type="text" class="form-control" /> 
                                <sf:errors path="weeks" cssClass="text-danger" element="div" />
                            </div>
                        </div>                                              
<!--                        <div class="form-group">
                            <label for="days" class="col-form-label col-md-4">
                                <spring:message code="training.table.days"/>
                            </label>
                            <div class="col-md-4 disabled">
                                <sf:input path="days" id="days" type="text" class="form-control" placeholder="Days" /> 
                            </div>
                        </div>   -->
                        <div class="form-group">
                            <label for="startDate" class="col-form-label col-md-4"><spring:message code="common.field.startDate"/>:</label>
                            <div class="col-md-4">
                                <sf:input path="startDate" id="startDate" type="date"/>
                                <sf:errors path="startDate" cssClass="text-danger" element="div" />
                            </div>
                        </div> 
                        <c:if test="${training.trainingId > 0 }">
                            <div class="form-group">
                                <label for="endDate" class="col-form-label col-md-4"><spring:message code="common.field.endDate"/>:</label>
                                <div class="col-md-4">
                                    <sf:input path="endDate" id="endDate" type="date"/>
                                    <sf:errors path="endDate" cssClass="text-danger" element="div" />
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
