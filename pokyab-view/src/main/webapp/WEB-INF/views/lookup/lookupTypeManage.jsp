
<!--Breadcrumb row-->
<div class="row">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${contextRoot}/home">
                <spring:message code="menu.navbar.home"/></a></li>
            <li class="breadcrumb-item"><a href="${contextRoot}/lookupTypes">
                <spring:message code="menu.navbar.lookupTypes"/></a></li>
            <li class="breadcrumb-item active" aria-current="page">${lookupType.lookupType}</li>
        </ol>
    </nav>
</div>

<!--Lookup Type row-->
<div class="row">
    <a href="lookupTypeModal.jsp"></a>
    <div class="col-12 col-md-8">
        <div class="panel panel-primary">
            <div class="panel-heading">
                <h4><spring:message code="lookupType.manage.title"/></h4>
            </div>
            <div class="panel-body">                    
                <sf:form 
                    id="seasonForm"
                    modelAttribute="lookupType" 
                    action="${contextRoot}/manage/lookupType" 
                    method="POST"
                    class="form-group">
                    <div class="form-row">
                        <div class="form-group col-6 col-md-2">
                            <label for="lookupType" class="col-form-label">
                                <spring:message code="lookupType.table.lookupType"/>:</label>
                                <sf:input path="lookupTypeId" id="lookupTypeId"  type="hidden"/>
                                <sf:input path="lookupType" type="text" class="form-control"/>
                                <sf:errors path="lookupType" cssClass="text-danger" element="div"/>
                        </div>
                        <div class="form-group col-6 col-md-4">
                            <label for="description" class="col-form-label">
                                <spring:message code="lookupType.table.description"/>:</label>
                                <sf:input path="description" id="description" class="form-control"/> 
                                <sf:errors path="description" cssClass="text-danger" element="div"/>
                        </div> 
                    </div>
                    <div class="form-row">
                        <div class="form-group col-6 col-md-2">
                            <label for="startDate" class="col-form-label">
                                <spring:message code="common.field.startDate"/>:</label>
                            <div>
                                <sf:input path="startDate" id="startDate" type="date"/>
                                <sf:errors path="startDate" cssClass="text-danger" element="div" />
                            </div>
                        </div>
                        <div class="form-group col-6 col-md-2">
                            <label for="endDate" class="col-form-label">
                                <spring:message code="common.field.endDate"/>:</label>
                            <div>
                                <sf:input path="endDate" id="endDate" type="date"/>
                                <sf:errors path="endDate" cssClass="text-danger" element="div" />
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-check">
                            <sf:checkbox path="systemFlag" id="systemFlag" value="Y" cssClass="form-check-input" />                                                                                                                                           
                            <label for="systemFlag" class="form-check-label">
                                <spring:message code="lookupType.table.system"/></label>
                            <sf:errors path="systemFlag" cssClass="text-danger" element="div" />
                        </div>  
                    </div>
                    <div class="form-group">								
                        <!--<div class="col-offset-4 col-md-8">-->                                   
                            <input type="submit" value="<spring:message code="common.btn.save"/>" class="btn btn-primary">
                        <!--</div>-->
                    </div>
                </sf:form>

            </div>                
        </div>
    </div>
</div>


<c:if test="${lookupType.lookupTypeId > 0 }">
    <!--Button Row-->
    <div class="row">
        <div class="col-12 col-md-8">
            <div class="text-right">
                <br/>										
                <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#mylookupValueModal">
                    <spring:message code="lookupType.table.btn.addLookupValue"/>
                </button>
            </div>      
        </div>
    </div>

    <!--Lookup Types table row-->
    <%@include file="lookupValues.jsp" %>

    <!--Lookup Type modal row-->
    <%@include file="lookupValueModal.jsp" %>
</c:if>                                                                     