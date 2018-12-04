<%-- 
    Document   : manterCliente
    Created on : 23/10/2018, 10:33:52
    Author     : Samsung
--%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset ="UTF-8"/>
        <title>Cadastro Cliente</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
 body  {
               background-image: linear-gradient(to top, #eefdff, #9abece, #5380a2, #1e4375, #080541);  
                background-repeat: no-repeat;
                background-size: 1500px 900px;
            }

td{
    color: white;
}
</style>
 <script src="https://code.jquery.com/jquery-3.2.1.min.js"
            integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
            crossorigin="anonymous"></script>

    <!-- Adicionando Javascript -->
   
    <script type="text/javascript" >

        $(document).ready(function() {

            function limpa_formulário_cep() {
                // Limpa valores do formulário de cep.
                $("#rua").val("");
                $("#bairro").val("");
                $("#cidade").val("");
                $("#uf").val("");
                $("#ibge").val("");
            }
            
            //Quando o campo cep perde o foco.
            $("#cep").blur(function() {

                //Nova variável "cep" somente com dígitos.
                var cep = $(this).val().replace(/\D/g, '');

                //Verifica se campo cep possui valor informado.
                if (cep != "") {

                    //Expressão regular para validar o CEP.
                    var validacep = /^[0-9]{8}$/;

                    //Valida o formato do CEP.
                    if(validacep.test(cep)) {

                        //Preenche os campos com "..." enquanto consulta webservice.
                        $("#rua").val("...");
                        $("#bairro").val("...");
                        $("#cidade").val("...");
                        $("#uf").val("...");
                        $("#ibge").val("...");

                        //Consulta o webservice viacep.com.br/
                        $.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                            if (!("erro" in dados)) {
                                //Atualiza os campos com os valores da consulta.
                                $("#rua").val(dados.logradouro);
                                $("#bairro").val(dados.bairro);
                                $("#cidade").val(dados.localidade);
                                $("#uf").val(dados.uf);
                                $("#ibge").val(dados.ibge);
                            } //end if.
                            else {
                                //CEP pesquisado não foi encontrado.
                                limpa_formulário_cep();
                                alert("CEP não encontrado.");
                            }
                        });
                    } //end if.
                    else {
                        //cep é inválido.
                        limpa_formulário_cep();
                        alert("Formato de CEP inválido.");
                    }
                } //end if.
                else {
                    //cep sem valor, limpa formulário.
                    limpa_formulário_cep();
                }
            });
        });

    </script>
    
    
   
  <script type="text/javascript" src="formatar.js"></script>
  


