<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    
    <!--Breadcrumb row-->
    <div class="row">

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
                            <label class="control-label col-md-4" for="activityName">
                                <spring:message code="activity.table.activityName"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="activityName" path="activityName" class="form-control" /> 
                            </div>
                        </div>
                       <div class="form-group">
                           <label class="control-label col-md-4" for="activityType">
                               <spring:message code="activity.table.activityType"/>
                           </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="activityType" path="activityType" class="form-control" /> 
                            </div>
                        </div>                            
                        <div class="form-group">
                            <label for="instructions" class="control-label col-md-4">
                                <spring:message code="activity.table.instructions"/>    
                            </label>
                            <div class="col-md-8">
                                <sf:textarea id="instructions" path="instructions" class="form-control" /> 
                            </div>
                        </div>                              
                        <div class="form-group">
                            <label class="control-label col-md-4" for="totalTime">
                                <spring:message code="activity.table.totalTime"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="totalTime" path="totalTime" class="form-control" /> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="goals" class="control-label col-md-4">
                                <spring:message code="activity.table.goals"/>
                            </label>
                            <div class="col-md-8">
                                <sf:textarea id="goals" path="goals" class="form-control" /> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-md-4" for="metricType">
                                <spring:message code="activity.table.metricType"/>    
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="metricType" path="metricType" class="form-control" /> 
                            </div>
                        </div>         
                        <div class="form-group">
                            <label class="control-label col-md-4" for="uomCode">
                                <spring:message code="activity.table.uomCode"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="uomCode" path="uomCode" class="form-control"/> 
                            </div>
                        </div>                              
                        <div class="form-group">
                            <label class="control-label col-md-4" for="quantityMin">
                                <spring:message code="activity.table.quantityMin"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="quantityMin" path="quantityMin" class="form-control"/> 
                            </div>
                        </div>                                              
                        <div class="form-group">
                            <label class="control-label col-md-4" for="quantityMax">
                                <spring:message code="activity.table.quantityMax"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="quantityMax" path="quantityMax" class="form-control"/> 
                                <sf:hidden path="active"/>
                            </div>
                        </div>                                                                          
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
    
