
<div class="container">
    
    <!--Breadcrumb row-->
    <div class="row">            
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="${contextRoot}/home">
                    <spring:message code="menu.navbar.home"/></a></li>
                <li class="breadcrumb-item"><a href="${contextRoot}/teams">
                    <spring:message code="menu.navbar.teams"/></a></li>
                <li class="breadcrumb-item active" aria-current="page">${team.teamName}</li>
            </ol>
        </nav>
<!--        Current Locale : ${pageContext.response.locale}            
        <hr/>-->
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
                            <label for="teamName" class="col-form-label col-md-4">
                                <spring:message code="team.table.teamName"/></label>
                            <div class="col-md-8">
                                <sf:input path="teamId" id="teamId" type="hidden"/>
                                <sf:input path="teamName" id="teamName" type="text" class="form-control"/>
                                <sf:errors path="teamName" cssClass="text-danger" element="div" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="groupNumber" class="col-form-label col-md-4">
                                <spring:message code="team.table.groupNumber"/></label>
                            <div class="col-md-8">
                                <sf:input path="groupNumber" id="groupNumber" type="number" class="form-control"/> 
                                <sf:errors path="groupNumber" cssClass="text-danger" element="div" />
                            </div>
                        </div>                                              
                        <div class="form-group">
                            <label class="col-form-label col-md-4" for="leagueId">
                                <spring:message code="team.table.league"/></label>
                            <div class="col-md-8">
                                <sf:select path="leagueId" id="leagueId" class="form-control">
                                    <sf:option value="0" label="---"/>
                                    <sf:options items="${leagues}" itemLabel="leagueName" itemValue="leagueId" />
                                </sf:select>
                                <sf:errors path="leagueId" cssClass="text-danger" element="div" />
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
                            <label class="col-form-label col-md-4" for="seasonId">
                                <spring:message code="team.table.season"/>
                            </label>
                            <div class="col-md-8">
                                <sf:select path="seasonId" id="seasonId" class="form-control">                                    
                                    <sf:option value="0" label="---"/>
                                    <sf:options items="${seasons}" itemLabel="seasonName" itemValue="seasonId" />
                                </sf:select>
                                <sf:errors path="seasonId" cssClass="text-danger" element="div" />
                                <div class="text-right">                			                                		
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
                            <label class="col-form-label col-md-4" for="trainerPerId">
                                <spring:message code="team.table.trainer"/>
                            </label>
                            <div class="col-md-8">
                                <sf:select path="trainerPerId" id="trainerPerId" class="form-control">
                                    <sf:option value="0" label="---"/>
                                    <sf:options items="${trainers}" itemLabel="firstName" itemValue="personId" />
                                </sf:select>
                                <sf:errors path="trainerPerId" cssClass="text-danger" element="div" />
                                <div class="text-right">                                  			                                 	
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
                            <label for="startDate" class="col-form-label col-md-4">
                                <spring:message code="common.field.startDate"/>:</label>
                            <div class="col-md-4">
                                <sf:input path="startDate" id="startDate" type="date"/>
                            </div>
                            <sf:errors path="startDate" cssClass="text-danger" element="div" />
                        </div> 
                        <c:if test="${team.teamId > 0 }">
                            <div class="form-group">
                                <label for="endDate" class="col-form-label col-md-4">
                                    <spring:message code="common.field.endDate"/>:</label>
                                <div class="col-md-4">
                                    <sf:input path="endDate" id="endDate" type="date"/>
                                </div>
                                <sf:errors path="endDate" cssClass="text-danger" element="div" />
                            </div>   
                        </c:if>
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
                                <label for="leagueName" class="col-form-label col-md-4">
                                    <spring:message code="team.modal.league.leagueName"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="leagueName" id="leagueName" type="text" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="leagueType" class="col-form-label col-md-4">
                                    <spring:message code="team.modal.league.leagueType"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="leagueType" id="leagueType" type="text" class="form-control"/>
                                </div>
                            </div>                              
                            <div class="form-group">
                                <label for="categoryCode" class="col-form-label col-md-4">
                                    <spring:message code="team.modal.league.category"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="categoryCode" id="categoryCode" type="text" class="form-control"/>
                                </div>
                            </div>                               
<!--                            <div class="form-group">
                                <label for="countryCode " class="col-form-label col-md-4">
                                    <spring:message code="team.modal.league.country"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="countryCode" id="countryCode " type="text" class="form-control"/>
                                </div>
                            </div>                                   -->
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
                                <label for="seasonName" class="col-form-label col-md-4">
                                    <spring:message code="team.modal.seasson.seasonName"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="seasonName" id="seasonName" type="text" class="form-control"/>
                                </div>
                            </div>                                
                            <div class="form-group">
                                <label for="seasonCode" class="col-form-label col-md-4">
                                    <spring:message code="team.modal.seasson.seasonCode"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="seasonCode" id="seasonCode" type="text" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="description" class="col-form-label col-md-4">
                                    <spring:message code="team.modal.seasson.description"/>:</label>
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
                            <div class="form-group">
                                <label for="endDate" class="col-form-label col-md-4">
                                    <spring:message code="common.field.endDate"/>:</label>
                                <div class="col-md-4">
                                    <sf:input path="endDate" id="endDate" type="date"/>
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
                                <label for="firstName" class="col-form-label col-md-4">
                                    <spring:message code="person.table.firstName"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="firstName" id="firstName" type="text" class="form-control"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastName" class="col-form-label col-md-4">
                                    <spring:message code="person.table.lastName"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="lastName" id="lastName" type="text" class="form-control"/>
                                </div>
                            </div>    
                            <div class="form-group">
                                <label for="dateOfBirth" class="col-form-label col-md-4">
                                    <spring:message code="person.table.dateOfBirth"/>:</label>
                                <div class="col-md-4">
                                    <sf:input id="dateOfBirth" path="dateOfBirth" type="date"/>
                                </div>
                            </div>                             
                            <div class="form-group">
                                <label for="genderCode" class="col-form-label col-md-4">
                                    <spring:message code="person.table.genderCode"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="genderCode" id="genderCode" type="text" class="form-control"/>
                                </div>
                            </div>                                                     
                            <div class="form-group">								
                                <div class="col-offset-4 col-md-8">                                    
                                    <sf:hidden path="personType" value="TRAINER"/>
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