<script type="text/javascript" src="validarcaracter.js"></script>  
    
    
    
    
    
    </head>

    <body>
       
        <article class="card-body">
        <form class="well span8" action="ManterClienteController?acao=confirmaOperacao&operacao=${operacao}" method ="POST" >
            

              

                <div class="container" align="center">
                    
                    
                    <table>
                       
                        <tr class="col-md-6 mb3">
                            <td class="span3">Código Cliente</td>
                            <td> <input type="text" class="form-control" onkeyup="validar(this,'numero')" name="txtIdCliente" value="${cliente.id}" required <c:if test="${operacao == 'Excluir'}"> readonly </c:if>> </td>

                    </tr>

                        <tr class="span3" >
                            <td class="span3"> Nome: </td>
                            <td> <input type="text" class="form-control"  onkeyup="validar(this,'texto')" placeholder= "Seu nome completo" name="txtNomeCliente" required  value="${cliente.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>> </td>

                        </tr>


                        <!-- Radio -->
                        <tr class="span3"> 
                            <td> Sexo:</td> 
                            <td>
                                <select name="optTipoSexoCliente" class="form-control"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                               
                                <option value="m"  <c:if test="${cliente.sexo== 'm'}"> selected</c:if>>Masculino</option>
                                <option value="f"  <c:if test="${cliente.sexo== 'f'}"> selected</c:if>>Feminino</option>
                                </select>
                            </td>
                        </tr>
                        <tr>

                        <tr class="span3">

                            <td>CPF: </td>

                            <td>
                                <input type="text" name="txtCpfCliente" maxlength="14" required class="form-control" placeholder="___.___.___-__" OnKeyPress="formatar('###.###.###-##', this)" onkeyup="validar(this,'numero');" value="${cliente.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>    


                        </tr>

                        <tr class="span3">

                            <td>Email: </td>

                            <td>
                                <input type="email" required class="form-control" name="txtEmailCliente" value="${cliente.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>    


                        </tr>                    


                       

                        <tr class="span3">

                            <td>CEP: </td>
                            <td> <input id="cep" name="txtCepCliente"  required class="form-control" type="text" value="${cliente.cep}" onkeyup="validar(this,'numero')" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr>


                        <tr class="span3">

                            <td>Logradouro: </td>
                            <td> <input id="rua" name="txtLogradouroCliente"  required class="form-control" placeholder="Ex(rua,avenida,etc)"type="text" value="${cliente.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr> 
                        <tr class="span3">

                            <td>Complemento: </td>
                            <td> <input id="complemento" name="txtComplementoCliente"  class="form-control"  placeholder="Ex: Casa 2" type="text" value="${cliente.complemento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr>  

                        <tr class="span3">

                            <td>Número: </td>
                            <td> <input id="numero" name="txtNumeroCliente" required class="form-control" type="text" onkeyup="validar(this,'numero')"  value="${cliente.numero}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr>


                        <tr >

                            <td>Bairro: </td>
                            <td> <input id="bairro" name="txtBairroCliente" type="text" required class="form-control" value="${cliente.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr>


                        <tr class="span3">

                            <td>Cidade: </td>
                            <td> <input id="cidade" name="txtCidadeCliente" type="text" required class="form-control" value="${cliente.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr> 

                        <tr class="span3"><td><label for="uf">UF</label></td><td><select name="optTipoEstado" id="uf" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="AC" <c:if test="${cliente.estado.equals('AC')}"> selected</c:if>>AC</option>
                                <option value="AL" <c:if test="${cliente.estado.equals('AL')}"> selected</c:if>>AL</option>
                                <option value="AM" <c:if test="${cliente.estado.equals('AM')}"> selected</c:if>>AM</option>
                                <option value="AP" <c:if test="${cliente.estado.equals('AP')}"> selected</c:if>>AP</option>
                                <option value="BA" <c:if test="${cliente.estado.equals('BA')}"> selected</c:if>>BA</option>
                                <option value="CE" <c:if test="${cliente.estado.equals('CE')}"> selected</c:if>>CE</option>
                                <option value="DF" <c:if test="${cliente.estado.equals('DF')}"> selected</c:if>>DF</option>
                                <option value="ES" <c:if test="${cliente.estado.equals('ES')}"> selected</c:if>>ES</option>
                                <option value="GO" <c:if test="${cliente.estado.equals('GO')}"> selected</c:if>>GO</option>
                                <option value="MA" <c:if test="${cliente.estado.equals('MA')}"> selected</c:if>>MA</option>
                                <option value="MT" <c:if test="${cliente.estado.equals('MT')}"> selected</c:if>>MT</option>
                                <option value="MS" <c:if test="${cliente.estado.equals('MS')}"> selected</c:if>>MS</option>
                                <option value="MG" <c:if test="${cliente.estado.equals('MG')}"> selected</c:if>>MG</option>
                                <option value="PA" <c:if test="${cliente.estado.equals('PA')}"> selected</c:if>>PA</option>
                                <option value="PB" <c:if test="${cliente.estado.equals('PB')}"> selected</c:if>>PB</option>
                                <option value="PR" <c:if test="${cliente.estado.equals('PR')}"> selected</c:if>>PR</option>
                                <option value="PE" <c:if test="${cliente.estado.equals('PE')}"> selected</c:if>>PE</option>
                                <option value="PI" <c:if test="${cliente.estado.equals('PI')}"> selected</c:if>>PI</option>
                                <option value="RJ" <c:if test="${cliente.estado.equals('RJ')}"> selected</c:if>>RJ</option>
                                <option value="RN" <c:if test="${cliente.estado.equals('RN')}"> selected</c:if>>RN</option>
                                <option value="RS" <c:if test="${cliente.estado.equals('RS')}"> selected</c:if>>RS</option>
                                <option value="RO" <c:if test="${cliente.estado.equals('RO')}"> selected</c:if>>RO</option>
                                <option value="RR" <c:if test="${cliente.estado.equals('RR')}"> selected</c:if>>RR</option>
                                <option value="SC" <c:if test="${cliente.estado.equals('SC')}"> selected</c:if>>SC</option>
                                <option value="SP" <c:if test="${cliente.estado.equals('SP')}"> selected</c:if>>SP</option>
                                <option value="SE" <c:if test="${cliente.estado.equals('SE')}"> selected</c:if>>SE</option>
                                <option value="TO" <c:if test="${cliente.estado.equals('TO')}"> selected</c:if>>TO</option>   </select></td>


    


                        <tr class="span3">

                            <td class="span3">Telefone: </td>
                            <td> <input id="telefone"maxlength="12" placeholder="(ddd)-NNNN-NNNN" OnKeyPress="formatar('##-####-####', this)" name="txtTelefoneCliente" onkeyup="validar(this,'numero')" type="text" required class="form-control" value="${cliente.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr>

                        <tr class="span3">

                            <td>Login: </td>
                            <td> <input id="login" name="txtLoginCliente" type="text" value="${cliente.login}" required class="form-control" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr>

                        <tr class="span3">

                            <td>Senha</td>
                            <td> <input id="senha" name="txtSenhaCliente" type="password" required class="form-control" value="${cliente.senha}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                    </tr>

                    <tr class="span1"><td><a  href="PesquisaClienteController"><input  type="button" class="btn btn-outline-dark" value="voltar"></a></td><td colspan="3" class="tdsalvar" ><input type="submit" name="" class="btn btn-outline-dark" value="salvar"></td></tr>

                </table>
            </div>
        </form>
                                </article>
    </body>

</html>



