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
                    <th><spring:message code="activity.table.activityName.short"/></th>
                    <th><spring:message code="activity.table.activityType.short"/></th>
                    <th><spring:message code="activity.table.metricType.short"/></th>
                    <th><spring:message code="activity.table.totalTime.short"/></th>
                    <th><spring:message code="activity.table.uomCode.short"/></th>
                    <th><spring:message code="activity.table.quantityMin.short"/></th>
                    <th><spring:message code="activity.table.quantityMax.short"/></th>
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