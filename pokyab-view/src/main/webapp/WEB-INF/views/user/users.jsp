    <!--Button Row-->
    <div class="row">
        <div class="col-12 col-xl-8">
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
        <div class="col-12 col-xl-8">
            <div class="table-responsive-md">
                <table id="usersListTable" class="table table-striped table-borderd">										
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                            <th><spring:message code="user.form.firstName"/></th>
                            <th><spring:message code="user.form.lastName"/></th>
                            <th><spring:message code="user.form.email"/></th>                     
                            <th><spring:message code="user.form.role"/></th>  
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