 <div class="row">
    <div class="modal fade" id="myLocationModal" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <!--Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title"><spring:message code="person.modal.location.title"/></h4>
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>						
                    </button>                    
                </div>
                
                    <sf:form 
                        id="locationForm"
                        modelAttribute="location" 
                        action="${contextRoot}/manage/location" 
                        method="POST"
                        class="form-horizonal">
                        
                        <!--Modal Body -->
                        <div class="modal-body">   
                            
                        <!--<div class="form-row">-->
                            <div class="form-group">
                                <label for="address1" class="col-form-label col-md-8">
                                    <spring:message code="location.table.address1"/></label>                                
                                <div class="col-md-8">
                                    <sf:hidden id="locationId" path="locationId"/>
                                    <input type="hidden" name="ownerTableId" id="ownerTableId" value="${person.personId}"/>
                                    <input type="hidden" name="ownerTableName" id="ownerTableName" value="PERSON"/>
                                    <sf:input path="address1" id="address1" type="text" class="form-control" required="true"/>
                                    <sf:errors path="address1" cssClass="text-danger" element="div" />   
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="state" class="col-form-label col-md-8">
                                    <spring:message code="location.table.state"/></label>
                                <div class="col-md-8">                               
                                    <sf:input path="state" id="state" type="text" class="form-control" required="true"/>
                                    <sf:errors path="state" cssClass="text-danger" element="div" />    
                                </div>
                            </div>
<!--                        </div>

                        <div class="form-row">-->
                            <div class="form-group">
                                <label for="country" class="col-form-label col-md-8">
                                    <spring:message code="location.table.country"/></label>  
                                <div class="col-md-8">
                                    <sf:input path="country" id="country" type="text" class="form-control" required="true"/>
                                    <sf:errors path="country" cssClass="text-danger" element="div" />   
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="postalCode" class="col-form-label col-md-8">
                                    <spring:message code="location.table.postalCode"/></label>       
                                <div class="col-md-8">
                                    <sf:input path="postalCode" id="postalCode" type="text" class="form-control" required="true"/>
                                    <sf:errors path="postalCode" cssClass="text-danger" element="div" />    
                                </div>
                            </div>
<!--                        </div>
                        
                      <div class="form-row">-->
                            
                            <div class="form-group">
                                <label for="startDate" class="col-form-label col-md-8">
                                    <spring:message code="common.field.startDate"/></label>
                                <div class="col-md-6">
                                    <sf:input path="startDate" id="startDate" type="date" class="form-control" required="true"/> 
                                    <sf:errors path="startDate" cssClass="text-danger" element="div" />
                                </div>
                            </div>  
                        
                        </div>
                        <!--Modal Footer-->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                <spring:message code="common.btn.close"/></button>
                            <button type="submit" class="btn btn-primary">
                                <spring:message code="person.table.btn.addLocation"/></button>                    
                        </div>
                                                          
                    </sf:form>   
                                
                </div>
        </div>
    </div>
</div>
                