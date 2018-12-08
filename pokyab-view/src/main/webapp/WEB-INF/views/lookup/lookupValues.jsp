

<div class="row">
    <div class="col-12 col-md-12">
        <div class="table-responsive-md">
        <table id="lookupValuesListTable" class="table table-striped table-borderd">										
            <thead>
                <tr> 
                    <th></th>
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
                                <td>
                                    <a href="${contextRoot}/manage/lookupValue/${lookupValue.lookupValueId}">
                                        <i class="fas fa-edit"></i>                                       
                                    </a>                                    
                                </td>
                                <td>
                                    <a href="${contextRoot}/manage/lookupValue/${lookupValue.lookupValueId}/delete" class="confirmation">
                                        <i class="fas fa-trash"></i>                                        
                                    </a>                                    
                                </td>
                                <td>${lookupValue.lookupCode}</td>
                                <td>${lookupValue.meaning}</td>
                                <td>${lookupValue.description}</td>
                                <td><fmt:formatDate type = "date" 
                                    value = "${lookupValue.startDate}" pattern='dd-MM-yyyy'/></td>
                                <td><fmt:formatDate type = "date" 
                                    value = "${lookupValue.endDate}" pattern='dd-MM-yyyy'/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${lookupValue.active eq 'Y'.charAt(0)}">                                            
                                            <label class="switch">
                                                <input type="checkbox" value="${lookupValue.lookupValueId}" checked="checked"/>
                                                <div class="slider round"></div>
                                            </label>
                                        </c:when>
                                        <c:otherwise>
                                            <label class="switch">
                                                <input type="checkbox" value="${lookupValue.lookupValueId}"/>
                                                <div class="slider round"></div>
                                            </label>
                                        </c:otherwise>
                                    </c:choose>                                
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="7"><spring:message code="common.nodatafound"/></td>
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
</div>