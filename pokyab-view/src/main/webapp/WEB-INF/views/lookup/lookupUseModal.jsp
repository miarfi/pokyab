<!--LookupUse Modal Row-->    
<div class="row">
    <div class="modal fade" id="mylookupUseModal" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <!--Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title"><spring:message code="lookupUse.modal.title"/></h4>
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>						
                    </button>                    
                </div>
                <sf:form 
                    id="seasonForm"
                    modelAttribute="lookupUse" 
                    action="${contextRoot}/manage/lookupUse" 
                    method="POST"
                    class="form-group">
                    <!--Modal Body -->
                    <div class="modal-body">                    
                        <div class="form-group">
                            <label class="col-form-label col-md-8" for="tableName">
                                <spring:message code="lookupUse.table.tableName"/></label>
                            <div class="col-md-8">
                                <sf:hidden path="lookupTypeId" id="lookupTypeId"/>
                                <sf:hidden path="lookupUseId" id="lookupUseId"/>
                                <sf:select path="tableName" id="tableName" class="form-control" required="true">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${tables}" itemLabel="tableName" itemValue="tableName" />
                                </sf:select>
                                <sf:errors path="tableName" cssClass="text-danger" element="div" />  				
                            </div>                            
                        </div>                
                        <div class="form-group">
                            <label class="col-form-label col-md-8" for="columnName">
                                <spring:message code="lookupUse.table.columnName"/></label>
                            <div class="col-md-8">
                                <sf:select path="columnName" id="columnName" class="form-control" required="true">
                                    <sf:option value="" label="---"/>
                                    <!--<sf:options items="${tableColumns}" itemLabel="columnName" itemValue="columnName" />-->
                                </sf:select>
                                <sf:errors path="columnName" cssClass="text-danger" element="div" />  				
                            </div>                            
                        </div>                         
<!--                        <div class="form-group">
                            <label for="required" class="form-check-label col-md-8">
                                <spring:message code="lookupUse.table.required"/>:</label>
                            <div class="form-check">
                                <sf:checkbox path="required" id="required" value="Y" />
                                <sf:errors path="required" cssClass="text-danger" element="div"/>                                
                            </div> 
                        </div> -->
                        <div class="form-group">
                            <label for="startDate" class="col-form-label col-md-8">
                                <spring:message code="common.field.startDate"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="startDate" id="startDate" type="date" class="form-control" required="true"/> 
                            </div>
                        </div>                                            
                    </div>
                    <!--Modal Footer-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                            <spring:message code="common.btn.close"/></button>
                        <button type="submit" class="btn btn-primary">
                            <spring:message code="lookupType.table.btn.addLookupUse"/></button>                    
                    </div>
                </sf:form>
            </div>
        </div>
    </div>
</div>
