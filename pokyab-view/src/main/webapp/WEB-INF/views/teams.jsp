

<!--Button Row-->
<div class="row">
    <div class="col-12 col-md-8">
        <div class="text-right">
            <br/>
            <a class="btn btn-primary btn-sm" href="${contextRoot}/manage/team" role="button"><spring:message code="team.table.btn.addTeam"/></a>          
            <br/>
        </div>      
    </div>
</div>
        
<div class="row">
    <div class="col-12 col-md-8">
        <table id="teamsListTable" class="table table-striped table-borderd">										
            <thead>
                <tr> 
                    <th></th>
                    <th><spring:message code="team.table.teamName"/></th>
                    <th><spring:message code="team.table.groupNumber"/></th>
                    <th><spring:message code="team.table.league"/></th>
                    <th><spring:message code="team.table.season"/></th>
                    <th><spring:message code="team.modal.league.category"/></th>                    
                    <th><spring:message code="team.table.trainer"/></th>
                    <th><spring:message code="team.table.conceded.short"/></th>  
                    <th><spring:message code="team.table.scores.short"/></th>              
                    <th><spring:message code="team.table.played.short"/></th>   
                    <th><spring:message code="team.table.wins.short"/></th>                    
                    <th><spring:message code="team.table.draws.short"/></th>  
                    <th><spring:message code="team.table.losts.short"/></th>  
                    <th><spring:message code="team.table.points.short"/></th>  
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

