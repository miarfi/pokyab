
<div class="container">   
    <!--Breadcrumb row-->
    <div class="row">

    </div>
 
    <!--Training row-->
    <div class="row">
        <div class="col-12 col-md-8">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h4><spring:message code="person.manage.title"/></h4>
                </div>
                <div class="panel-body">
                                           
                    <sf:form 
                            id="personForm"
                            modelAttribute="person" 
                            action="${contextRoot}/manage/person" 
                            method="POST"
                            class="form-horizonal">

                            <div class="form-group">
                                <label for="firstName" class="control-label col-md-4"><spring:message code="person.table.firstName"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="firstName" id="firstName" type="text" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="lastName" class="control-label col-md-4"><spring:message code="person.table.lastName"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="lastName" id="lastName" type="text" class="form-control"/>
                                </div>
                            </div>  
                            
                            <div class="form-group">
                                <label for="genderCode" class="control-label col-md-4"><spring:message code="person.table.genderCode"/>:</label>
                                <div class="col-md-8">
                                    <sf:input path="genderCode" id="genderCode" type="text" class="form-control"/>
                                </div>
                            </div>   
                              
                            <div class="form-group">								
                                <div class="col-offset-4 col-md-8">
                                    <sf:hidden path="maritalStatusCode" value="SINGLE"/>
                                    <sf:hidden path="personType" value="PLAYER"/>
<!--                                    <sf:hidden path="startDate"/>
                                    <sf:hidden path="dateOfBirth"/>-->
                                    <input type="submit" value="<spring:message code="team.table.btn.addTrainer"/>" class="btn btn-primary">
                                </div>
                            </div>                                       
                    </sf:form>                    
                </div>                
            </div>
        </div>
    </div>
                        
</div>
