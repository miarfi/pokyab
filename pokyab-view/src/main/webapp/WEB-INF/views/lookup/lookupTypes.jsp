
<!--Button Row-->
<div class="row">
    <div class="col-12 col-md-8">
        <div class="text-right">
            <br/>										
            <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myLookupTypeModal">
                <spring:message code="lookupType.table.btn.addLookupType"/>
            </button>
        </div>      
    </div>
</div>

<div class="row">
    <div class="col-12 col-md-8"><!--col-md-8 se mueve el footer-->
        <div class="table-responsive">
            <table id="lookupTypesListTable" class="table table-striped table-bordered">										
                <thead>
                    <tr> 
                        <th></th><th></th>
                        <th><spring:message code="lookupType.table.lookupType"/></th>
                        <th><spring:message code="lookupType.table.description"/></th>
                        <th><spring:message code="lookupType.table.system"/></th>
                        <th><spring:message code="common.field.startDate"/></th>
                        <th><spring:message code="common.field.endDate"/></th>                    
                        <th></th>	
                    </tr>
                </thead>
    <!--            <tfoot>
                    <tr>

                    </tr>
                </tfoot>-->
            </table>
        </div>
    </div>			
</div>

<%@include file="lookupTypeModal.jsp" %>

