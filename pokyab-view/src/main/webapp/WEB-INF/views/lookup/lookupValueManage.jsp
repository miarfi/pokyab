
<!--Breadcrumb row-->
<div class="row">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="${contextRoot}/home">
                <spring:message code="menu.navbar.home"/></a></li>
                <li class="breadcrumb-item"><a href="${contextRoot}/manage/lookupType/${lookupValue.lookupTypeId}">
                <spring:message code="lookupType.table.lookupType"/></a></li>
            <li class="breadcrumb-item active" aria-current="page">${lookupValue.lookupCode}</li>
        </ol>
    </nav>
</div>

<!--Lookup Value row-->
<div class="row">
    <div class="col-12 col-md-10 col-lg-8">
        <div class="card">
            <div class="card-header">
                <h5><spring:message code="lookupValue.manage.title"/></h5>
            </div>
            <div class="card-body">                    
                <sf:form 
                    id="seasonForm"
                    modelAttribute="lookupValue" 
                    action="${contextRoot}/manage/lookupValue" 
                    method="POST"
                    class="form-group">
                    <div class="form-row">                        
                        <div class="form-group col-12 col-sm-4">                            
                            <label for="lookupCode" class="col-form-label">
                                <spring:message code="lookupValue.table.lookupCode"/>:</label>
                            <sf:input path="lookupTypeId" id="lookupTypeId"  type="hidden"/>
                            <sf:input path="lookupValueId" id="lookupValueId"  type="hidden"/>
                            <sf:input path="lookupCode" type="text" class="form-control"/>
                            <sf:errors path="lookupCode" cssClass="text-danger" element="div"/>
                        </div>
                        <div class="form-group col-12 col-sm-4 col-md-4">
                            <label for="meaning" class="col-form-label">
                                <spring:message code="lookupValue.table.meaning"/>:</label>
                            <sf:input path="meaning" id="description" class="form-control"/> 
                            <sf:errors path="meaning" cssClass="text-danger" element="div"/>
                        </div>                         
                    </div>                       
                    <div class="form-row">
                        <div class="form-group col-12 col-sm-8 col-md-8">
                            <label for="description" class="col-form-label">
                                <spring:message code="lookupValue.table.description"/>:</label>
                            <sf:input path="description" id="description" class="form-control"/> 
                            <sf:errors path="description" cssClass="text-danger" element="div"/>
                        </div> 
                    </div>                          
                    <div class="form-row">
                        <div class="form-group col-6 col-sm-4 col-md-4">
                            <label for="startDate" class="col-form-label">
                                <spring:message code="common.field.startDate"/>:</label>
                            <div>
                                <sf:input path="startDate" id="startDate" type="date"/>
                                <sf:errors path="startDate" cssClass="text-danger" element="div" />
                            </div>
                        </div>
                        <div class="form-group col-6 col-sm-4 col-md-4">
                            <label for="endDate" class="col-form-label">
                                <spring:message code="common.field.endDate"/>:</label>
                            <div>
                                <sf:input path="endDate" id="endDate" type="date"/>
                                <sf:errors path="endDate" cssClass="text-danger" element="div" />
                            </div>
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