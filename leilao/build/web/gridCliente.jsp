<%@page contentType = "text/html" pageEncoding="utf-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastro Cliente</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">



 
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>







        <Style type="text/css"> 
            body {
                margin-top: 2%
            }


            body  {
                background-image: linear-gradient(to top, #2bb4c8, #0086ab, #005988, #002f60, #060234);
                background-repeat: no-repeat;
                background-size: 1500px 900px;
            }
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
                    <form action="ManterClienteController?acao=prepararOperacao&operacao=Incluir" method="POST">



                        <a href="index.jsp"><button class="btn btn-outline-info" type="button">Voltar</button></a>
                        <a href="manterCliente.jsp"><input   class="btn btn-outline-info" type="submit" name="btnIncluir" value="incluir"></a>
                    </form>  
                </div>
                
                <div class="col-md-7">
                    <input type="text" id="myInput" onkeyup="myFunction()" class="form-control" placeholder="Pesquise aqui"><br>
                    
                        <script>
                            $(document).ready(function () {
                                $("#myInput").on("keyup", function () {
                                    var value = $(this).val().toLowerCase();
                                    $("#myTable tr").filter(function () {
                                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                                    });
                                });
                            });
                        </script>
                    </div> 
                </div>
            </div>

                <div class="col-md-9">
                    <div class="search-list">
                    <table class="table table-list-search table" id="myTable">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nome</th>
                                <th>CPF</th>
                                <th>Email</th>
                                <th>operações</th>


                            </tr>

                        </thead>
                        <c:forEach items="${clientes}" var="cliente">
                            <tbody>
                                <tr>
                                    <td><c:out value="${cliente.id}" /></td>
                                    <td><c:out value="${cliente.nome}" /></td>
                                    <td><c:out value="${cliente.cpf}" /></td>
                                    <td><c:out value="${cliente.email}" /></td>

                                    <td><a style="color: #00F5FF " href="ManterClienteController?acao=prepararOperacao&operacao=Editar&id=<c:out
                                               value="${cliente.id}" />" >Editar</a>

                                        <a style="color: #FF0000" href="ManterClienteController?acao=prepararOperacao&operacao=Excluir&id=<c:out
                                               value="${cliente.id}" />" > Excluir</a> 

                                    </td>

                                </tr>
                                
                            </c:forEach>

                        </tbody>
                    <hr style="height:2px; border:none; color:white; background-color: white; margin-top: 0px; margin-bottom: 0px;"/>
                    </table>   
</div>
                </div>
            </div>
        </div>        





    </body>

</html>