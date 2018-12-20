

<!--Button Row-->
<div class="row">
    <div class="col-12 col-xl-8">
        <div class="text-right">
            <br/>
            <a class="btn btn-primary btn-sm" href="${contextRoot}/manage/training" role="button">
                <spring:message code="training.table.btn.addTraining"/></a>          
            <br/>
        </div>      
    </div>
</div>  

<div class="row">
    <div class="col-12 col-xl-8">
        <div class="table-responsive-md">
        <table id="trainingsListTable" class="table table-striped table-borderd">										
            <thead>
                <tr> 
                    <th></th><th></th>
                    <th><spring:message code="training.table.trainingName"/></th>
                    <th><spring:message code="training.table.categoryCode"/></th>
                    <th><spring:message code="training.table.weeks"/></th>                    
                    <th><spring:message code="training.table.creator"/></th>
                    <th><spring:message code="common.field.active"/></th>                                       
                    <th><spring:message code="training.table.approver"/></th>
                    <th><spring:message code="common.field.startDate"/></th>
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