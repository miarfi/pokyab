
<div class="container">
    
    <!--Breadcrumb row-->
    <div class="row">            
<!--            Current Locale : ${pageContext.response.locale}            -->
            <hr/>
    </div>
 
    <!--Team row-->
    <div class="row">
        <div class="col-12 col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4><spring:message code="team.manage.title"/></h4>
                </div>
                <div class="panel-body">
                    
                    <sf:form
                        id="teamForm"                            
                        modelAttribute="team" 
                        action="${contextRoot}/manage/team" 
                        method="POST"
                        class="form-horizonal">

                        <div class="form-group">
                            <label class="control-label col-md-4" for="teamName">
                                <spring:message code="team.table.teamName"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="teamName" path="teamName" class="form-control"/> 
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="control-label col-md-4" for="groupNumber">
                                <spring:message code="team.table.groupNumber"/>
                            </label>
                            <div class="col-md-8">
                                <sf:input type="text" id="groupNumber" path="groupNumber" class="form-control"/> 
                            </div>
                        </div>                                              

                        <div class="form-group">
                            <label class="control-label col-md-4" for="leagueId">
                                <spring:message code="team.table.league"/>
                            </label>
                            <div class="col-md-8">
                                <sf:select path="leagueId" id="leagueId" items="${leagues}" itemLabel="leagueName" itemValue="leagueId" class="form-control"/>

                                <div class="text-right">
                                    <!--<br/>-->			                                                                   		
                                    <c:if test="${team.leagueId == 0 }">
                                        <div class="text-right">
                                            <br/>										
                                            <button type="button" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#myLeagueModal">
                                                <spring:message code="team.table.btn.addLeague"/>
                                            </button>
                                        </div>
                                    </c:if>	
                                </div>					
                            </div>	
                        </div>
                                        
                        <div class="form-group">
                            <label class="control-label col-md-4" for="seasonId">
                                <spring:message code="team.table.season"/>
                            </label>
                            <div class="col-md-8">
                                <sf:select path="seasonId" id="seasonId" items="${seasons}" itemLabel="seasonName" itemValue="seasonId" class="form-control"/>

                                <div class="text-right">
                                    <!--<br/>-->			                                		
                                    <c:if test="${team.seasonId == 0 }">
                                        <div class="text-right">
                                            <br/>										
                                            <button type="button" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#mySeasonModal">
                                                <spring:message code="team.table.btn.addSeason"/>
                                            </button>
                                        </div>
                                    </c:if>	
                                </div>					
                            </div>	
                        </div>                                        
                                        
                        <div class="form-group">
                            <label class="control-label col-md-4" for="trainerPerId">
                                <spring:message code="team.table.trainer"/>
                            </label>
                            <div class="col-md-8">
                                <sf:select path="trainerPerId" id="trainerPerId" items="${trainers}" itemLabel="firstName" itemValue="personId" class="form-control"/>

                                <div class="text-right">
                                    <!--<br/>-->			                                 	
                                    <c:if test="${team.teamId == 0 }">
                                        <div class="text-right">
                                            <br/>										
                                            <button type="button" class="btn btn-warning btn-xs" data-toggle="modal" data-target="#myTrainerModal">
                                                <spring:message code="team.table.btn.addTrainer"/>
                                            </button>
                                        </div>
                                    </c:if>	
                                </div>					
                            </div>	
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" name="submit" value="<spring:message code="common.btn.save"/>" class="btn btn-primary"/>
                            </div>
                        </div>                                        
                    </sf:form>                    
                </div>                
            </div>
        </div>
    </div>
    
    <!--League Modal Row-->    
    <div class="row">
        <div class="modal fade" id="myLeagueModal" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <!--Modal Header -->
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span>&times;</span>						
                        </button>
                        <h4 class="modal-title"><spring:message code="team.modal.league.title"/></h4>
                    </div>
                    <!--Modal Body -->
                    <div class="modal-body">
                        <sf:form 
                            id="leagueForm"
                            modelAttribute="league" 
                            action="${contextRoot}/manage/league" 
                            method="POST"
                            class="form-group">
                            <div class="form-group">
                                <label for="leagueName" class="control-label col-md-4"><spring:message code="team.modal.league.leagueName"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="leagueName" id="leagueName" type="text" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="leagueType" class="control-label col-md-4"><spring:message code="team.modal.league.leagueType"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="leagueType" id="leagueType" type="text" class="form-control"/>
                                </div>
                            </div>                              
                            <div class="form-group">
                                <label for="categoryCode" class="control-label col-md-4"><spring:message code="team.modal.league.leagueType"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="categoryCode" id="categoryCode" type="text" class="form-control"/>
                                </div>
                            </div>                               
                            <div class="form-group">
                                <label for="countryCode " class="control-label col-md-4"><spring:message code="team.modal.league.country"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="countryCode" id="countryCode " type="text" class="form-control"/>
                                </div>
                            </div>                                   
                            <div class="form-group">								
                                <div class="col-offset-4 col-md-8">
                                    <input type="submit" value="<spring:message code="team.table.btn.addLeague"/>" class="btn btn-primary">
                                </div>
                            </div>
                        </sf:form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    
    <!--Season Modal Row-->    
    <div class="row">
        <div class="modal fade" id="mySeasonModal" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <!--Modal Header -->
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span>&times;</span>						
                        </button>
                        <h4 class="modal-title"><spring:message code="team.modal.seasson.title"/></h4>
                    </div>
                    <!--Modal Body -->
                    <div class="modal-body">
                        <sf:form 
                            id="seasonForm"
                            modelAttribute="season" 
                            action="${contextRoot}/manage/season" 
                            method="POST"
                            class="form-group">

                            <div class="form-group">
                                <label for="seasonName" class="control-label col-md-4"><spring:message code="team.modal.seasson.seasonName"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="seasonName" id="seasonName" type="text" class="form-control"/>
                                </div>
                            </div>
                                
                            <div class="form-group">
                                <label for="seasonCode" class="control-label col-md-4"><spring:message code="team.modal.seasson.seasonCode"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="seasonCode" id="seasonCode" type="text" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="description" class="control-label col-md-4"><spring:message code="team.modal.seasson.description"/>:</label>
                                <div class="col-md-8">
                                    <sf:textarea id="description" path="description" class="form-control"/> 
                                </div>
                            </div>                              
                                
                            <div class="form-group">								
                                <div class="col-offset-4 col-md-8">                                   
                                    <input type="submit" value="<spring:message code="team.table.btn.addSeason"/>" class="btn btn-primary">
                                </div>
                            </div>
                        </sf:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
     
     
    <!--Trainer Modal row-->
    <div class="row">
        <div class="modal fade" id="myTrainerModal" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <!--Modal Header -->
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span>&times;</span>						
                        </button>
                        <h4 class="modal-title"><spring:message code="team.modal.trainer.title"/></h4>
                    </div>
                    <!--Modal Body -->
                    <div class="modal-body">
                        <sf:form 
                            id="personForm"
                            modelAttribute="person" 
                            action="${contextRoot}/manage/person" 
                            method="POST"
                            class="form-group">

                            <div class="form-group">
                                <label for="firstName" class="control-label col-md-4"><spring:message code="person.table.firstName"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="firstName" id="firstName" type="text" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="lastName" class="control-label col-md-4"><spring:message code="person.table.lastName"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="lastName" id="lastName" type="text" class="form-control"/>
                                </div>
                            </div>  
                            
                            <div class="form-group">
                                <label for="genderCode" class="control-label col-md-4"><spring:message code="person.table.genderCode"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="genderCode" id="genderCode" type="text" class="form-control"/>
                                </div>
                            </div>   
                              
                            <div class="form-group">								
                                <div class="col-offset-4 col-md-8">
                                    <sf:hidden path="maritalStatusCode" value="SINGLE"/>
                                    <input type="submit" value="<spring:message code="team.table.btn.addTrainer"/>" class="btn btn-primary">
                                </div>
                            </div>
                        </sf:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</div>