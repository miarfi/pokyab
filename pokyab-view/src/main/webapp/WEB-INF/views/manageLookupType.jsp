
<div class="container">
    
    <!--Breadcrumb row-->
    <div class="row">

    </div>
 
    <!--Lookup Type row-->
    <div class="row">
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
                        <div class="form-group">
                            <label for="lookupType" class="control-label col-md-4"><spring:message code="lookupType.table.lookupType"/>:</label>
                            <div class="col-md-8">
                                <sf:input id="lookupTypeId" path="lookupTypeId" type="hidden"/>
                                <sf:input path="lookupType" id="lookupType" type="text" class="form-control"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="control-label col-md-4"><spring:message code="lookupType.table.description"/>:</label>
                            <div class="col-md-8">
                                <sf:textarea id="description" path="description" class="form-control"/> 
                            </div>
                        </div> 
                        <div class="form-group">
                            <label for="systemFlag" class="form-check-label col-md-4"><spring:message code="lookupType.table.system"/>:</label>
                            <div class="form-check">
                                <sf:checkbox id="systemFlag" path="systemFlag" value="Y" />                                                                                     
                            </div> 
                        </div>                         
                        <div class="form-group">
                            <label for="startDate" class="control-label col-md-4"><spring:message code="common.field.startDate"/>:</label>
                            <div class="col-md-4">
                                <sf:input id="startDate" path="startDate" type="date"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="endDate" class="control-label col-md-4"><spring:message code="common.field.endDate"/>:</label>
                            <div class="col-md-4">
                                <sf:input id="endDate" path="endDate" type="date"/>
                            </div>
                        </div>
                        <div class="form-group">								
                            <div class="col-offset-4 col-md-8">                                   
                                <input type="submit" value="<spring:message code="lookupType.table.btn.addLookupType"/>" class="btn btn-primary">
                            </div>
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

        <!--Training activity table row-->
        <%@include file="lookupValues.jsp" %>

        <!--Training activity modal row-->
        <%@include file="lookupValueModal.jsp" %>
    </c:if>
                        
                        
</div>                        