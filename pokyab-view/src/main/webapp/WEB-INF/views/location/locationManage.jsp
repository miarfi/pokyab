<sf:form 
                        id="locationForm"
                        modelAttribute="location" 
                        action="${contextRoot}/manage/location" 
                        method="POST"
                        class="form-horizonal">
                        
                        <div class="form-row">
                            <div class="form-group col-sm-4 col-md-4 col-lg-3">
                                <label for="address1" class="col-form-label">
                                    <spring:message code="location.table.address1"/></label>                                
                                <sf:hidden id="LocationId" path="LocationId"/>
                                <sf:input path="address1" id="address1" type="text" class="form-control" required="true"/>
                                <sf:errors path="address1" cssClass="text-danger" element="div" />                                
                            </div>
                            <div class="form-group col-sm-4 col-md-4 col-lg-3">
                                <label for="state" class="col-form-label">
                                    <spring:message code="location.table.state"/></label>                                
                                <sf:input path="state" id="state" type="text" class="form-control" required="true"/>
                                <sf:errors path="state" cssClass="text-danger" element="div" />                                
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-sm-4 col-md-4 col-lg-3">
                                <label for="country" class="col-form-label">
                                    <spring:message code="location.table.country"/></label>                                                                
                                <sf:input path="country" id="country" type="text" class="form-control" required="true"/>
                                <sf:errors path="country" cssClass="text-danger" element="div" />                                
                            </div>
                            <div class="form-group col-sm-4 col-md-4 col-lg-3">
                                <label for="postalCode" class="col-form-label">
                                    <spring:message code="location.table.postalCode"/></label>                                
                                <sf:input path="postalCode" id="postalCode" type="text" class="form-control" required="true"/>
                                <sf:errors path="postalCode" cssClass="text-danger" element="div" />                                
                            </div>
                        </div>
                        
                        <div class="form-row">
                            
                            <div class="form-group col-6 col-sm-4 col-md-4 col-lg-3">
                                <label for="startDate" class="col-form-label">
                                    <spring:message code="common.field.startDate"/></label>
                                <div>
                                    <sf:input path="startDate" id="startDate" type="date" class="form-control" required="true"/> 
                                    <sf:errors path="startDate" cssClass="text-danger" element="div" />
                                </div>
                            </div>  
                            <c:if test="${Location.LocationId > 0 }">
                                <div class="form-group col-6 col-sm-4 col-md-4 col-lg-3">
                                    <label for="endDate" class="col-form-label">
                                        <spring:message code="common.field.endDate"/></label>
                                    <div>
                                        <sf:input path="endDate" id="endDate" type="date" class="form-control"/> 
                                        <sf:errors path="endDate" cssClass="text-danger" element="div" />
                                    </div>
                                </div>   
                            </c:if>                            
                        </div>
                        
                        <div class="form-group">								                                                        
                            <button type="submit" class="btn btn-primary">
                                <spring:message code="common.btn.save"/></button>
                        </div>                                       
                    </sf:form>   