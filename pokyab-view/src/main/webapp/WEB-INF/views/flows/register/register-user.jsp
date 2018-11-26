<%@include file="../shared/flows-header.jsp" %>

<div class="container">    
    <div class="row">
        <div class="col-md-6 col-md-offset-3">

            <div class="panel panel-primary">

                <div class="panel-heading">
                    <h4><spring:message code="user.form.personal.title"/></h4>
                </div>

                <div class="panel-body">

                    <sf:form
                        method="POST"
                        modelAttribute="user"
                        class="form-horizontal"
                        id="registerForm">
                        <div class="form-group">
                            <label for="firstName" class="col-form-label col-md-4">
                                <spring:message code="user.form.firstName"/></label>
                            <div class="col-md-8">
                                <sf:input path="firstName" type="text" class="form-control"/>
                                <sf:errors path="firstName" cssClass="text-danger" element="div"/> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="lastName" class="col-form-label col-md-4">
                                <spring:message code="user.form.lastName"/></label>
                            <div class="col-md-8">
                                <sf:input path="lastName" type="text" class="form-control"/>
                                <sf:errors path="lastName" cssClass="text-danger" element="div"/> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="contactNumber" class="col-form-label col-md-4">
                                <spring:message code="user.form.contactNumber"/></label>
                            <div class="col-md-8">
                                <sf:input type="text" path="contactNumber" class="form-control" maxlength="10" />
                                <sf:errors path="contactNumber" cssClass="text-danger" element="div"/> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-form-label col-md-4">
                                <spring:message code="user.form.email"/></label>
                            <div class="col-md-8">
                                <sf:input path="email" type="text" class="form-control"/>
                                <sf:errors path="email" cssClass="text-danger" element="div"/> 									
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-form-label col-md-4">
                                <spring:message code="user.form.password"/></label>
                            <div class="col-md-8">
                                <sf:input type="password" path="password" class="form-control"/>
                                <sf:errors path="password" cssClass="text-danger" element="div"/> 
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword" class="col-form-label col-md-4">
                                <spring:message code="user.form.confirmPassword"/></label>
                            <div class="col-md-8">
                                <sf:input type="password" path="confirmPassword" class="form-control"/>
                                <sf:errors path="confirmPassword" cssClass="text-danger" element="div"/>										 
                            </div>
                        </div>
<!--                        <div class="form-group">
                            <label class="col-form-label col-md-4">Select Role</label>
                            <div class="col-md-8">
                                <label class="radio-inline">
                                    <sf:radiobutton path="role" value="USER" checked="checked"/> User 				
                                </label>
                                <label class="radio-inline">
                                    <sf:radiobutton path="role" value="SUPPLIER"/> Supplier
                                </label>
                            </div>
                        </div>							-->
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <button type="submit" name="_eventId_confirm" class="btn btn-primary">
                                    <spring:message code="user.form.btn.next.confirm"/>
                                    <span class="glyphicon glyphicon-chevron-right"></span>
                                </button>																	 
                            </div>
                        </div>

                    </sf:form>					
                </div>
            </div>
        </div>     
    </div>
</div>
<%@include file="../shared/flows-footer.jsp" %>