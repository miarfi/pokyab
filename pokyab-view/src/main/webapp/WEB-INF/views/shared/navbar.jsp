<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <a class="navbar-brand" href="#">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    
    <div class="collapse navbar-collapse" id="navbarText">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/teams">Teams</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${contextRoot}/players">Players</a>
            </li>
        </ul>
            
        <ul class="nav navbar-nav navbar-right">
            <li class="nav-item" id="register">
                <a class="nav-link" href="${contextRoot}/register">Sign</a>
            </li>
            <li class="nav-item" id="login">
                <a class="nav-link" href="${contextRoot}/login">Login</a>
            </li>
        </ul>
        <!--    <span class="navbar-text">
              Navbar text with an inline element
            </span>-->
    </div>


</nav>