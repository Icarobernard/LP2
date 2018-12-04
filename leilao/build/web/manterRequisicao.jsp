<%-- 
    Document   : manterCliente
    Created on : 23/10/2018, 10:33:52
    Author     : Samsung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

    <head>
        <title></title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <style type="text/css">
body  {
    background-image: url("https://i.pinimg.com/originals/b7/2a/e8/b72ae8c507cfe591af1fb01910834a5e.gif"); }
td{
    color: white;
}
</style>

    //script FORMATAR 
  <script type="text/javascript" src="formatar.js"></script>
  

//permitir letra ou numero
<script type="text/javascript" src="validarcaracter.js"></script>  

    </head>

    <body>
        <article class="card-body">
        <form class="form-horizontal" action="ManterRequisicaoController?acao=confirmaOperacao&operacao=${operacao}" method ="POST" >
            


            <div class="container" align="center">
                <!-- Text input-->
                <table>
                    <tr >
                        <td> Código requisicao </td>
                        <td> <input type="text" name="txtId" required value="${requisicao.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>> </td> 

                    </tr>

                        <tr>
                            <td> Código trabalho </td>
                            <td> <input type="text" name="txtIdTrabalho" required value="${requisicao.idTrabalho}" onkeyup="validar(this,'numero')" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>> </td>

                        </tr>
                        
                        <tr>

                            <td>Código Cliente </td>

                            <td>
                                <input type="text" name="txtIdCliente" required value="${requisicao.idCliente}" onkeyup="validar(this,'numero')" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>    
         
                        </tr>

                        
                        <tr>
                        <td>Data</td>

                            <td>
                                <input type="date" name="txtData" required value="${trabalho.data}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>    
                        </tr>


                    <tr><td><a href="PesquisaRequisicaoController"><input type="button" value="voltar"></a></td><td colspan="3" class="tdsalvar" ><input type="submit" name="" value="salvar"></td></tr>

                </table>
            </div>
        </form>
    </article>
        </body>
    

</html>



