<%@page contentType = "text/html" pageEncoding="utf-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Grid Trabalho</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="main.js"></script>

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> 




        <Style type="text/css"> 
            body {
                margin-top: 2%
            }

body  {
    background-image: url("http://s-media-cache-ak0.pinimg.com/originals/20/70/f8/2070f812d6a581d5782c2df2f13165e8.gif"); }
td{
    color: white;
}




        </style>
    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <form action="ManterTrabalhoController?acao=prepararOperacao&operacao=Incluir" method="POST">

                        <a href="index.jsp"><button class="btn btn-outline-info" type="button">Voltar</button></a>
                        <input class="btn btn-outline-info" type="submit" name="btnIncluir" value="incluir">
                    </form>
                </div>

                <div class="col-md-9">
                    <table class="table table-list-search">

                        <thead>
                            <tr>
                                <td>Codigo</td>
                                <td>nome</td>
                                <td >Operações</td>
                            </tr>
                        </thead>
                        <c:forEach items="${trabalhos}" var="trabalho">
                            <tbody>
                                <tr>
                                    <td>
                                        <c:out value="${trabalho.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${trabalho.descricao}" /><!--talvez tenha que tirar-->
                                    </td>


                                    <td><a  href="ManterTrabalhoController?acao=prepararOperacao&operacao=Editar&id=<c:out
                                               value="${trabalho.id}" />" >Editar</a>
                                   <a style="color: red" href="ManterTrabalhoController?acao=prepararOperacao&operacao=Excluir&id=<c:out
                                               value="${trabalho.id}" />" >Excluir</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>           
            </div>
        </div>
    </body>

</html>