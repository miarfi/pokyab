<!--Button Row-->
<div class="row">
    <div class="col-12 col-xl-8">
        <div class="text-right">
            <br/>
            <a class="btn btn-primary btn-sm" href="${contextRoot}/manage/teamPerson" role="button">
                <spring:message code="teamPerson.table.btn.addTeamPerson"/></a>          
            <br/>
        </div>      
    </div>
</div>
        
<div class="row">
    <div class="col-12 col-xl-8">
        <div class="table-responsive-md">
        <table id="teamsListTable" class="table table-striped table-borderd">										
            <thead>
                <tr> 
                    <th></th><th></th>
                    <th><spring:message code="teamPerson.table.firstName"/></th>
                    <th><spring:message code="teamPerson.table.lastName"/></th>
                    <th><spring:message code="teamPerson.table.positionCode"/></th>
                    <th><spring:message code="teamPerson.table.playerNumber"/></th>
                    <th><spring:message code="teamPerson.table.statusCode"/></th>  
                    <th><spring:message code="teamPerson.table.startDate"/></th>
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