<div class="row">
    <div class="modal fade" id="myTrainActivModal" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <!--Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title"><spring:message code="trainActiv.table.title"/></h4>
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>						
                    </button>                    
                </div>
                <!--Modal Body -->
                <div class="modal-body">
                    <sf:form 
                        id="trainingActivityForm"
                        modelAttribute="trainingActivity" 
                        action="${contextRoot}/manage/trainingActivity" 
                        method="POST"
                        class="form-group">

                        <div class="form-group">
                            <label class="col-form-label col-md-4" for="activityId">
                                <spring:message code="trainActiv.table.activity"/>
                            </label>
                            <div class="col-md-8">
                                <sf:select path="activityId" id="activityId" items="${activities}" itemLabel="activityName" itemValue="activityId" class="form-control"/>				
                            </div>	
                        </div>
                        <div class="form-group">
                            <label class="col-form-label col-md-8" for="activityNumber">
                                <spring:message code="trainActiv.table.activityNumber"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="activityNumber" path="activityNumber" class="form-control" /> 
                            </div>
                        </div>                             
                        <div class="form-group">
                            <label class="col-form-label col-md-4" for="positionCode">
                                <spring:message code="trainActiv.table.positionType"/>
                            </label>
                            <div class="col-md-8">                            
                                <sf:select path="positionCode" id="positionCode" class="form-control">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${positionCodes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>
                            </div>
                        </div>                          
                        <div class="form-group">
                            <label class="col-form-label col-md-4" for="startTime">
                                <spring:message code="trainActiv.table.startTime"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="startTime" path="startTime" class="form-control" /> 
                            </div>
                        </div>   
                        <div class="form-group">
                            <label class="col-form-label col-md-4" for="endTime">
                                <spring:message code="trainActiv.table.endTime"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="endTime" path="endTime" class="form-control" /> 
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
                    </sf:form>                
                </div>
                <!--Modal Footer-->
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">
                        <spring:message code="common.btn.close"/></button>
                    <button type="button" class="btn btn-primary">
                        <spring:message code="common.btn.submit"/></button>                    
                </div>                            
            </div>
        </div>
    </div>
</div>
    