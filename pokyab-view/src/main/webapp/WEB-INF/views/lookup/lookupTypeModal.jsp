<!--LookupType Modal Row-->    
<div class="row">
    <div class="modal fade" id="myLookupTypeModal" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <!--Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title"><spring:message code="lookupType.modal.title"/></h4>
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>						
                    </button>                    
                </div>
                <sf:form 
                    id="seasonForm"
                    modelAttribute="lookupType" 
                    action="${contextRoot}/manage/lookupType" 
                    method="POST"
                    class="form-group">
                    <!--Modal Body -->
                    <div class="modal-body">
                    
                        <div class="form-group">
                            <label for="lookupType" class="col-form-label col-md-4">
                                <spring:message code="lookupType.table.lookupType"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="lookupType" id="lookupType" type="text" class="form-control" required="true"/>                                
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-form-label col-md-4">
                                <spring:message code="lookupType.table.description"/>:</label>
                            <div class="col-md-8">
                                <sf:textarea path="description" id="description" class="form-control" required="true"/>                                 
                            </div>
                        </div> 
                        <div class="form-group">
                            <label for="startDate" class="col-form-label col-md-4">
                                <spring:message code="common.field.startDate"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="startDate" id="startDate" type="date" class="form-control" required="true"/>                                 
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-check ">
                                <div class="col-md-4">
                                <sf:checkbox path="systemFlag" id="systemFlag" value="Y" cssClass="form-check-input" />                                                                                                                                           
                                <label for="systemFlag" class="form-check-label">
                                    <spring:message code="lookupType.table.system"/></label>
                                </div>
                            </div>  
                        </div>                                                                    
                    </div>
                    <!--Modal Footer-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                            <spring:message code="common.btn.close"/></button>
                        <button type="submit" class="btn btn-primary">
                            <spring:message code="lookupType.table.btn.addLookupType"/></button>                    
                    </div>
                </sf:form>
            </div>
        </div>
    </div>
</div>
