<!--Button Row-->
<div class="row">
    <div class="col-12 col-md-10 col-xl-8">
        <div class="text-right">
            <br/>
            <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myTrainerModal">
                <spring:message code="team.table.btn.addPerson"/>
            </button>
            <button type="button" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myTeamPersonModal">
                <spring:message code="teamPerson.table.btn.addPerson"/>
            </button>
        </div>      
    </div>
</div>
                
<div class="row">
    <div class="col-12 col-md-10 col-xl-8">
        <div class="table-responsive-md">
        <table id="teamPersonsListTable" class="table table-striped table-borderd">										
            <thead>
                <tr> 
                    <th></th><th></th>
                    <th><spring:message code="teamPerson.table.fullName"/></th>  
                    <th><spring:message code="teamPerson.table.memberType"/></th>
                    <th><spring:message code="teamPerson.table.positionCode"/></th>
                    <th><spring:message code="teamPerson.table.playerNumber"/></th>
                    <th><spring:message code="common.field.statusCode"/></th>  
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