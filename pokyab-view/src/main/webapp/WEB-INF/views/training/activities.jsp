

<!--Button Row-->
<div class="row">
    <div class="col-12 col-xl-8">
        <div class="text-right">
            <br/>
            <a class="btn btn-primary btn-sm" href="${contextRoot}/manage/activity" role="button">
                <spring:message code="activity.table.btn.addActivity"/></a>  
            <br/>
        </div>      
    </div>
</div>
                
<div class="row">
    <div class="col-12 col-xl-8">
        <div class="table-responsive-md">
        <table id="activitiesListTable" class="table table-striped table-borderd">										
            <thead>
                <tr> 
                    <th></th><th></th>
                    <th><spring:message code="activity.table.activityName"/></th>
                    <th><spring:message code="activity.table.activityType"/></th>
                    <th><spring:message code="activity.table.metricType"/></th>
                    <th><spring:message code="activity.table.totalTime"/></th>
                    <th><spring:message code="activity.table.uomCode"/></th>
                    <th><spring:message code="activity.table.quantityMin"/></th>
                    <th><spring:message code="activity.table.quantityMax"/></th>
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