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
        <title>Cadastro trabalho</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <style type="text/css">
body  {
    background-image: url("http://s-media-cache-ak0.pinimg.com/originals/20/70/f8/2070f812d6a581d5782c2df2f13165e8.gif"); }
td{
    color: white;
}
</style>
    </head>

    <body>
        <article class="card-body">
        <form class="form-horizontal" action="ManterTrabalhoController?acao=confirmaOperacao&operacao=${operacao}" method ="POST" >
    

            <div class="container" align="center">
                <!-- Text input-->
                <table>
                    <tr >
                        <td> Código trabalho: </td>
                        <td> <input type="text" name="txtId" value="${trabalho.id}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>> </td> 

                    </tr>

                        <tr>
                            <td> Descricao: </td>
                            <td> <input type="text" name="txtDescricao" value="${trabalho.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>> </td>

                        </tr>
                        
                        <tr>

                            <td>Data inicio: </td>

                            <td>
                                <input type="date" name="txtDataInicio" value="${trabalho.dataInicio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>    
         
                        </tr>

                        
                        <tr>
                        <td>Data fim: </td>

                            <td>
                                <input type="date" name="txtDataFim" value="${trabalho.dataFim}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>    
                        </tr>
                        
                        
                                                <tr>
                        <td>Horas: </td>

                            <td>
                                <input type="number" name="txtHoras" value="${trabalho.horas}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>    
                        </tr>

                        <!-- Radio -->
                        <tr> 
                            <td> Disponibilidade:</td> 
                            <td>
                                <select name="optDisponibilidade" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="manhã" <c:if test="${trabalho.disponibilidade== 'Manha'}"> selected</c:if>>Manhã</option>
                                <option value="tarde" <c:if test="${trabalho.disponibilidade== 'Tarde'}"> selected</c:if>>Tarde</option>
                                <option value="noite" <c:if test="${cliente.disponibilidade== 'Noite'}"> selected</c:if>>Noite</option>
                                </select>
                            </td>
                        </tr>
                        <tr>


                        <tr><td><label for="categoria">Categoria</label></td><td><select name="optCategoria" id="" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="Professores" <c:if test="${trabalho.categoria.equals('Professores')}"> selected</c:if>>Professores</option>
                                <option value="Agenciadores de Publicidade" <c:if test="${trabalho.categoria.equals('Agenciadores de Publicidade')}"> selected</c:if>>Agenciadores de Publicidade</option>
                                <option value="Profissionais de Enfermagem, Técnicos, Duchistas, Massagistas e Empregados em Hospitais e Casas de Saúde" <c:if test="${trabalho.categoria.equals('Profissionais de Enfermagem, Técnicos, Duchistas, Massagistas e Empregados em Hospitais e Casas de Saúde')}"> selected</c:if>>Profissionais de Enfermagem, Técnicos, Duchistas, Massagistas e Empregados em Hospitais e Casas de Saúde</option>
                                <option value="Propagandistas, Propagandistas-Vendedores e Vendedores de Produtos Farmacêuticos" <c:if test="${trabalho.categoria.equals('Propagandistas, Propagandistas-Vendedores e Vendedores de Produtos Farmacêuticos')}"> selected</c:if>>Propagandistas, Propagandistas-Vendedores e Vendedores de Produtos Farmacêuticos</option>
                                <option value="Músicos Profissionais" <c:if test="${trabalho.categoria.equals('Músicos Profissionais')}"> selected</c:if>>Músicos Profissionais</option>
                                <option value="CE" <c:if test="${trabalho.categoria.equals('CE')}"> selected</c:if>>CE</option>
                       </select></td>

                      
                                
                                
                     <tr >
                        <td> Código anunciante: </td>
                        <td> <input type="text" name="txtIdAnunciante" value="${trabalho.idAnunciante}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td> 

                    </tr>
                    

                    

                    <tr><td><a href="PesquisaTrabalhoController"><input type="button" class="btn btn-primary pull-right" value="voltar"></a></td><td colspan="3" class="tdsalvar" ><input class="btn btn-primary pull-right" type="submit" name="" value="salvar"></td></tr>

                </table>
          </div>
        </form>
                                </article>
    </body>

</html>



