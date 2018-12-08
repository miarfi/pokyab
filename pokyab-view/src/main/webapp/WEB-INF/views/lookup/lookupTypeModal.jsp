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
                            <label for="lookupType" class="col-form-label col-md-4">
                                <spring:message code="lookupType.table.lookupType"/>:</label>
                            <!--<div class="col-md-8">-->
                                <sf:input path="lookupType" id="lookupType" type="text" class="form-control"/>
                                <sf:errors path="lookupType" cssClass="text-danger" element="div"/>
                            <!--</div>-->
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-form-label col-md-4">
                                <spring:message code="lookupType.table.description"/>:</label>
                            <!--<div class="col-md-8">-->
                                <sf:textarea path="description" id="description" class="form-control"/> 
                                <sf:errors path="description" cssClass="text-danger" element="div"/>
                            <!--</div>-->
                        </div> 
                        <div class="form-group">
                            <label for="systemFlag" class="form-check-label col-md-4">
                                <spring:message code="lookupType.table.system"/>:</label>
                            <!--<div class="form-check">-->
                                <sf:checkbox path="systemFlag" id="systemFlag" value="Y" />
                                <sf:errors path="systemFlag" cssClass="text-danger" element="div"/>                                
                            <!--</div>--> 
                        </div> 
                        <div class="form-group">
                            <label for="startDate" class="col-form-label col-md-4">
                                <spring:message code="common.field.startDate"/>:</label>
                            <!--<div class="col-md-4">-->
                                <sf:input path="startDate" id="startDate" type="date"/>
                                <sf:errors path="startDate" cssClass="text-danger" element="div" />
                            <!--</div>-->
                        </div>
                        <div class="form-group">								
                            <!--<div class="col-offset-4 col-md-8">-->                                   
                                <input type="submit" value="<spring:message code="lookupType.table.btn.addLookupType"/>" class="btn btn-primary">
                            <!--</div>-->
                        </div>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
