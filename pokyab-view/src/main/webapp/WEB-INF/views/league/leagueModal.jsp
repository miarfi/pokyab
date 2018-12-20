 <div class="row">
        <div class="modal fade" id="myLeagueModal" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <!--Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title"><spring:message code="league.table.title"/></h4>
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>						
                        </button>                        
                    </div>
                    <sf:form 
                        id="leagueForm"
                        modelAttribute="league" 
                        action="${contextRoot}/manage/league" 
                        method="POST"
                        class="form-group">
                        <!--Modal Body -->
                        <div class="modal-body">                        
                            <div class="form-group">
                                <label for="leagueName" class="col-form-label col-md-4">
                                    <spring:message code="league.table.leagueName"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="leagueName" id="leagueName" type="text" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="leagueType" class="col-form-label col-md-4">
                                    <spring:message code="league.table.leagueType"/>:</label>
                                <div class="col-md-8">
                                    <sf:select path="leagueType" id="leagueType" class="form-control">
                                        <sf:option value="" label="---"/>
                                        <sf:options items="${leagueTypes}" itemLabel="meaning" itemValue="lookupCode" />
                                    </sf:select>                                    
                                </div>
                            </div>                              
                            <div class="form-group">
                                <label for="categoryCode" class="col-form-label col-md-4">                               
                                    <spring:message code="league.table.category"/>:</label>
                                <div class="col-md-8">                                    
                                     <sf:select path="categoryCode" id="categoryCode" class="form-control">
                                        <sf:option value="" label="---"/>
                                        <sf:options items="${teamCategoryCodes}" itemLabel="meaning" itemValue="lookupCode" />
                                    </sf:select>
                                </div>
                            </div>                               
    <!--                            <div class="form-group">
                                <label for="countryCode " class="col-form-label col-md-4">
                                    <spring:message code="league.table.country"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="countryCode" id="countryCode " type="text" class="form-control"/>
                                </div>
                            </div>                                   -->                         
                        </div>
                        <!--Modal Footer-->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                <spring:message code="common.btn.close"/></button>
                            <button type="submit" class="btn btn-primary">
                                <spring:message code="team.table.btn.addLeague"/></button>                    
                        </div>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>