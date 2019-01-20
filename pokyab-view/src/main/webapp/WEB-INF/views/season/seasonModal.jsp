 <div class="row">
        <div class="modal fade" id="mySeasonModal" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <!--Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title"><spring:message code="season.table.title"/></h4>
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>						
                        </button>                        
                    </div>
                    <sf:form 
                        id="seasonForm"
                        modelAttribute="season" 
                        action="${contextRoot}/manage/season" 
                        method="POST"
                        class="form-group">
                        <!--Modal Body -->
                        <div class="modal-body">                        
                            <div class="form-group">
                                <label for="seasonName" class="col-form-label col-md-8">
                                    <spring:message code="season.table.seasonName"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="seasonName" id="seasonName" type="text" class="form-control" required="true"/>
                                </div>
                            </div>                                
                            <div class="form-group">
                                <label for="seasonCode" class="col-form-label col-md-8">
                                    <spring:message code="season.table.seasonCode"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="seasonCode" id="seasonCode" type="text" class="form-control" required="true"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="description" class="col-form-label col-md-8">
                                    <spring:message code="season.table.description"/>:</label>
                                <div class="col-md-8">
                                    <sf:textarea path="description" id="description" class="form-control"/> 
                                </div>
                            </div>   
                            <div class="form-row">
                                <div class="form-group col-6 col-md-5">
                                    <label for="startDate" class="col-form-label col-12">
                                        <spring:message code="common.field.startDate"/>:</label>
                                    <div class="col-12">
                                        <sf:input path="startDate" id="startDate" type="date" class="form-control" required="true"/> 
                                    </div>
                                </div> 
                                <div class="form-group col-6 col-md-5">
                                    <label for="endDate" class="col-form-label col-12">
                                        <spring:message code="common.field.endDate"/>:</label>
                                    <div class="col-12">
                                        <sf:input path="endDate" id="endDate" type="date" class="form-control" required="true"/> 
                                    </div>
                                </div>  
                            </div>
                        </div>
                        <!--Modal Footer-->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                <spring:message code="common.btn.close"/></button>
                            <button type="submit" class="btn btn-primary">
                                <spring:message code="team.table.btn.addSeason"/></button>                    
                        </div>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>