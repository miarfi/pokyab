
<div class="row">
    <div class="col">
        <div class="table table-responsive">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-8"><h5>Direcciones</h5></div>
                <div class="col-sm-4">
                    <button type="button" class="btn btn-info float-right add-new"><i class="fa fa-plus"></i>
                        <spring:message code="common.btn.addNew"/></button>
                </div>
            </div>
        </div>
        <table id="locationsListTable" class="table table-striped table-borderd">										
            <thead>
                <tr> 
                    <th></th>
                    <!--<th></th><th></th>-->
                    <th><spring:message code="location.table.address1"/></th>
                    <th><spring:message code="location.table.state"/></th>
                    <th><spring:message code="location.table.country"/></th>
                    <th><spring:message code="location.table.postalCode"/></th>                    
                    <th></th>  
                    <th></th>
                </tr>
            </thead>
            <tbody>                
                <c:choose>
                    <c:when test="${not empty locations}">
                        <c:forEach items="${locations}" var="locations">
                            <tr>
                                <td>
                                    <a href="#" 
                                       class="add" title="Guardar" data-toggle="tooltip"
                                       title="<spring:message code="common.a.title.save"/>">
                                        <i class="fas fa-save"></i>                                        
                                    </a>                                    
<!--                                </td>
                                <td>-->
                                    <a href="#" 
                                       class="edit" data-toggle="tooltip"
                                       title="<spring:message code="common.a.title.edit"/>">
                                        <i class="fas fa-edit"></i>                                       
                                    </a>                                    
<!--                                </td>
                                <td>-->
                                    <a href="${contextRoot}/manage/location/${locations.locationId}/delete" 
                                       class="delete" data-toggle="tooltip"
                                       title="<spring:message code="common.a.title.delete"/>">
                                        <i class="fas fa-trash"></i>                                        
                                    </a>   
<!--                                </td>
                                <td>-->
                                    <a href="#" 
                                       class="undo" title="Cancelar" data-toggle="tooltip"
                                       title="<spring:message code="common.a.title.cancel"/>">
                                        <i class="fas fa-undo"></i>                                        
                                    </a>                                       
                                </td>                                
                                <td>${locations.address1}</td>
                                <td>${locations.state}</td>
                                <td>${locations.country}</td>                                
                                <td>${locations.postalCode}</td>                                
                                <td>
                                    <c:choose>
                                        <c:when test="${locations.active eq 'Y'.charAt(0)}">                                            
                                            <label class="switch">
                                                <input type="checkbox" value="${locations.locationId}" checked="checked"/>
                                                <div class="slider round"></div>
                                            </label>
                                        </c:when>
                                        <c:otherwise>
                                            <label class="switch">
                                                <input type="checkbox" value="${locations.locationId}"/>
                                                <div class="slider round"></div>
                                            </label>
                                        </c:otherwise>
                                    </c:choose>                                
                                </td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
<!--                        <tr>
                            <td colspan="7"><spring:message code="common.nodatafound"/></td>
                        </tr>-->
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
