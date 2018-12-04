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

        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>  







        <Style type="text/css"> 
            body {
                margin-top: 2%
            }


            body  {
                background-image: url("https://i.pinimg.com/originals/b7/2a/e8/b72ae8c507cfe591af1fb01910834a5e.gif"); }
            td{
                color: white;
            }

            th{
                color: white;
            }



        </style>

    </head>
    <body>

        <div class="container">
            <div class="row">
                <div class="col-md-3">
                    <form action="ManterRequisicaoController?acao=prepararOperacao&operacao=Incluir" method="POST">

                    <a href="index.jsp"><button type="button">Voltar</button></a>
                    <input type="submit" name="btnIncluir" value="incluir">
                    </form>
                </div>




             <div class="col-md-9">
                <table class="table table-list-search">
                    
                    <thead>
                    <tr>
                        <th colspan="4">Lista de trabalhos</th>
                    </tr>
                    <tr>
                        <td>Codigo</td>
                        <td>nome</td>
                        <td colspan="2">Ações</td>
                    </tr>
                 </thead>   
                    <c:forEach items="${requisicoes}" var="requisicao">
                        <tbody>
                        <tr>
                            <td>
                                <c:out value="${requisicao.id}" />
                            </td>
                            <td>
                                <c:out value="${requisicao.data}" />
                            </td>


                            <td><a href="ManterRequisicaoController?acao=prepararOperacao&operacao=Editar&id=<c:out
                                       value="${requisicao.id}" />" >Editar</a>
                            <a style="color: red" href="ManterRequisicaoController?acao=prepararOperacao&operacao=Excluir&id=<c:out
                                       value="${requisicao.id}" />" >Excluir</a></td>
                        </tr>
                    </c:forEach>
                  </tbody>        
                </table>
            </div>   
            </div>
        </div>
    </body>

</html>