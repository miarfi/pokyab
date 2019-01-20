    <!--Breadcrumb row-->
    <div class="row">
        <div class="col-12 col-md-10 col-xl-8">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${contextRoot}/home">
                        <spring:message code="menu.navbar.home"/></a></li>
                    <li class="breadcrumb-item"><a href="${contextRoot}/manage/team/${teamPerson.teamId}">
                        <spring:message code="menu.navbar.team"/></a></li>
                    <li class="breadcrumb-item active" aria-current="page">${teamPerson.teamPersonId}</li>
                </ol>
            </nav>
        </div>
    </div>    
            
    <!--Team row-->
    <div class="row">
        <div class="col-12 col-md-10 col-xl-8">
            <div class="card">
                <div class="card-header">
                    <h5><spring:message code="teamPerson.manage.title"/></h5>
                </div>
                <div class="card-body">
                    
                    <sf:form
                        id="teamPersonForm"                            
                        modelAttribute="teamPerson" 
                        action="${contextRoot}/manage/teamPerson" 
                        method="POST"
                        class="form-horizonal">

                        <div class="form-row">
                            <div class="form-group col-sm-5 col-md-4">
                                <label class="col-form-label" for="personId">
                                    <spring:message code="teamPerson.table.personId"/></label>
                                <sf:hidden path="teamId" value="${team.teamId}"/>  
                                <sf:hidden path="teamPersonId" value="${team.teamPersonId}"/>  
                                <sf:select path="personId" id="personId" class="form-control" required="true" readOnly="true">
                                    <sf:option value="0" label="---"/>
                                    <sf:options items="${persons}" itemLabel="fullName" itemValue="personId" />
                                </sf:select>
                                <sf:errors path="personId" cssClass="text-danger" element="div" />                                			                       
                            </div>
                             <div class="form-group col-sm-5 col-md-4">
                                <label class="col-form-label" for="memberType">
                                    <spring:message code="teamPerson.table.memberType"/>
                                </label>
                                <sf:select path="memberType" id="memberType" class="form-control" required="true">                                    
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${memberTypes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>
                                <sf:errors path="memberType" cssClass="text-danger" element="div" />                               				                          
                            </div>  
                        </div> 
                        <div class="form-row">
                            <div class="form-group col-sm-5 col-md-4">
                                <label class="col-form-label" for="positionCode">
                                    <spring:message code="teamPerson.table.positionCode"/></label>
                                <sf:select path="positionCode" id="positionCode" class="form-control">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${positionCodes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>
                                <sf:errors path="positionCode" cssClass="text-danger" element="div" />                                			                       
                            </div>
                            <div class="form-group col-sm-5 col-md-4">
                                <label class="col-form-label" for="statusCode">
                                    <spring:message code="teamPerson.table.statusCode"/></label>
                                <sf:select path="statusCode" id="statusCode" class="form-control">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${tpStatusCodes}" itemLabel="meaning" itemValue="lookupCode" />
                                </sf:select>
                                <sf:errors path="statusCode" cssClass="text-danger" element="div" />                                			                       
                            </div>
                        </div> 
                        <div class="form-row">
                            <div class="form-group col-6 col-sm-3 col-md-2">
                                <label for="playerNumber" class="col-form-label">
                                    <spring:message code="teamPerson.table.playerNumber"/></label>
                                <sf:input path="playerNumber" id="playerNumber" type="number" class="form-control"/> 
                                <sf:errors path="playerNumber" cssClass="text-danger" element="div" />
                            </div>                            
                            <div class="form-group col-6 col-sm-3 col-md-2" >
                                <label for="height" class="col-form-label">
                                    <spring:message code="teamPerson.table.height"/></label>                                   
                                <sf:input id="height" path="height" type="number" class="form-control"/>
                                <sf:errors path="height" cssClass="text-danger" element="div" />    
                            </div> 
                            <div class="form-group col-6 col-sm-3 col-md-2">
                                <label for="weight" class="col-form-label">
                                    <spring:message code="teamPerson.table.weight"/></label> 
                                <sf:input id="weight" path="weight" type="number" class="form-control"/>
                                <sf:errors path="weight" cssClass="text-danger" element="div" />
                            </div>
<!--                        </div>
                        <div class="form-row">                             -->
                            <div class="form-group col-6 col-sm-4 col-md-3 col-lg-2">
                                <label for="startDate" class="col-form-label">
                                    <spring:message code="common.field.startDate"/></label>                                
                                <sf:input path="startDate" id="startDate" type="date" class="form-control" required="true"/> 
                                <sf:errors path="startDate" cssClass="text-danger" element="div" />
                            </div> 
                            <c:if test="${teamPerson.teamPersonId > 0 }">
                                <div class="form-group col-6 col-sm-4 col-md-3 col-lg-2">
                                    <label for="endDate" class="col-form-label">
                                        <spring:message code="common.field.endDate"/></label>
                                    <sf:input path="endDate" id="endDate" type="date" class="form-control"/>                                     
                                    <sf:errors path="endDate" cssClass="text-danger" element="div" />
                                </div>   
                            </c:if>                              
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