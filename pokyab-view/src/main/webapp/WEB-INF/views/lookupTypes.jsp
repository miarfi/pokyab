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
    <div class="col-12 col-md-8">
        <table id="lookupTypesListTable" class="table table-striped table-borderd">										
            <thead>
                <tr> 
                    <th></th>
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



<%@include file="lookupTypeModal.jsp" %>