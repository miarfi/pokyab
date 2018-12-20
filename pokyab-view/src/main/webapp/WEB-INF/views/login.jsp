<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Bootstrap Core CSS -->
        <link href="${css}/bs/bootstrap.min.css" rel="stylesheet">

        <!-- Bootstrap Readable Theme -->
        <!--<link href="${css}/bs/bootstrap-lux-theme.css" rel="stylesheet">-->

        <!-- Custom CSS -->
        <link href="${css}/myapp.css" rel="stylesheet">

        <title>Pokyab - ${title}</title>

    </head>

    <body>

        <div class="wrapper">            
            <!--Navigation-->   
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                  <div class="container">
                      <!--Brand and toggle get grouped for better mobile display--> 
                      <div class="navbar-header">
                          <a class="navbar-brand" href="${contextRoot}/home">
                              <spring:message code="menu.navbar.home"/>
                          </a>
                      </div>
                  </div>
            </nav>
                            
            <!--Page content-->
            <div class="content">

               <div class="container">

                    <c:if test="${not empty message}">
                        <div class="row">
                            <div class="col-xs-12 col-md-offset-2 col-md-8">
                                <div class="alert alert-danger alert-dismissible fade in">
                                     <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    ${message}
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <c:if test="${not empty logout}">
                        <div class="row">
                            <div class="col-xs-12 col-md-offset-2 col-md-8">
                                <div class="alert alert-success alert-dismissible">
                                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                                    ${logout}
                                </div>
                            </div>
                        </div>
                    </c:if>

                    <div class="row">

                        <div class="col-md-offset-3 col-md-6">

                            <div class="card">

                                <div class="card-header">
                                    <h4><spring:message code="login.title"/></h4>
                                </div>

                                <div class="card-body">
                                    <form action="${contextRoot}/login" method="POST" class="form-horizontal"
                                          id="loginForm">
                                        <div class="form-group row">
                                            <label for="username" class="col-md-4 col-form-label">
                                                <spring:message code="login.field.username"/>: </label>
                                            <div class="col-md-8">
                                                <input type="text" name="username" id="username" class="form-control"/>
                                                <!--<sf:input path="username" id="username" type="text" class="form-control"/>--> 
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="password" class="col-md-4 col-form-label">
                                                <spring:message code="login.field.password"/>: </label>
                                            <div class="col-md-8">
                                                <!--<sf:input path="password" id="password" type="text" class="form-control"/>-->
                                                <input type="password" name="password" id="password" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-md-offset-4 col-md-8">
                                                <input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                <input type="submit" value="<spring:message code="login.btn.submit"/>" class="btn btn-primary"/>
                                            </div>
                                        </div>
                                    </form>

                                </div>
                                <div class="panel-footer">
                                    <div class="text-right">
                                        <spring:message code="login.label.newUser"/> - 
                                        <a href="${contextRoot}/register"><spring:message code="login.label.register"/></a>
                                    </div>
                                </div>

                            </div> 

                        </div>

                    </div>    

               </div>

            </div>
            
            <!--footer-->
            <%@include file="./shared/footer.jsp" %>
            
            <!-- Bootstrap core JavaScript -->
            <script src="${js}/bs/jquery.min.js" type="text/javascript"></script>
            <!--No funciona dataTables-->
            <!--<script src="${js}/bs/jquery-3.3.1.slim.min.js" type="text/javascript"></script>-->
            <script src="${js}/bs/popper.min.js" type="text/javascript"></script>
            
            <!--Revisar diferencias 4 bs-->
            <script src="${js}/bs/bootstrap.js" type="text/javascript"></script>
            <!--<script src="${js}/bs/bootstrap.bundle.js" type="text/javascript"></script>-->
            <!--<script src="${js}/bs/bootstrap.bundle.min.js" type="text/javascript"></script>-->
        </div>

    </body>

</html>