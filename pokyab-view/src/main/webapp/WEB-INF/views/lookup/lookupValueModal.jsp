<!--LookupValue Modal Row-->    
<div class="row">
    <div class="modal fade" id="mylookupValueModal" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <!--Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title"><spring:message code="lookupValue.modal.title"/></h4>
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>						
                    </button>                    
                </div>
                <sf:form 
                    id="seasonForm"
                    modelAttribute="lookupValue" 
                    action="${contextRoot}/manage/lookupValue" 
                    method="POST"
                    class="form-group">
                    <!--Modal Body -->
                    <div class="modal-body">                    
                        <div class="form-group">
                            <label for="lookupCode" class="col-form-label col-md-4">
                                <spring:message code="lookupValue.table.lookupCode"/>:</label>
                            <div class="col-md-8">
                                <sf:hidden path="lookupTypeId"/>
                                <sf:input path="lookupCode" id="lookupValue" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="meaning" class="col-form-label col-md-4">
                                <spring:message code="lookupValue.table.meaning"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="meaning" id="lookupValue" type="text" class="form-control"/>
                            </div>
                        </div>                         
                        <div class="form-group">
                            <label for="description" class="col-form-label col-md-4">
                                <spring:message code="lookupValue.table.description"/>:</label>
                            <div class="col-md-8">
                                <sf:textarea path="description" id="description" class="form-control"/> 
                            </div>
                        </div> 
                        <div class="form-group">
                            <label for="startDate" class="col-form-label col-md-4">
                                <spring:message code="common.field.startDate"/>:</label>
                            <div class="col-md-4">
                                <sf:input path="startDate" id="startDate" type="date"/>
                            </div>
                        </div>
<!--                        <div class="form-group">
                            <label for="languageCode" class="col-form-label col-md-4"><spring:message code="common.field.language"/>:</label>
                            <div class="col-md-4">
                                <sf:input path="languageCode" id="languageCode" type="text"/>
                            </div>
                        </div>                        -->                                            
                    </div>
                    <!--Modal Footer-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                            <spring:message code="common.btn.close"/></button>
                        <button type="submit" class="btn btn-primary">
                            <spring:message code="lookupType.table.btn.addLookupValue"/></button>                    
                    </div>
                </sf:form>
            </div>
        </div>
    </div>
</div
