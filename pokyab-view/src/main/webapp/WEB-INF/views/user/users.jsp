    <!--Button Row-->
    <div class="row">
        <div class="col-12 col-md-8">
            <div class="text-right">
                <br/>
                <a class="btn btn-primary btn-sm" href="${contextRoot}/manage/user" role="button">
                    <spring:message code="user.table.btn.addUser"/>
                </a>   
                <br/>  
            </div>      
        </div>
    </div>

    <!--Content Row-->
    <div class="row">
        <div class="col-12 col-md-8">
            <div class="table-responsive-md">
                <table id="usersListTable" class="table table-striped table-borderd">										
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                            <th><spring:message code="user.table.firstName"/></th>
                            <th><spring:message code="user.table.lastName"/></th>
                            <th><spring:message code="user.table.email"/></th>                     
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