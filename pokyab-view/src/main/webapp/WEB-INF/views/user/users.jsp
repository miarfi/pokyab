<!--Button Row-->
        <div class="row">
            <div class="col-12 col-md-8">
                <div class="text-right">
                    <br/>
                    <a class="btn btn-primary btn-sm" href="${contextRoot}/manage/person" role="button">
                        <spring:message code="person.table.btn.addPerson"/>
                    </a>   
                    <br/>  
                </div>      
            </div>
        </div>
        <!--Content Row-->
        <div class="row">
            <div class="col-12 col-md-12">
                <div class="table-responsive-md">
                    <table id="personsListTable" class="table table-striped table-borderd">										
                        <thead>
                            <tr>
                                <th></th>
                                <th></th>
                                <th><spring:message code="person.table.firstName"/></th>
                                <th><spring:message code="person.table.lastName"/></th>
                                <th><spring:message code="person.table.currentAge"/></th>
                                <th><spring:message code="person.table.genderCode"/></th>	
                                <th><spring:message code="person.table.personType"/></th>	
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