<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <a class="navbar-brand" href="#">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${contextRoot}/teams">
                    <spring:message code="menu.navbar.teams"/>
                <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/players">
                    <spring:message code="menu.navbar.players"/>
                </a>
            </li>  
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/activities">
                    <spring:message code="menu.navbar.activities"/>
                </a>
            </li>  
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/trainings">
                    <spring:message code="menu.navbar.trainings"/>
                </a>
            </li>  
            
<!--            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/manage/team">
                <spring:message code="menu.navbar.team"/>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/manage/training">
                <spring:message code="menu.navbar.training"/>
                </a>
            </li>            
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/manage/activity">
                <spring:message code="menu.navbar.activity"/>
                </a>
            </li>    -->
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/lookupTypes">
                <spring:message code="menu.navbar.lookupTypes"/>
                </a>
            </li>              
        </ul>
            
        <ul class="nav navbar-nav navbar-right">
            <li class="nav-item" id="register">
                <a class="nav-link" href="${contextRoot}/register">
                <spring:message code="menu.navbar.sign"/>
                </a>
            </li>
            <li class="nav-item" id="login">
                <a class="nav-link" href="${contextRoot}/login">
                <spring:message code="menu.navbar.login"/>
                </a>
            </li>
        </ul>
        <!--    <span class="navbar-text">
              Navbar text with an inline element
            </span>-->
    </div>


</nav>