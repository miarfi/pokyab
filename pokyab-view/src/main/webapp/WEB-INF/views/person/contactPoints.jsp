
<div class="row">
    <div class="col-12 col-xl-8">
        <div class="table-responsive-md">
        <table id="contactPointsListTable" class="table table-striped table-borderd">										
            <thead>
                <tr> 
                    <th></th><th></th>
                    <th><spring:message code="contactPoint.table.contactType"/></th>
                    <th><spring:message code="contactPoint.table.useType"/></th>
                    <th><spring:message code="contactPoint.table.contactValue"/></th>
                    <th><spring:message code="common.field.primaryByType"/></th>                    
                    <th></th>                   
                </tr>
            </thead>
            <tbody>                
                <c:choose>
                    <c:when test="${not empty lookupType.contactPointCollection}">
                        <c:forEach items="${lookupType.contactPointCollection}" var="contactPoint">
                            <tr>
                                <td>
                                    <a href="${contextRoot}/manage/contactPoint/${contactPoint.contactPointId}">
                                        <i class="fas fa-edit"></i>                                       
                                    </a>                                    
                                </td>
                                <td>
                                    <a href="${contextRoot}/manage/contactPoint/${contactPoint.contactPointId}/delete" class="confirmation">
                                        <i class="fas fa-trash"></i>                                        
                                    </a>                                    
                                </td>
                                <td>${contactPoint.contactType}</td>
                                <td>${contactPoint.useType}</td>
                                <td>${contactPoint.contactValue}</td>                                
                                <td>${contactPoint.primaryByType}</td>                                
                                <td>
                                    <c:choose>
                                        <c:when test="${contactPoint.active eq 'Y'.charAt(0)}">                                            
                                            <label class="switch">
                                                <input type="checkbox" value="${contactPoint.contactPointId}" checked="checked"/>
                                                <div class="slider round"></div>
                                            </label>
                                        </c:when>
                                        <c:otherwise>
                                            <label class="switch">
                                                <input type="checkbox" value="${contactPoint.contactPointId}"/>
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
                    <!--Add TR-->
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
                                                
<div class="row">
    <div class="col-12 col-xl-8">
        <div class="text-right">
            <br/>										
            <button type="button" class="btn btn-primary btn-sm" id="btn-add-cp">
                <spring:message code="lookupType.table.btn.addContactPoint"/>
            </button>
        </div>      
    </div>
</div>