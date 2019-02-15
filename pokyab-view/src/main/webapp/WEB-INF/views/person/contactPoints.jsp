
<div class="row">
    <div class="col-12 col-md-10 col-xl-6">
        <div class="table-responsive-md">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-8"><h4>Punto de Contacto</b></h4></div>
                <div class="col-sm-4">
                    <button type="button" class="btn btn-info float-right add-new"><i class="fa fa-plus"></i>
                        <spring:message code="common.btn.addNew"/></button>
                </div>
            </div>
        </div>
        <table id="contactPointsListTable" class="table table-striped table-borderd">										
            <thead>
                <tr> 
                    <th></th>
                    <!--<th></th><th></th>-->
                    <th><spring:message code="contactPoint.table.contactType"/></th>
                    <th><spring:message code="contactPoint.table.useType"/></th>
                    <th><spring:message code="contactPoint.table.contactValue"/></th>
                    <th><spring:message code="common.field.primaryByType"/></th>                    
                    <th></th>  
                    <th></th>
                </tr>
            </thead>
            <tbody>                
                <c:choose>
                    <c:when test="${not empty contactPoints}">
                        <c:forEach items="${contactPoints}" var="contactPoints">
                            <tr>
                                <td>
                                    <a href="#" 
                                       class="add" title="Guardar" data-toggle="tooltip">
                                        <i class="fas fa-save"></i>                                        
                                    </a>                                    
<!--                                </td>
                                <td>-->
                                    <a href="#" 
                                       class="edit" title="Editar" data-toggle="tooltip">
                                        <i class="fas fa-edit"></i>                                       
                                    </a>                                    
<!--                                </td>
                                <td>-->
                                    <a href="${contextRoot}/manage/contactPoint/${contactPoints.contactPointId}/delete" 
                                       class="delete" title="Borrar" data-toggle="tooltip">
                                        <i class="fas fa-trash"></i>                                        
                                    </a>   
<!--                                </td>
                                <td>-->
                                    <a href="#" 
                                       class="undo" title="Cancelar" data-toggle="tooltip">
                                        <i class="fas fa-undo"></i>                                        
                                    </a>                                       
                                </td>                                
                                <td>${contactPoints.contactType}</td>
                                <td>${contactPoints.useType}</td>
                                <td>${contactPoints.contactValue}</td>                                
                                <td>${contactPoints.primaryByType}</td>                                
                                <td>
                                    <c:choose>
                                        <c:when test="${contactPoints.active eq 'Y'.charAt(0)}">                                            
                                            <label class="switch">
                                                <input type="checkbox" value="${contactPoints.contactPointId}" checked="checked"/>
                                                <div class="slider round"></div>
                                            </label>
                                        </c:when>
                                        <c:otherwise>
                                            <label class="switch">
                                                <input type="checkbox" value="${contactPoints.contactPointId}"/>
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
