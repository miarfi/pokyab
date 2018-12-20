<div class="row">
    <div class="col-12 col-xl-8">
        <div class="table-responsive-md">
        <table id="lookupUsesListTable" class="table table-striped table-borderd">										
            <thead>
                <tr> 
                    <th></th><th></th>
                    <th><spring:message code="lookupUse.table.tableName"/></th>
                    <th><spring:message code="lookupUse.table.columnName"/></th>
                    <!--<th><spring:message code="lookupUse.table.required"/></th>-->
                    <th><spring:message code="common.field.startDate"/></th>
                    <th><spring:message code="common.field.endDate"/></th>
                    <th></th>                   
                </tr>
            </thead>
            <tbody>                
                <c:choose>
                    <c:when test="${not empty lookupType.lookupUseCollection}">
                        <c:forEach items="${lookupType.lookupUseCollection}" var="lookupUse">
                            <tr>
                                <td>
                                    <a href="${contextRoot}/manage/lookupUse/${lookupUse.lookupUseId}">
                                        <i class="fas fa-edit"></i>                                       
                                    </a>                                    
                                </td>
                                <td>
                                    <a href="${contextRoot}/manage/lookupUse/${lookupUse.lookupUseId}/delete" class="confirmation">
                                        <i class="fas fa-trash"></i>                                        
                                    </a>                                    
                                </td>
                                <td>${lookupUse.tableName}</td>
                                <td>${lookupUse.columnName}</td>
                                <!--<td>${lookupUse.required}</td>-->
                                <td><fmt:formatDate type = "date" 
                                    value = "${lookupUse.startDate}" pattern='dd-MM-yyyy'/></td>
                                <td><fmt:formatDate type = "date" 
                                    value = "${lookupUse.endDate}" pattern='dd-MM-yyyy'/></td>
                                <td>
                                    <c:choose>
                                        <c:when test="${lookupUse.active eq true}">                                            
                                            <label class="switch">
                                                <input type="checkbox" value="${lookupUse.lookupUseId}" checked="checked"/>
                                                <div class="slider round"></div>
                                            </label>
                                        </c:when>
                                        <c:otherwise>
                                            <label class="switch">
                                                <input type="checkbox" value="${lookupUse.lookupUseId}"/>
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