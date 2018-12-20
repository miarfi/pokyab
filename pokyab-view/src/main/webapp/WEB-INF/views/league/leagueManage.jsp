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
    </div>    
            
    <!--Team row-->
    <div class="row">
        <div class="col-12 col-md-8">
            <div class="card">
                <div class="card-header">
                    <h5><spring:message code="league.manage.title"/></h5>
                </div>
                <div class="card-body">                    
                    <sf:form 
                        id="leagueForm"
                        modelAttribute="league" 
                        action="${contextRoot}/manage/league" 
                        method="POST"
                        class="form-group">
                        <div class="form-group">
                            <label for="leagueName" class="col-form-label col-md-4">
                                <spring:message code="league.table.leagueName"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="leagueName" id="leagueName" type="text" class="form-control"/>
                                <sf:errors path="leagueName" cssClass="text-danger" element="div" />
                            </div>
                            
                        </div>
                        <div class="form-group">
                            <label for="leagueType" class="col-form-label col-md-4">
                                <spring:message code="league.table.leagueType"/>:</label>
                            <div class="col-md-8">
<!--                                    <sf:input path="leagueType" id="leagueType" type="text" class="form-control"/>-->
                                <sf:select path="leagueType" id="leagueType" class="form-control">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${leagueTypes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>       
                                <sf:errors path="leagueType" cssClass="text-danger" element="div" />
                            </div>
                            
                        </div>                              
                        <div class="form-group">
                            <label for="categoryCode" class="col-form-label col-md-4">                               
                                <spring:message code="league.table.category"/>:</label>
                            <div class="col-md-8">
                                <!--<sf:input path="categoryCode" id="categoryCode" type="text" class="form-control"/>-->
                                 <sf:select path="categoryCode" id="categoryCode" class="form-control">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${teamCategoryCodes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>
                                <sf:errors path="categoryCode" cssClass="text-danger" element="div" />
                            </div>
                            
                        </div>                               

                        <div class="form-group">								
                            <div class="col-offset-4 col-md-8">
                                <button type="submit" class="btn btn-primary">
                                    <spring:message code="team.table.btn.addLeague"/></button>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>
        </div> 
    </div>

</div>                                