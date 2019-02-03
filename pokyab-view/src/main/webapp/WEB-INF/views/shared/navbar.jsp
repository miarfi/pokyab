<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <a class="navbar-brand" href="${contextRoot}/home"><spring:message code="menu.navbar.home"/></a>
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
<!--            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/persons">
                    <spring:message code="menu.navbar.persons"/>
                </a>
            </li>             -->
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/trainings">
                    <spring:message code="menu.navbar.trainings"/>
                </a>
            </li>  
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/matchs">
                    <spring:message code="menu.navbar.matchs"/>
                </a>
            </li> 
            <security:authorize access="hasRole('ROLE_ADMIN')">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <spring:message code="menu.navbar.catalog"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item" href="${contextRoot}/persons">
                    <spring:message code="menu.navbar.persons"/></a>
                  <a class="dropdown-item" href="${contextRoot}/lookupTypes">
                      <spring:message code="menu.navbar.lookupTypes"/></a>                  
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="${contextRoot}/activities">
                      <spring:message code="menu.navbar.activities"/></a>
                  <a class="dropdown-item" href="${contextRoot}/leagues">
                      <spring:message code="menu.navbar.leagues"/></a>
                  <a class="dropdown-item" href="${contextRoot}/seasons">
                      <spring:message code="menu.navbar.seasons"/></a>                      
                </div>
            </li>            
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <spring:message code="menu.navbar.admon"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item" href="${contextRoot}/users">
                      <spring:message code="menu.navbar.users"/></a>                  
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="#">
                      </a>                                      
                </div>
            </li>     
            </security:authorize>
        </ul>
         
        <ul class="nav navbar-nav navbar-right">
            <security:authorize access="isAnonymous()">
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
            </security:authorize>
            <security:authorize access="isAuthenticated()">
                <li class="dropdown" id="userModel">
                    <a class="btn btn-default dropdown-toggle" href="javascript:void(0)" 
                       id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                        ${userModel.fullName}
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">	
                        <li id="profile">
                            <a href="${contextRoot}/profile">
                                <spring:message code="menu.navbar.profile"/>
                            </a>
                        </li> 
                        <li role="separator" class="divider"></li>	                                              							
                        <li id="logout">
                            <a href="${contextRoot}/logout">
                                <spring:message code="menu.navbar.logout"/>
                            </a>
                        </li>                    			    	
                    </ul>		
                </li>
            </security:authorize>
        </ul>                        
        <!--    <span class="navbar-text">
              Navbar text with an inline element
            </span>-->
    </div>


</nav>