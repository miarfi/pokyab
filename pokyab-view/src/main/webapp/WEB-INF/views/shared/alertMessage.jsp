    
    <c:if test="${not empty alertMessage}">
        <div class="row">
            <div class="col-12 col-md-10 col-xl-8">
                <div class="alert alert-success alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    ${alertMessage}
                </div>
            </div>
        </div>
    </c:if>