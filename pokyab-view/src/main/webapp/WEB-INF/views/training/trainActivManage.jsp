<!--Borrar jsp probable ya no se utilizara-->

<div class="container">
    
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
            <div class="card">
                <div class="card-header">
                    <h5><spring:message code="trainActiv.manage.title"/></h5>
                </div>
                <div class="card-body">
                    
                    <sf:form
                        id="trainingActivityForm"                            
                        modelAttribute="trainingActivity" 
                        action="${contextRoot}/manage/trainingActivity" 
                        method="POST"
                        class="form-horizonal">
                        <div class="form-group col-md-8">
                            <label for="activityNumber" class="col-form-label col-md-4">
                                <spring:message code="trainActiv.table.activityNumber"/></label>                            
                            <sf:hidden path="activityId"/>
                            <sf:hidden path="trainingId"/>
                            <sf:input path="activityNumber" id="activityNumber" type="text" class="form-control" /> 
                            <sf:errors path="activityNumber" cssClass="text-danger" element="div" />                            
                        </div>                             
                        <div class="form-group col-md-8">
                            <label class="col-form-label" for="positionCode">
                                <spring:message code="trainActiv.table.positionType"/></label>
                            <!--<sf:input path="positionCode" id="positionCode" type="text" class="form-control"/>--> 
                            <sf:select path="positionCode" id="positionCode" class="form-control">
                                <sf:option value="" label="---"/>
                                <sf:options items="${positionCodes}" itemLabel="meaning" itemValue="lookupCode" />
                            </sf:select>
                            <sf:errors path="positionCode" cssClass="text-danger" element="div" />                            
                        </div>                                                 
                        <div class="form-group col-md-8">
                            <label for="startTime" class="col-form-label col-md-4">
                                <spring:message code="trainActiv.table.startTime"/></label>
                            <sf:input path="startTime" id="startTime" type="time" class="form-control"/>
                            <sf:errors path="startTime" cssClass="text-danger" element="div" />                            
                        </div>   
                        <div class="form-group col-md-8">
                            <label for="endTime" class="col-form-label col-md-4">
                                <spring:message code="trainActiv.table.endTime"/></label>
                            <sf:input path="endTime" id="endTime" type="time" class="form-control-time" /> 
                            <sf:errors path="endTime" cssClass="text-danger" element="div" />
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
