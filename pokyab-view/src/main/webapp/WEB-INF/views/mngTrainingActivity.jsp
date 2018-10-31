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
                    <h4><spring:message code="trainActiv.manage.title"/></h4>
                </div>
                <div class="panel-body">
                    
                    <sf:form
                        id="trainingActivityForm"                            
                        modelAttribute="trainingActivity" 
                        action="${contextRoot}/manage/trainingActivity" 
                        method="POST"
                        class="form-horizonal">
                        <div class="form-group">
                            <label class="control-label col-md-4" for="activityNumber">
                                <spring:message code="trainActiv.table.activityNumber"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="activityNumber" path="activityNumber" class="form-control" /> 
                            </div>
                        </div>                             
                        <div class="form-group">
                            <label class="control-label col-md-4" for="positionCode">
                                <spring:message code="trainActiv.table.positionType"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="positionCode" path="positionCode" class="form-control"/> 
                            </div>
                        </div>                          
                        <div class="form-group">
                            <label class="control-label col-md-4" for="weeks">
                                <spring:message code="trainActiv.table.weeks"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="weeks" path="weeks" class="form-control" /> 
                            </div>
                        </div>                                              
                        <div class="form-group">
                            <label class="control-label col-md-4" for="days">
                                <spring:message code="trainActiv.table.days"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="days" path="days" class="form-control"/> 
                                <sf:hidden path="activityId"/>
                                <sf:hidden path="trainingId"/>
                            </div>
                        </div> 
                                
                        <div class="form-group col-md-12">
<div class="form-check form-check-inline disabled">
  <label class="form-check-label">
    <sf:checkbox id="mondayFlag" path="mondayFlag" value="Y" />
    <spring:message code="trainActiv.table.monday"/>
  </label>
</div>
<div class="form-check form-check-inline disabled">
  <label class="form-check-label">
    <sf:checkbox id="tuesdayFlag" path="tuesdayFlag" value="Y"/>
    <spring:message code="trainActiv.table.tuesday"/>
  </label>
</div>
<div class="form-check form-check-inline disabled">
  <label class="form-check-label">    
    <sf:checkbox id="wednesdayFlag" path="wednesdayFlag" value="Y" />
    <spring:message code="trainActiv.table.wednesday"/>
  </label>
</div>                  
<div class="form-check form-check-inline disabled">
  <label class="form-check-label">
    <sf:checkbox id="thursdayFlag" path="thursdayFlag" value="Y" />
    <spring:message code="trainActiv.table.thursday"/>
  </label>
</div>
<div class="form-check form-check-inline disabled">
  <label class="form-check-label">
    <sf:checkbox id="fridayFlag" path="fridayFlag" value="Y" />
    <spring:message code="trainActiv.table.friday"/>
  </label>
</div>
<div class="form-check form-check-inline disabled">
  <label class="form-check-label">
    <sf:checkbox id="saturdayFlag" path="saturdayFlag" value="Y" />
    <spring:message code="trainActiv.table.saturday"/>
  </label>
</div>
  
                        </div>       
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" name="submit" value="Save" class="btn btn-primary"/>
                            </div>
                        </div>                                        
                    </sf:form>                    
                </div>                
            </div>
        </div>
    </div>
    
