
<!--Button Row-->
<div class="row">
    <div class="col-12 col-xl-8">
        <div class="text-right">
            <br/>
            <a class="btn btn-primary btn-sm" href="${contextRoot}/manage/match" role="button">
                <spring:message code="match.table.btn.addMatch"/></a>          
            <br/>
        </div>      
    </div>
</div>
        
<div class="row">
    <div class="col-12 col-xl-8">
        <div class="table-responsive-md">
        <table id="matchsListTable" class="table table-striped table-borderd">										
            <thead>
                <tr> 
                    <th></th> <th></th>
                    <th><spring:message code="match.table.homeTeamName"/></th>
                    <th><spring:message code="match.table.homeScore.short"/></th>
                    <th><spring:message code="match.table.awayTeamName"/></th>
                    <th><spring:message code="match.table.awayScore.short"/></th>
                    <th><spring:message code="match.table.leagueName"/></th>
                    <th><spring:message code="match.table.seasonName"/></th>
                    <th><spring:message code="match.table.matchDate"/></th>
                    <th><spring:message code="match.table.matchTime"/></th>  
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

