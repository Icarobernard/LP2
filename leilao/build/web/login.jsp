<%-- 
    Document   : login
    Created on : 26/11/2018, 13:45:13
    Author     : Samsung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

        <style type="text/css">

            body {
                background-color:#fff;
                -webkit-font-smoothing: antialiased;
                font: normal 14px Roboto,arial,sans-serif;
            }

            .container {
                padding: 25px;
                position: fixed;
            }

            .form-login {
                background-color: #EDEDED;
                padding-top: 10px;
                padding-bottom: 20px;
                padding-left: 20px;
                padding-right: 20px;
                border-radius: 15px;
                border-color:#d2d2d2;
                border-width: 5px;
                box-shadow:0 1px 0 #cfcfcf;
            }

            h4 { 
                border:0 solid #fff; 
                border-bottom-width:1px;
                padding-bottom:10px;
                text-align: center;
            }

            .form-control {
                border-radius: 10px;
            }

            .wrapper {
                text-align: center;
            }



        </style> 

    </head>
    <body>
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

        <div class="container">
            <div class="row">
                <div class="col-md-offset-5 col-md-3">
                    <form action="">
                        <div class="form-login">
                            <h4>Loguinho.</h4>
                            <input type="text" id="userName" class="form-control input-sm chat-input" placeholder="username" />
                            </br>
                            <input type="text" id="userPassword" class="form-control input-sm chat-input" placeholder="password" />
                            </br>
                            <div class="wrapper">
                                <span class="group-btn">     
                                    <a href="#" class="btn btn-primary btn-md">login <i class="fa fa-sign-in"></i></a>
                                </span>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </body>
</html>
