package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Anunciante;
@WebServlet (name="ManterAnuncianteController", urlPatterns = "/ManterAnuncianteController")

public class ManterAnuncianteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("confirmaOperacao")) {
            confirmarOperacao(request, response);
        } else {
            if (acao.equals("prepararOperacao")) {
                try {
                    prepararOperacao(request, response);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ManterAnuncianteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    protected void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("anunciantes", Anunciante.obterTodosAnunciantes());
            if (!operacao.equals("Incluir")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Anunciante anunciante = Anunciante.obterAnunciantes(id);
                request.setAttribute("anunciante", anunciante);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterAnunciante.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String operacao = request.getParameter("operacao");
        int id = Integer.parseInt(request.getParameter("txtIdAnunciante"));
        String nome = request.getParameter("txtNomeAnunciante");
        String sexo = request.getParameter("optSexoAnunciante");
        String cpf = request.getParameter("txtCpfAnunciante");
        String email = request.getParameter("txtEmailAnunciante");
        String telefone = request.getParameter("txtTelefoneAnunciante");      
        String login = request.getParameter("txtLoginAnunciante");
        String senha = request.getParameter("txtSenhaAnunciante");
        String logradouro = request.getParameter("txtLogradouroAnunciante");
        String cep = request.getParameter("txtCepAnunciante");
       String numero = request.getParameter("txtNumeroAnunciante");
        String complemento = request.getParameter("txtComplementoAnunciante");
        String bairro = request.getParameter("txtBairroAnunciante");
        String cidade = request.getParameter("txtCidadeAnunciante");
        String estado = request.getParameter("optTipoEstado");

        try {
           // Anunciante anunciante = new Anunciante(id, nome, sexo, cpf, email, telefone, login, senha, cep, logradouro, numero, complemento, bairro, cidade, estado);
            if (operacao.trim().equals("Incluir")) {
               Anunciante anunciante = new Anunciante(nome, sexo, cpf, email, telefone, login, senha, cep, logradouro, numero, complemento, bairro, cidade, estado);
                anunciante.gravar();
            } else if (operacao.equals("Editar")) {
                Anunciante anunciante = new Anunciante(id, nome, sexo, cpf, email, telefone, login, senha, cep, logradouro, numero, complemento, bairro, cidade, estado);
                anunciante.alterar();
            } else if (operacao.equals("Excluir")) {
                Anunciante anunciante = new Anunciante(id, nome, sexo, cpf, email, telefone, login, senha, cep, logradouro, numero, complemento, bairro, cidade, estado);
                anunciante.excluir();
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAnuncianteController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
