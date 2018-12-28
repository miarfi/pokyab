 <div class="row">
    <div class="modal fade" id="myTrainerModal" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <!--Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title"><spring:message code="team.modal.trainer.title"/></h4>
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>						
                    </button>                    
                </div>
                <sf:form 
                    id="personForm"
                    modelAttribute="person" 
                    action="${contextRoot}/manage/person" 
                    method="POST"
                    class="form-group">
                    <!--Modal Body -->
                    <div class="modal-body">                   
                        <div class="form-group">
                            <label for="firstName" class="col-form-label col-md-8">
                                <spring:message code="person.table.firstName"/>:</label>
                            <div class="col-md-8">
                                <sf:hidden path="personType" value="TRAINER"/>
                                <sf:input path="firstName" id="firstName" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastName" class="col-form-label col-md-8">
                                <spring:message code="person.table.lastName"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="lastName" id="lastName" type="text" class="form-control"/>
                            </div>
                        </div>   
                        <div class="form-group">
                            <label for="genderCode" class="col-form-label col-md-8">
                                <spring:message code="person.table.genderCode"/>:</label>
                            <div class="col-md-8">                               
                                <sf:select path="genderCode" id="genderCode" class="form-control">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${genderCodes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>                                
                                <sf:errors path="genderCode" cssClass="text-danger" element="div" />
                            </div>
                        </div> 
                        <div class="form-group">
                            <label for="dateOfBirth" class="col-form-label col-md-8">
                                <spring:message code="person.table.dateOfBirth"/>:</label>
                            <div class="col-md-8">
                                <sf:input id="dateOfBirth" path="dateOfBirth" type="date"/>
                            </div>
                        </div>                                                                                
                    </div>
                    <!--Modal Footer-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                            <spring:message code="common.btn.close"/></button>
                        <button type="submit" class="btn btn-primary">
                            <spring:message code="team.table.btn.addTrainer"/></button>                    
                    </div>
                </sf:form>
            </div>
        </div>
    </div>
</div>