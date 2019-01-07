 <div class="row">
    <div class="modal fade" id="myTrainerModal" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <!--Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title"><spring:message code="teamPerson.modal.title"/></h4>
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span>						
                    </button>                    
                </div>
                <sf:form 
                    id="teamPersonForm"
                    modelAttribute="teamPerson" 
                    action="${contextRoot}/manage/teamPerson" 
                    method="POST"
                    class="form-group">
                    <!--Modal Body -->
                    <div class="modal-body">                   
                          
                        <div class="form-group">
                            <label for="teamPersonId" class="col-form-label col-md-8">
                                <spring:message code="teamPerson.table.teamPersonId"/>:</label>
                            <div class="col-md-8">                               
                                <sf:select path="teamPersonId" id="teamPersonId" class="form-control">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${persons}" itemLabel="fullName" itemValue="personId" />
                                </sf:select>                                            
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="memberType" class="col-form-label col-md-8">
                                <spring:message code="teamPerson.table.memberType"/>:</label>
                            <div class="col-md-8">                               
                                <sf:select path="memberType" id="memberType" class="form-control">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${memberTypes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>                                                  
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="positionCode" class="col-form-label col-md-8">
                                <spring:message code="teamPerson.table.positionCode"/>:</label>
                            <div class="col-md-8">                               
                                <sf:select path="positionCode" id="positionCode" class="form-control">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${positionCodes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>                                                  
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="height" class="col-form-label col-md-8">
                                <spring:message code="teamPerson.table.height"/>:</label>
                            <div class="col-md-8">
                                <sf:input id="height" path="height" type="number"/>
                            </div>
                        </div> 
                        <div class="form-group">
                            <label for="weight" class="col-form-label col-md-8">
                                <spring:message code="teamPerson.table.weight"/>:</label>
                            <div class="col-md-8">
                                <sf:input id="weight" path="weight" type="number"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="playerNumber" class="col-form-label col-md-8">
                                <spring:message code="teamPerson.table.playerNumber"/>:</label>
                            <div class="col-md-8">
                                <sf:input id="playerNumber" path="playerNumber" type="number"/>
                            </div>
                        </div>
                    </div>
                    <!--Modal Footer-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">
                            <spring:message code="common.btn.close"/></button>
                        <button type="submit" class="btn btn-primary">
                            <spring:message code="teamPerson.table.btn.addPerson"/></button>                    
                    </div>
                </sf:form>
            </div>
        </div>
    </div>
</div>
