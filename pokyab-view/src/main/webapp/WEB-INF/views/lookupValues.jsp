<div class="row">
    <div class="col-12 col-md-8">
        <table id="lookupValuesListTable" class="table table-striped table-borderd">										
            <thead>
                <tr> 
                    <th></th>
                    <th><spring:message code="lookupValue.table.lookupCode"/></th>
                    <th><spring:message code="lookupValue.table.meaning"/></th>
                    <th><spring:message code="lookupValue.table.description"/></th>
                    <th><spring:message code="common.field.startDate"/></th>
                    <th><spring:message code="common.field.endDate"/></th>
                    <th></th>                   
                </tr>
            </thead>
            <tbody>                
                <c:choose>
                    <c:when test="${not empty lookupType.lookupValueCollection}">
                        <c:forEach items="${lookupType.lookupValueCollection}" var="lookupValue">
                            <tr>
                                <td>${lookupValue.lookupCode}</td>
                                <td>${lookupValue.meaning}</td>
                                <td>${lookupValue.description}</td>
                                <td><fmt:formatDate type = "date" 
                                    value = "${lookupValue.startDate}" pattern='dd-MM-yyyy'/></td>
                                <td><fmt:formatDate type = "date" 
                                    value = "${lookupValue.endDate}" pattern='dd-MM-yyyy'/></td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td><spring:message code="common.nodatafound"/></td>
                        </tr>
                    </c:otherwise>
                </c:choose>                               
            </tbody>
                
<!--            <tfoot>
                <tr>
               
                </tr>
            </tfoot>-->
        </table>
    </div>			
</div>