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
        <title>Cadastro voluntário</title>
        
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
           
    
    body  {
                background-image: linear-gradient(to right bottom, #00194c, #423771, #795997, #b17ebc, #eba5e1);
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
    //script do cep
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

//script FORMATAR 
<script type="text/javascript" src="formatar.js"></script>
  

//permitir letra ou numero
<script type="text/javascript" src="validarcaracter.js"></script> 

    </head>

    <body>
        <article class="card-body">
        <form  action="ManterAnuncianteController?acao=confirmaOperacao&operacao=${operacao}" method ="POST" >
           

               

                    <div class="container" align="center" >
                <table>
                    <tr >
                        <td> Código Voluntário: </td>
                        <td> <input type="text" name="txtIdAnunciante" required class="form-control" onkeyup="validar(this,'numero')" value="${anunciante.id}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td> 

                    </tr>

                        <tr>
                            <td> Nome: </td>
                            <td> <input type="text" name="txtNomeAnunciante" required class="form-control" onkeyup="validar(this,'texto')"  value="${anunciante.nome}" <c:if test="${operacao == 'Excluir'}"> readonly </c:if>> </td>

                        </tr>


                        <!-- Radio -->
                        <tr> 
                            <td> Sexo:</td> 
                            <td>
                                <select name="optSexoAnunciante" class="form-control" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="m" <c:if test="${anunciante.sexo== 'm'}"> selected</c:if>>Masculino</option>
                                <option value="f" <c:if test="${anunciante.sexo== 'f'}"> selected</c:if>>Feminino</option>
                                </select>
                            </td>
                        </tr>
                        <tr>

                        <tr>

                            <td>CPF: </td>

                            <td>
                                <input type="text" name="txtCpfAnunciante" required class="form-control" maxlength="14" onkeyup="validar(this,'numero')" OnKeyPress="formatar('###.###.###-##', this)" value="${anunciante.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>    


                        </tr>

                        <tr>

                            <td>Email: </td>

                            <td>
                                <input type="email" name="txtEmailAnunciante" required class="form-control" value="${anunciante.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            </td>    


                        </tr>                    




                        <tr>

                            <td>CEP: </td>
                            <td> <input id="cep" name="txtCepAnunciante" type="text" maxlength="8" required onkeyup="validar(this,'numero')" class="form-control" value="${anunciante.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr>


                        <tr>

                            <td>Complemento: </td>
                            <td> <input id="complemento" name="txtComplementoAnunciante" type="text"  class="form-control" value="${anunciante.complemento}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr>  

                        <tr>

                            <td>Logradouro: </td>
                            <td> <input id="rua" name="txtLogradouroAnunciante" type="text" required class="form-control" value="${anunciante.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr> 


                        <tr>

                            <td>Número: </td>
                            <td> <input id="numero" name="txtNumeroAnunciante" type="text" onkeyup="validar(this,'numero')" required class="form-control" value="${anunciante.numero}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr>


                        <tr>

                            <td>Bairro: </td>
                            <td> <input id="bairro" name="txtBairroAnunciante" type="text" required class="form-control" value="${anunciante.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr>


                        <tr>

                            <td>Cidade: </td>
                            <td> <input id="cidade" name="txtCidadeAnunciante" type="text" required class="form-control" value="${anunciante.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr> 

                        <tr><td><label for="uf">UF</label></td><td><select class="form-control" name="optTipoEstado" id="uf" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <option value="AC" <c:if test="${anunciante.estado.equals('AC')}"> selected</c:if>>AC</option>
                                <option value="AL" <c:if test="${anunciante.estado.equals('AL')}"> selected</c:if>>AL</option>
                                <option value="AM" <c:if test="${anunciante.estado.equals('AM')}"> selected</c:if>>AM</option>
                                <option value="AP" <c:if test="${anunciante.estado.equals('AP')}"> selected</c:if>>AP</option>
                                <option value="BA" <c:if test="${anunciante.estado.equals('BA')}"> selected</c:if>>BA</option>
                                <option value="CE" <c:if test="${anunciante.estado.equals('CE')}"> selected</c:if>>CE</option>
                                <option value="DF" <c:if test="${anunciante.estado.equals('DF')}"> selected</c:if>>DF</option>
                                <option value="ES" <c:if test="${anunciante.estado.equals('ES')}"> selected</c:if>>ES</option>
                                <option value="GO" <c:if test="${anunciante.estado.equals('GO')}"> selected</c:if>>GO</option>
                                <option value="MA" <c:if test="${anunciante.estado.equals('MA')}"> selected</c:if>>MA</option>
                                <option value="MT" <c:if test="${anunciante.estado.equals('MT')}"> selected</c:if>>MT</option>
                                <option value="MS" <c:if test="${anunciante.estado.equals('MS')}"> selected</c:if>>MS</option>
                                <option value="MG" <c:if test="${anunciante.estado.equals('MG')}"> selected</c:if>>MG</option>
                                <option value="PA" <c:if test="${anunciante.estado.equals('PA')}"> selected</c:if>>PA</option>
                                <option value="PB" <c:if test="${anunciante.estado.equals('PB')}"> selected</c:if>>PB</option>
                                <option value="PR" <c:if test="${anunciante.estado.equals('PR')}"> selected</c:if>>PR</option>
                                <option value="PE" <c:if test="${anunciante.estado.equals('PE')}"> selected</c:if>>PE</option>
                                <option value="PI" <c:if test="${anunciante.estado.equals('PI')}"> selected</c:if>>PI</option>
                                <option value="RJ" <c:if test="${anunciante.estado.equals('RJ')}"> selected</c:if>>RJ</option>
                                <option value="RN" <c:if test="${anunciante.estado.equals('RN')}"> selected</c:if>>RN</option>
                                <option value="RS" <c:if test="${anunciante.estado.equals('RS')}"> selected</c:if>>RS</option>
                                <option value="RO" <c:if test="${anunciante.estado.equals('RO')}"> selected</c:if>>RO</option>
                                <option value="RR" <c:if test="${anunciante.estado.equals('RR')}"> selected</c:if>>RR</option>
                                <option value="SC" <c:if test="${anunciante.estado.equals('SC')}"> selected</c:if>>SC</option>
                                <option value="SP" <c:if test="${anunciante.estado.equals('SP')}"> selected</c:if>>SP</option>
                                <option value="SE" <c:if test="${anunciante.estado.equals('SE')}"> selected</c:if>>SE</option>
                                <option value="TO" <c:if test="${anunciante.estado.equals('TO')}"> selected</c:if>>TO</option>   </select></td>





                        <tr>

                            <td>Telefone: </td>
                            <td> <input id="telefone" name="txtTelefoneAnunciante" required class="form-control" onkeyup="validar(this,'numero')" type="text" value="${anunciante.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr>
                        
                        

                        <tr>

                            <td>Login: </td>
                            <td> <input id="login" name="txtLoginAnunciante" type="text" required class="form-control" value="${anunciante.login}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                        </tr>

                        <tr>

                            <td>Senha</td>
                            <td> <input id="senha" name="txtSenhaAnunciante" type="password" required class="form-control" value="${anunciante.senha}"<c:if test="${operacao == 'Excluir'}"> readonly</c:if>> </td>

                    </tr>

                    <tr><td><a href="PesquisaAnuncianteController"><input type="button" value="voltar" class="btn btn-primary pull-right"></a></td><td colspan="3" class="tdsalvar" ><input type="submit" name="" value="salvar" class="btn btn-primary pull-right"></td></tr>

                </table>
                                </div>
           
        </form>
                                </article>
    </body>

</html>



