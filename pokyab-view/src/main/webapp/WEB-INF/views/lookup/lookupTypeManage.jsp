
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
    
    <div class="col-12 col-md-10 col-lg-8">
        <div class="card">
            <div class="card-header">
                <h5><spring:message code="lookupType.manage.title"/></h5>
            </div>
            <div class="card-body">                    
                <sf:form 
                    id="seasonForm"
                    modelAttribute="lookupType" 
                    action="${contextRoot}/manage/lookupType" 
                    method="POST"
                    class="form-group">
                    <div class="form-row">
                        <div class="form-group col-12 col-sm-4 col-md-3">
                            <label for="lookupType" class="col-form-label">
                                <spring:message code="lookupType.table.lookupType"/>:</label>
                                <sf:input path="lookupTypeId" id="lookupTypeId"  type="hidden"/>
                                <sf:input path="lookupType" type="text" class="form-control"/>
                                <sf:errors path="lookupType" cssClass="text-danger" element="div"/>
                        </div>
                        <div class="form-group col-12 col-sm-6 col-md-4">
                            <label for="description" class="col-form-label">
                                <spring:message code="lookupType.table.description"/>:</label>
                                <sf:input path="description" id="description" class="form-control"/> 
                                <sf:errors path="description" cssClass="text-danger" element="div"/>
                        </div> 
                    </div>
                    <div class="form-row">
                        <div class="form-group col-6 col-sm-4 col-md-3">
                            <label for="startDate" class="col-form-label">
                                <spring:message code="common.field.startDate"/>:</label>
                            <div>
                                <sf:input path="startDate" id="startDate" type="date"/>
                                <sf:errors path="startDate" cssClass="text-danger" element="div" />
                            </div>
                        </div>
                        <div class="form-group col-6 col-sm-4 col-md-3">
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
                        <button type="button" class="btn btn-primary">
                            <spring:message code="common.btn.save"/></button>
                    </div>
                </sf:form>

            </div>                
        </div>
    </div>
</div>            
            
<c:if test="${lookupType.lookupTypeId > 0 }">      
   
    <nav>
      <div class="nav nav-tabs" id="nav-tab" role="tablist">
        <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">
            Valores</a>
        <a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">
            Usos</a>
        </div>
    </nav>

    <div class="tab-content" id="nav-tabContent">
        <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
   
            <!--Button Row-->
            <div class="row">
                <div class="col-12 col-xl-8">
                    <div class="text-right">
                        <br/>										
                        <button type="submit" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#mylookupValueModal">
                            <spring:message code="lookupType.table.btn.addLookupValue"/>
                        </button>
                    </div>      
                </div>
            </div>

            <!--Lookup Values table row-->
            <%@include file="lookupValues.jsp" %>            
        </div>
        
        <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
            <!--Button Row-->
            <div class="row">
                <div class="col-12 col-xl-8">
                    <div class="text-right">
                        <br/>										
                        <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#mylookupUseModal">
                            <spring:message code="lookupType.table.btn.addLookupUse"/>
                        </button>
                    </div>      
                </div>
            </div>

            <!--Lookup Uses table row-->
            <%@include file="lookupUses.jsp" %> 
        </div>

    </div>    
        
    <!--Lookup Value modal row-->
    <%@include file="lookupValueModal.jsp" %>      
    <!--Lookup Use modal row-->
    <%@include file="lookupUseModal.jsp" %>    
</c:if>                                                                     