<!--Borrar jsp probable ya no se utilizara-->

<div class="container">
    <%@include file="alertMessage.jsp" %>
    
    <!--Breadcrumb row-->
    <div class="row">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextRoot}/home">
                        <spring:message code="menu.navbar.home"/></a></li>                
                <li class="breadcrumb-item active" aria-current="page"></li>
            </ol>
        </nav>
    </div>
    <!--Alert Message Row-->
    <%@include file="alertMessage.jsp" %>
    
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
                        <div class="form-group row">
                            <label for="activityNumber" class="col-form-label col-md-4">
                                <spring:message code="trainActiv.table.activityNumber"/></label>
                            <div class="col-md-8">
                                <sf:hidden path="activityId"/>
                                <sf:hidden path="trainingId"/>
                                <sf:input path="activityNumber" id="activityNumber" type="text" class="form-control" /> 
                                <sf:errors path="activityNumber" cssClass="text-danger" element="div" />
                            </div>
                        </div>                             
                        <div class="form-group">
                            <label class="col-form-label col-md-4" for="positionCode">
                                <spring:message code="trainActiv.table.positionType"/></label>
                            <div class="col-md-8">
                                <sf:input path="positionCode" id="positionCode" type="text" class="form-control"/> 
                                <sf:errors path="positionCode" cssClass="text-danger" element="div" />
                            </div>
                        </div>                                                 
                        <div class="form-group">
                            <label for="startTime" class="col-form-label col-md-4">
                                <spring:message code="trainActiv.table.startTime"/></label>
                            <div class="col-md-8">
                                <sf:input path="startTime" id="startTime" type="time" class="form-control"/>
                                <sf:errors path="startTime" cssClass="text-danger" element="div" />
                            </div>
                        </div>   
                        <div class="form-group">
                            <label for="endTime" class="col-form-label col-md-4">
                                <spring:message code="trainActiv.table.endTime"/></label>
                            <div class="col-md-8">
                                <sf:input path="endTime" id="endTime" type="time" class="form-control-time" /> 
                                <sf:errors path="endTime" cssClass="text-danger" element="div" />
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
                            <sf:errors path="daysFlag" cssClass="text-danger" element="div" />
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
    
