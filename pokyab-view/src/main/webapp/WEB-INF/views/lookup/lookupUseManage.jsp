
<!--<div class="container-fluid">-->
    <!--Breadcrumb row-->
    <div class="row">
        <div class="col-12 col-md-10 col-xl-8">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${contextRoot}/home">
                        <spring:message code="menu.navbar.home"/></a></li>
                        <li class="breadcrumb-item"><a href="${contextRoot}/manage/lookupType/${lookupUse.lookupTypeId}">
                        <spring:message code="lookupType.table.lookupType"/></a></li>
                    <li class="breadcrumb-item active" aria-current="page">${lookupUse.tableName}</li>
                </ol>
            </nav>
        </div>
    </div>

    <!--Lookup Value row-->
    <div class="row">
        <div class="col-12 col-md-10 col-xl-8">
            <div class="card">
                <div class="card-header">
                    <h5><spring:message code="lookupUse.manage.title"/></h5>
                </div>
                <div class="card-body">                    
                    <sf:form 
                        id="seasonForm"
                        modelAttribute="lookupUse" 
                        action="${contextRoot}/manage/lookupUse" 
                        method="POST"
                        class="form-group">
                        <div class="form-row">
                            <div class="form-group col-10 col-sm-5 col-md-5">
                                <label class="col-form-label" for="tableName">
                                    <spring:message code="lookupUse.table.tableName"/></label>
                                <sf:input path="lookupTypeId" id="lookupTypeId" type="hidden"/>
                                <sf:input path="lookupUseId" id="lookupUseId" type="hidden"/>
                                <sf:select path="tableName" id="tableName" class="form-control">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${tables}" itemLabel="tableName" itemValue="tableName" />
                                </sf:select>
                                <sf:errors path="tableName" cssClass="text-danger" element="div" />  				                       
                            </div>                
                            <div class="form-group col-10 col-sm-5 col-md-5">
                                <label class="col-form-label" for="columnName">
                                    <spring:message code="lookupUse.table.columnName"/></label>
                                <sf:select path="columnName" id="columnName" class="form-control">
                                    <sf:option value="" label="---"/>
                                    <sf:options items="${tableColumns}" itemLabel="columnName" itemValue="columnName" />
                                </sf:select>
                                <sf:errors path="columnName" cssClass="text-danger" element="div" />  				                           
                            </div>                                        
                        </div>                                           
                        <div class="form-row">
                            <div class="form-group col-6 col-sm-5 col-md-3">
                                <label for="startDate" class="col-form-label">
                                    <spring:message code="common.field.startDate"/></label>
                                <div>
                                    <sf:input path="startDate" id="startDate" type="date"/>
                                    <sf:errors path="startDate" cssClass="text-danger" element="div" />
                                </div>
                            </div>
                            <div class="form-group col-6 col-sm-5 col-md-3">
                                <label for="endDate" class="col-form-label">
                                    <spring:message code="common.field.endDate"/></label>
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
<!--</div>-->