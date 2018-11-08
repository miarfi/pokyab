<!--LookupValue Modal Row-->    
<div class="row">
    <div class="modal fade" id="mylookupValueModal" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <!--Modal Header -->
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span>&times;</span>						
                    </button>
                    <h4 class="modal-title"><spring:message code="lookupValue.modal.title"/></h4>
                </div>
                <!--Modal Body -->
                <div class="modal-body">
                    <sf:form 
                        id="seasonForm"
                        modelAttribute="lookupValue" 
                        action="${contextRoot}/manage/lookupValue" 
                        method="POST"
                        class="form-group">
                        <div class="form-group">
                            <label for="lookupCode" class="control-label col-md-4"><spring:message code="lookupValue.table.lookupCode"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="lookupCode" id="lookupValue" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="meaning" class="control-label col-md-4"><spring:message code="lookupValue.table.meaning"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="meaning" id="lookupValue" type="text" class="form-control"/>
                            </div>
                        </div>                         
                        <div class="form-group">
                            <label for="description" class="control-label col-md-4"><spring:message code="lookupValue.table.description"/>:</label>
                            <div class="col-md-8">
                                <sf:textarea id="description" path="description" class="form-control"/> 
                                <sf:hidden path="lookupTypeId"/>
                            </div>
                        </div> 
                        <div class="form-group">
                            <label for="startDate" class="control-label col-md-4"><spring:message code="common.field.startDate"/>:</label>
                            <div class="col-md-4">
                                <sf:input id="startDate" path="startDate" type="date"/>
                            </div>
                        </div>
<!--                        <div class="form-group">
                            <label for="endDate" class="control-label col-md-4"><spring:message code="common.field.endDate"/>:</label>
                            <div class="col-md-4">
                                <sf:input id="endDate" path="endDate" type="date"/>
                            </div>
                        </div>                        -->
                        <div class="form-group">								
                            <div class="col-offset-4 col-md-8">                                   
                                <input type="submit" value="<spring:message code="lookupType.table.btn.addLookupValue"/>" class="btn btn-primary">
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
