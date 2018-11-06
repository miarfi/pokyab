<!--LookupType Modal Row-->    
<div class="row">
    <div class="modal fade" id="myLookupTypeModal" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <!--Modal Header -->
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span>&times;</span>						
                    </button>
                    <h4 class="modal-title"><spring:message code="lookupType.modal.title"/></h4>
                </div>
                <!--Modal Body -->
                <div class="modal-body">
                    <sf:form 
                        id="seasonForm"
                        modelAttribute="lookupType" 
                        action="${contextRoot}/manage/lookupType" 
                        method="POST"
                        class="form-group">
                        <div class="form-group">
                            <label for="lookupType" class="control-label col-md-4"><spring:message code="lookupType.table.lookupType"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="lookupType" id="lookupType" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="control-label col-md-4"><spring:message code="lookupType.table.description"/>:</label>
                            <div class="col-md-8">
                                <sf:textarea id="description" path="description" class="form-control"/> 
                            </div>
                        </div> 
                        <div class="form-group">
                            <div class="form-check form-check-inline disabled">
                                <label class="form-check-label">
                                    <sf:checkbox id="systemFlag" path="systemFlag" value="Y" />
                                    <spring:message code="lookupType.table.system"/>
                                </label>
                            </div> 
                        </div>                                                        
                        <div class="form-group">								
                            <div class="col-offset-4 col-md-8">                                   
                                <input type="submit" value="<spring:message code="lookupType.table.btn.addLookupType"/>" class="btn btn-primary">
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
