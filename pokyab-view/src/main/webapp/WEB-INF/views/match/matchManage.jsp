
<!--<div class="container-fluid">-->
    
    <!--Breadcrumb row-->
    <div class="row">
        <div class="col-12 col-md-10 col-xl-8">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${contextRoot}/home">
                        <spring:message code="menu.navbar.home"/></a></li>
                    <li class="breadcrumb-item"><a href="${contextRoot}/matchs">
                        <spring:message code="menu.navbar.matchs"/></a></li>
                    <li class="breadcrumb-item active" aria-current="page">${match.matchId}</li>
                </ol>
            </nav>
        </div>
    </div>    
            
    <!--Team row-->
    <div class="row">
        <div class="col-12 col-md-10 col-xl-8">
            <div class="card">
                <div class="card-header">
                    <h5><spring:message code="match.manage.title"/></h5>
                </div>
                <div class="card-body">
                    
                    <sf:form
                        id="matchForm"                            
                        modelAttribute="match" 
                        action="${contextRoot}/manage/match" 
                        method="POST"
                        class="form-horizonal">

                        <div class="form-row"> 
                            <div class="form-group col-sm-5 col-md-4">
                                <label class="col-form-label" for="homeTeamId">
                                    <spring:message code="match.table.homeTeamName"/>
                                </label>
                                <sf:select path="homeTeamId" id="homeTeamId" class="form-control">
                                    <sf:option value="0" label="---"/>
                                    <sf:options items="${teams}" itemLabel="teamName" itemValue="teamId" />
                                </sf:select>
                                <sf:errors path="homeTeamId" cssClass="text-danger" element="div" />                                					                                                      
                            </div>
                            <div class="form-group col-sm-5 col-md-4">
                                <label class="col-form-label" for="awayTeamId">
                                    <spring:message code="match.table.awayTeamName"/>
                                </label>
                                <sf:select path="awayTeamId" id="awayTeamId" class="form-control">
                                    <sf:option value="0" label="---"/>
                                    <sf:options items="${teams}" itemLabel="teamName" itemValue="teamId" />
                                </sf:select>
                                <sf:errors path="awayTeamId" cssClass="text-danger" element="div" />                                					                                                      
                            </div>                            
                        </div> 
                        <div class="form-row">
                            <div class="form-group col-sm-5 col-md-4">
                                <label class="col-form-label" for="leagueId">
                                    <spring:message code="match.table.leagueName"/></label>
                                <sf:select path="leagueId" id="leagueId" class="form-control" required="true">
                                    <sf:option value="0" label="---"/>
                                    <sf:options items="${leagues}" itemLabel="leagueName" itemValue="leagueId" />
                                </sf:select>
                                <sf:errors path="leagueId" cssClass="text-danger" element="div" />                                			                       
                            </div>
                       
                            <div class="form-group col-sm-5 col-md-4">
                                <label class="col-form-label" for="seasonId">
                                    <spring:message code="match.table.seasonName"/>
                                </label>
                                <sf:select path="seasonId" id="seasonId" class="form-control" required="true">                                    
                                    <sf:option value="0" label="---"/>
                                    <sf:options items="${seasons}" itemLabel="seasonName" itemValue="seasonId" />
                                </sf:select>
                                <sf:errors path="seasonId" cssClass="text-danger" element="div" />                                				                          
                            </div>                                                                        
                        </div>
                        <div class="form-row">
                            <div class="form-group col-sm-5 col-md-4">
                                <label for="status" class="col-form-label">
                                    <spring:message code="common.btn.status"/></label>                                                               
                                <sf:select path="status" id="status" class="form-control" required="true">
                                    <sf:option value="PLANNED" label="---"/>
                                    <sf:options items="${matchStatus}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>                                
                                <sf:errors path="status" cssClass="text-danger" element="div" />                                
                            </div>  
                            <div class="form-group col-6 col-sm-4 col-md-3 col-lg-3">
                                <label for="matchDate" class="col-form-label">
                                    <spring:message code="common.field.date"/></label>
                                <div>
                                    <sf:input path="matchDate" id="matchDate" type="date" class="form-control" required="true"/> 
                                </div>
                                <sf:errors path="matchDate" cssClass="text-danger" element="div" />
                            </div> 
                            <div class="form-group col-6 col-sm-4 col-md-3 col-lg-3">
                                <label for="matchTime" class="col-form-label">
                                    <spring:message code="common.field.time"/></label>
                                <div>
                                    <sf:input path="matchTime" id="matchTime" type="time" class="form-control" required="true"/> 
                                </div>
                                <sf:errors path="matchTime" cssClass="text-danger" element="div" />
                            </div> 
                        </div>
                        <div class="form-row">
                            <div class="form-group col-sm-5 col-md-4">
                                <label for="matchLocation" class="col-form-label">
                                    <spring:message code="common.field.location"/></label>                                                               
                                <div>
                                    <sf:input path="matchLocation" id="matchLocation" type="text" class="form-control" required="true"/> 
                                </div>                              
                                <sf:errors path="matchLocation" cssClass="text-danger" element="div" />                                
                            </div>  
                            <div class="form-group col-6 col-sm-4 col-md-3 col-lg-2">
                                <label for="homeScore" class="col-form-label">
                                    <spring:message code="match.table.homeScore"/></label>
                                <div>
                                    <sf:input path="homeScore" id="homeScore" type="number" class="form-control" required="true"/> 
                                </div>
                                <sf:errors path="homeScore" cssClass="text-danger" element="div" />
                            </div> 
                            <div class="form-group col-6 col-sm-4 col-md-3 col-lg-2">
                                <label for="awayScore" class="col-form-label">
                                    <spring:message code="match.table.awayScore"/></label>
                                <div>
                                    <sf:input path="awayScore" id="awayScore" type="number" class="form-control" required="true"/> 
                                </div>
                                <sf:errors path="awayScore" cssClass="text-danger" element="div" />
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
    
    
<!--</div>-->