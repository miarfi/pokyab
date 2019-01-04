<!--<div class="container-fluid">-->
    
    <!--Breadcrumb row-->
    <div class="row">
        <div class="col-12 col-md-8">
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
    </div>    
            
    <!--Team row-->
    <div class="row">
        <div class="col-12 col-md-8">
            <div class="card">
                <div class="card-header">
                    <h5><spring:message code="season.manage.title"/></h5>
                </div>
                <div class="card-body">                    
                    
                    <sf:form 
                        id="seasonForm"
                        modelAttribute="season" 
                        action="${contextRoot}/manage/season" 
                        method="POST"
                        class="form-group">
                        <div class="form-group">
                            <label for="seasonName" class="col-form-label col-md-4">
                                <spring:message code="season.table.seasonName"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="seasonName" id="seasonName" type="text" class="form-control"/>
                                <sf:errors path="seasonName" cssClass="text-danger" element="div" />
                            </div>
                        </div>                                
                        <div class="form-group">
                            <label for="seasonCode" class="col-form-label col-md-4">
                                <spring:message code="season.table.seasonCode"/>:</label>
                            <div class="col-md-8">
                                <sf:input path="seasonCode" id="seasonCode" type="text" class="form-control"/>
                                <sf:errors path="seasonCode" cssClass="text-danger" element="div" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-form-label col-md-4">
                                <spring:message code="season.table.description"/>:</label>
                            <div class="col-md-8">
                                <sf:textarea path="description" id="description" class="form-control"/> 
                                <sf:errors path="description" cssClass="text-danger" element="div" />
                            </div>
                        </div>   
                        <div class="form-group">
                            <label for="startDate" class="col-form-label col-md-4">
                                <spring:message code="common.field.startDate"/>:</label>
                            <div class="col-md-4">
                                <sf:input path="startDate" id="startDate" type="date"/>
                                <sf:errors path="startDate" cssClass="text-danger" element="div" />
                            </div>
                        </div> 
                        <div class="form-group">
                            <label for="endDate" class="col-form-label col-md-4">
                                <spring:message code="common.field.endDate"/>:</label>
                            <div class="col-md-4">
                                <sf:input path="endDate" id="endDate" type="date"/>
                                <sf:errors path="endDate" cssClass="text-danger" element="div" />
                            </div>
                        </div>                            
                        <div class="form-group">								
                            <div class="col-offset-4 col-md-8">
                                <button type="submit" class="btn btn-primary">
                                    <spring:message code="team.table.btn.addSeason"/></button>                                
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>
        </div> 
    </div>

<!--</div>-->            