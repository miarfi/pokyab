
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
        <div class="col-12 col-lg-8">
            <div class="card">
                <div class="card-header">
                    <h5><spring:message code="team.manage.title"/></h5>
                </div>
                <div class="card-body">
                    
                    <sf:form
                        id="teamForm"                            
                        modelAttribute="team" 
                        action="${contextRoot}/manage/team" 
                        method="POST"
                        class="form-horizonal">

                        <div class="form-row ">
                            <div class="form-group col-sm-6 col-md-5">
                                <label for="teamName" class="col-form-label">
                                    <spring:message code="team.table.teamName"/></label>
                                <sf:input path="teamId" id="teamId" type="hidden"/>
                                <sf:input path="teamName" id="teamName" type="text" class="form-control"/>
                                <sf:errors path="teamName" cssClass="text-danger" element="div" />
                            </div>                                                                     
                            <div class="form-group col-sm-6 col-md-5">
                                <label class="col-form-label" for="leagueId">
                                    <spring:message code="team.table.league"/></label>
                                <sf:select path="leagueId" id="leagueId" class="form-control">
                                    <sf:option value="0" label="---"/>
                                    <sf:options items="${leagues}" itemLabel="leagueName" itemValue="leagueId" />
                                </sf:select>
                                <sf:errors path="leagueId" cssClass="text-danger" element="div" />
                                <div class="text-right">                                			                                                                   		
                                    <c:if test="${team.leagueId == 0 }">
                                        <div class="text-right">
                                            <!--<br/>-->										
                                            <button type="button" class="btn btn-warning btn-sm" data-toggle="modal" data-target="#myLeagueModal">
                                                <spring:message code="team.table.btn.addLeague"/>
                                            </button>
                                        </div>
                                    </c:if>	
                                </div>				                       
                            </div>
                        </div> 
                        <div class="form-row">
                            <div class="form-group col-sm-6 col-md-5">
                                <label class="col-form-label" for="seasonId">
                                    <spring:message code="team.table.season"/>
                                </label>
                                <sf:select path="seasonId" id="seasonId" class="form-control">                                    
                                    <sf:option value="0" label="---"/>
                                    <sf:options items="${seasons}" itemLabel="seasonName" itemValue="seasonId" />
                                </sf:select>
                                <sf:errors path="seasonId" cssClass="text-danger" element="div" />
                                <div class="text-right">                			                                		
                                    <c:if test="${team.seasonId == 0 }">
                                        <div class="text-right">
                                            <!--<br/>-->										
                                            <button type="button" class="btn btn-warning btn-sm" data-toggle="modal" data-target="#mySeasonModal">
                                                <spring:message code="team.table.btn.addSeason"/>
                                            </button>
                                        </div>
                                    </c:if>	
                                </div>					                          
                            </div>                                        

                            <div class="form-group col-sm-6 col-md-5">
                                <label class="col-form-label" for="trainerPerId">
                                    <spring:message code="team.table.trainer"/>
                                </label>
                                <sf:select path="trainerPerId" id="trainerPerId" class="form-control">
                                    <sf:option value="0" label="---"/>
                                    <sf:options items="${trainers}" itemLabel="firstName" itemValue="personId" />
                                </sf:select>
                                <sf:errors path="trainerPerId" cssClass="text-danger" element="div" />
                                <div class="text-right">                                  			                                 	
                                    <c:if test="${team.trainerPerId == 0 }">
                                        <div class="text-right">
<!--                                            <br/>										-->
                                            <button type="button" class="btn btn-warning btn-sm" data-toggle="modal" data-target="#myTrainerModal">
                                                <spring:message code="team.table.btn.addTrainer"/>
                                            </button>
                                        </div>
                                    </c:if>	
                                </div>					                                                      
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-5 col-sm-4 col-md-3">
                                <label for="startDate" class="col-form-label">
                                    <spring:message code="common.field.startDate"/></label>
                                <div>
                                    <sf:input path="startDate" id="startDate" type="date"/>
                                </div>
                                <sf:errors path="startDate" cssClass="text-danger" element="div" />
                            </div> 
                            <c:if test="${team.teamId > 0 }">
                                <div class="form-group col-5 col-sm-4 col-md-3">
                                    <label for="endDate" class="col-form-label">
                                        <spring:message code="common.field.endDate"/></label>
                                    <div>
                                        <sf:input path="endDate" id="endDate" type="date"/>
                                    </div>
                                    <sf:errors path="endDate" cssClass="text-danger" element="div" />
                                </div>   
                            </c:if>  
                            <div class="form-group col-2 col-sm-2 col-md-2">
                                <label for="groupNumber" class="col-form-label">
                                    <spring:message code="team.table.groupNumber"/></label>
                                <sf:input path="groupNumber" id="groupNumber" type="number" class="form-control"/> 
                                <sf:errors path="groupNumber" cssClass="text-danger" element="div" />
                            </div> 
                        </div>

                        <div class="form-group">                                                            
                            <button type="submit" class="btn btn-primary">
                                    <spring:message code="common.btn.save"/></button>
                        </div>   

                    </sf:form>                    
                </div>                
            </div>
        </div>
    </div>
    
    <!--League Modal Row-->    
    <%@include file="../league/leagueModal.jsp" %>

    
    <!--Season Modal Row-->    
    <%@include file="../season/seasonModal.jsp" %>
     
     
    <!--Trainer Modal row-->
    <%@include file="trainerModal.jsp" %>
    
</div>