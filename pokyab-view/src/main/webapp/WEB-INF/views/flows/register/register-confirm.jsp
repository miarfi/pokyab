<%@include file="../shared/flows-header.jsp" %>

<div class="container">    
    <div class="row">
        <div class="col-sm-6">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4><spring:message code="user.form.personal.title"/></h4>
                </div>

                <div class="panel-body">
                    <div class="text-center">
                        <h3><spring:message code="user.form.firstName"/> : 
                            <strong>${registerModel.user.firstName} ${registerModel.user.lastName}</strong></h3>
                        <h4><spring:message code="user.form.email"/> : 
                            <strong>${registerModel.user.email}</strong></h4>
                        <h4><spring:message code="user.form.contactNumber"/> : 
                            <strong>${registerModel.user.contactNumber}</strong></h4>                   
                        <p>
                            <a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">
                                <spring:message code="common.btn.edit"/></a>
                        </p>
                    </div>
                </div>
            </div>
        </div>       
    </div>

    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <div class="text-center">
                <a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-lg btn-primary">Confirm</a>
            </div>
        </div>              
    </div>
</div>


<%@include file="../shared/flows-footer.jsp" %>
        